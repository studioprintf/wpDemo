package com.studioprintf.service;

import java.util.Arrays;
import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by lucifer on 17-4-25.
 */
public class CheckUtil {
    private static final String token = "weixin";  //微信预设token值
    public static boolean checkSignature(String signature,String timestamp,String nonce){
        String[] arr = new String[] { token, timestamp, nonce };
        Arrays.sort(arr);  //进行字典序排序
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            content.append(arr[i]);
        }//生成字符串

        String temp = getSHA1String(content.toString());
        //使用sha1对字符串进行加密

        return temp.equals(signature); // 与微信传递过来的签名进行比较
    }

    private static String getSHA1String(String data){
        return DigestUtils.sha1Hex(data);    // 使用commons codec生成sha1字符串
    }
}
