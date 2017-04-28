package com.studioprintf.controller;

import com.studioprintf.pojo.WxKey;
import com.studioprintf.service.CheckUtil;
import com.studioprintf.service.MessageHandle;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * Created by lucifer on 17-4-25.
 */
@RestController("/wx") //@RestController is a stereotype annotation that combines @ResponseBody and @Controller
public class WechatController {

    @RequestMapping(method = RequestMethod.GET)
    public String newWxCheck(WxKey wxKey){
        if(CheckUtil.checkSignature(wxKey.getSignature(),wxKey.getTimestamp(),wxKey.getNonce()))
            return wxKey.getEchostr();
        return null;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String weChatService(HttpServletRequest request) throws IOException {
        MessageHandle messageHandle = new MessageHandle();
        String xml = messageHandle.processRequest(request);
        return xml;
    }


}
