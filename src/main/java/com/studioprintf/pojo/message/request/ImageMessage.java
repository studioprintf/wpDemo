package com.studioprintf.pojo.message.request;



/**st
 * Created by lucifer on 17-4-25.
 */
public class ImageMessage extends BaseMessage {
    private String PicUrl;    //图片链接（由系统生成）
    private String MediaId;   //图片消息媒体id，可以调用多媒体文件下载接口拉取数据

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }
}
