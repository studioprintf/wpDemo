package com.studioprintf.listener;

import com.studioprintf.pojo.Access_token;
import com.studioprintf.pojo.menu.Button;
import com.studioprintf.pojo.menu.CommonButton;
import com.studioprintf.pojo.menu.ComplexButton;
import com.studioprintf.pojo.menu.Menu;
import com.studioprintf.service.RequestManager;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by lucifer on 17-4-26.
 */
public class Access_tokenListener implements ServletContextListener {
    private static final String appid = "wx85b51ac5e678f28a";
    private static final String appSecret = "2b13a902f81458f93611d00cdaf37aae";
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        final ServletContext context = servletContextEvent.getServletContext();
        final RequestManager requestManager = new RequestManager();

        Access_token access_token = getAccess_token(requestManager);
        context.setAttribute("access_token",access_token);
        requestManager.createMenu(access_token,getMenu());

        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Access_token access_token = requestManager.getAccess_token("wx85b51ac5e678f28a","2b13a902f81458f93611d00cdaf37aae");
                context.setAttribute("access_token",access_token);
            }
        },7200*1000,7200*1000); //延时7200秒执行，每7200秒执行一次
    }

    public void contextDestroyed(ServletContextEvent servletContextEvent) {

    }

    private Menu getMenu() {
        CommonButton mainBtn1 = new CommonButton();
        mainBtn1.setName("菜单A");
        mainBtn1.setType("click");
        mainBtn1.setKey("11");

        CommonButton btn21 = new CommonButton();
        btn21.setName("点击可进入一个网页页面");
        btn21.setType("view");
        btn21.setUrl("http://www.uxinbao.com/");

        CommonButton btn22 = new CommonButton();
        btn22.setName("点击回复一条文本消息");
        btn22.setType("click");
        btn22.setKey("22");

        CommonButton btn23 = new CommonButton();
        btn23.setName("点击回复一条图文消息");
        btn23.setType("click");
        btn23.setKey("23");

        /**
         * 微信：  mainBtn1,mainBtn2底部的两个个一级菜单。
         */

        ComplexButton mainBtn2 = new ComplexButton();
        mainBtn2.setName("菜单B");
        mainBtn2.setSub_button(new CommonButton[] { btn21, btn22, btn23});


        /**
         * 封装整个菜单
         */
        Menu menu = new Menu();
        menu.setButton(new Button[] { mainBtn1, mainBtn2});

        return menu;
    }

    private Access_token getAccess_token(RequestManager requestManager){
        return requestManager.getAccess_token(appid,appSecret);
    }
}
