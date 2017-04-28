package com.studioprintf.service;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.studioprintf.pojo.Access_token;
import com.studioprintf.pojo.menu.Menu;
import org.springframework.stereotype.Service;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.servlet.ServletContext;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.URL;

/**
 * Created by lucifer on 17-4-26.
 */
@Service
public class RequestManager {
    private final String access_token_url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET";
    private final String menu_create_url = "https://api.weixin.qq.com/cgi-bin/menu/create?access_token=ACCESS_TOKEN";

    public String httpsGetJson(String requestUrl, String requestMethod, String outputStr) {
        String json = null;
        try {
            URL url = new URL(requestUrl);
            HttpsURLConnection httpURLConnection = (HttpsURLConnection) url.openConnection();

            TrustManager[] tm = {new SSLTrustManager()};
            SSLContext sslContext = SSLContext.getInstance("SSL", "SunJSSE");
            sslContext.init(null, tm, new java.security.SecureRandom());
            // 从上述SSLContext对象中得到SSLSocketFactory对象
            SSLSocketFactory ssf = sslContext.getSocketFactory();

            httpURLConnection.setSSLSocketFactory(ssf);
            httpURLConnection.setDoOutput(true);
            httpURLConnection.setDoInput(true);

            httpURLConnection.setRequestMethod(requestMethod);

            if ("GET".equalsIgnoreCase(requestMethod))
                httpURLConnection.connect();

            // 当有数据需要提交时
            if (null != outputStr) {
                OutputStream outputStream = httpURLConnection.getOutputStream();
                // 注意编码格式，防止中文乱码
                outputStream.write(outputStr.getBytes("UTF-8"));
                outputStream.close();
            }

            InputStream inputStream = httpURLConnection.getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            StringBuffer buffer = new StringBuffer();
            String str = null;
            while ((str = bufferedReader.readLine()) != null) {
                buffer.append(str);
            }
            bufferedReader.close();
            inputStreamReader.close();
            // 释放资源
            inputStream.close();
            httpURLConnection.disconnect();
            //输出返回结果
            json = buffer.toString();
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return json;
    }

    public Access_token getAccess_token(String appId,String appSecret) {
        String tokenUrl = access_token_url.replace("APPID", appId).replace("APPSECRET", appSecret);
        String jsonToken = httpsGetJson(tokenUrl,"GET",null);
        Gson gson = new Gson();
        Access_token access_token = gson.fromJson(jsonToken,Access_token.class);
        return access_token;
    }

    public int createMenu(Access_token access_token, Menu menu){
        Gson gson = new Gson();
        String menuUrl = menu_create_url.replace("ACCESS_TOKEN",access_token.getAccess_token());
        String menuJson = gson.toJson(menu);
        String resultJson = httpsGetJson(menuUrl,"POST",menuJson);
        return 0;
    }
}
