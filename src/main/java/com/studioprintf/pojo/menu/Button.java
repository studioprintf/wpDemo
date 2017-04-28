package com.studioprintf.pojo.menu;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lucifer on 17-4-26.
 */
public class Button {
    @Autowired
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
