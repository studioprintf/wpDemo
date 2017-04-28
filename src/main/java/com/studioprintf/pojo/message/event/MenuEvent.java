package com.studioprintf.pojo.message.event;

/**
 * Created by lucifer on 17-4-26.
 */
public class MenuEvent extends BaseEvent {
    private String EventKey;

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }
}
