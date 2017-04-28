package com.studioprintf.service;

import com.studioprintf.pojo.message.MessageUtil;
import com.studioprintf.pojo.message.response.Article;
import com.studioprintf.pojo.message.response.NewMessage;
import com.studioprintf.pojo.message.response.TextMessage;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * Created by lucifer on 17-4-25.
 */
public class MessageHandle {

    public String processRequest(HttpServletRequest request){
        String xml = null;
        try {
            Map<String, String> requestMap = MessageUtil.parseXml(request);
            // 发送方帐号
            String fromUserName = requestMap.get("FromUserName");
            // 开发者微信号
            String toUserName = requestMap.get("ToUserName");
            // 消息类型
            String msgType = requestMap.get("MsgType");

            if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_TEXT)){
                String content = requestMap.get("Content");
                if(content.equals("你好")) {
                    TextMessage textMessage = new TextMessage();
                    textMessage.setFromUserName(toUserName);
                    textMessage.setToUserName(fromUserName);
                    textMessage.setCreateTime(System.currentTimeMillis());
                    textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                    textMessage.setContent("你也好呀");
                    xml = MessageUtil.messageToXml(textMessage);
                }
                else{
                    TextMessage textMessage = new TextMessage();
                    textMessage.setFromUserName(toUserName);
                    textMessage.setToUserName(fromUserName);
                    textMessage.setCreateTime(System.currentTimeMillis());
                    textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                    textMessage.setContent("震惊，这竟然是文本消息");
                    xml = MessageUtil.messageToXml(textMessage);
                }
            }



            else if(msgType.equals(MessageUtil.REQ_MESSAGE_TYPE_EVENT)){
                String eventType = requestMap.get("Event");

                if (eventType.equals(MessageUtil.EVENT_TYPE_SUBSCRIBE)) {
                    NewMessage newMessage = new NewMessage();
                    newMessage.setArticleCount(1);
                    List<Article> list = new ArrayList<Article>();
                    Article article = new Article();
                    article.setTitle("uxinbao!");
                    article.setDescription("强无敌");
                    article.setPicUrl("http://i4.buimg.com/4851/b1b372c8e7ef887f.jpg");
                    article.setUrl("http://www.uxinbao.com");
                    list.add(article);
                    newMessage.setArticles(list);
                    newMessage.setFromUserName(toUserName);
                    newMessage.setToUserName(fromUserName);
                    newMessage.setCreateTime(System.currentTimeMillis());
                    newMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                    xml = MessageUtil.messageToXml(newMessage);
                }

                if(eventType.equals(MessageUtil.EVENT_TYPE_CLICK)){
                    String eventKey = requestMap.get("EventKey");
                    if(eventKey.equals(MessageUtil.CLICK_TYPE_NEWS)){
                        NewMessage newMessage = new NewMessage();
                        newMessage.setArticleCount(1);
                        List<Article> list = new ArrayList<Article>();
                        Article article = new Article();
                        article.setTitle("uxinbao主页!");
                        article.setDescription("6666 CN DOTA");
                        article.setPicUrl("http://i1.piimg.com/4851/8954f12113b3b86b.jpg");
                        article.setUrl("http://www.uxinbao.com");
                        list.add(article);
                        newMessage.setArticles(list);
                        newMessage.setFromUserName(toUserName);
                        newMessage.setToUserName(fromUserName);
                        newMessage.setCreateTime(System.currentTimeMillis());
                        newMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                        xml = MessageUtil.messageToXml(newMessage);
                    }

                    else if(eventKey.equals(MessageUtil.CLICK_TYPE_TEXT)){
                        TextMessage textMessage = new TextMessage();
                        textMessage.setFromUserName(toUserName);
                        textMessage.setToUserName(fromUserName);
                        textMessage.setCreateTime(System.currentTimeMillis());
                        textMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_TEXT);
                        textMessage.setContent("回复老板一条文本信息");
                        xml = MessageUtil.messageToXml(textMessage);
                    }
                    else if(eventKey.equals(MessageUtil.CLICK_TYPE_IMAGE)){
                        NewMessage newMessage = new NewMessage();
                        newMessage.setArticleCount(1);
                        List<Article> list = new ArrayList<Article>();
                        Article article = new Article();
                        article.setTitle("图文～～!");
                        article.setDescription("6666 CN DOTA");
                        article.setPicUrl("http://i1.piimg.com/4851/8954f12113b3b86b.jpg");
                        article.setUrl("http://www.uxinbao.com");
                        list.add(article);
                        newMessage.setArticles(list);
                        newMessage.setFromUserName(toUserName);
                        newMessage.setToUserName(fromUserName);
                        newMessage.setCreateTime(System.currentTimeMillis());
                        newMessage.setMsgType(MessageUtil.RESP_MESSAGE_TYPE_NEWS);
                        xml = MessageUtil.messageToXml(newMessage);
                    }
                }
            }

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return xml;
    }
}
