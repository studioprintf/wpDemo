package com.studioprintf.controller;

import com.studioprintf.pojo.Jsapi_ticket;
import com.studioprintf.service.Sign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lucifer on 17-4-29.
 */
@Controller
public class MainController {
    @Autowired
    private HttpServletRequest request;
    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String weChatJs(){
        Jsapi_ticket jst = (Jsapi_ticket) request.getServletContext().getAttribute("jsapi_ticket");
        String url = "";
        url = request.getScheme() +"://" + request.getServerName()
                + request.getServletPath();
        if (request.getQueryString() != null){
            url += "?" + request.getQueryString();
        }
        request.setAttribute("sign",Sign.sign(jst.getTicket(),url));
        return "wxjssdkDemo";
    }
}
