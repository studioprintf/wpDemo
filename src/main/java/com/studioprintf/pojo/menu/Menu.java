package com.studioprintf.pojo.menu;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by lucifer on 17-4-26.
 */

public class Menu {
    @Autowired
    private Button[] button;

    public Button[] getButton() {
        return button;
    }

    public void setButton(Button[] button) {
        this.button = button;
    }
}
