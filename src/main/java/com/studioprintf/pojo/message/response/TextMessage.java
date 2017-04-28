package com.studioprintf.pojo.message.response;

/**
 * Created by lucifer on 17-4-25.
 */
public class TextMessage extends BaseMessage{
    private String Content; //回复的消息内容（换行：在content中能够换行，微信客户端就支持换行显示）

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }
}
