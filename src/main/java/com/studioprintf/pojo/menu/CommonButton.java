package com.studioprintf.pojo.menu;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lucifer on 17-4-26.
 */

public class CommonButton extends Button {
    @Autowired
    private String type;
    @Autowired
    private String key;

    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getType() {

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
