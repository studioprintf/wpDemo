package com.studioprintf.pojo;

/**
 * Created by lucifer on 17-4-26.
 */
public class Access_token {
    private String access_token;  //获取到的凭证
    private int expires_in;       //凭证有效时间，单位：秒

    public int getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(int expires_in) {
        this.expires_in = expires_in;
    }

    public String getAccess_token() {

        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }
}
