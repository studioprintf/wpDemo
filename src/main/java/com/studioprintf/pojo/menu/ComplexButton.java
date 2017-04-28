package com.studioprintf.pojo.menu;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lucifer on 17-4-26.
 */
public class ComplexButton extends Button {
    @Autowired
    private Button[] sub_button;

    public Button[] getSub_button() {
        return sub_button;
    }

    public void setSub_button(Button[] sub_button) {
        this.sub_button = sub_button;
    }
}
