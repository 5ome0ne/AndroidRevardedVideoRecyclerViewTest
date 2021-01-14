package com.example.appRewardedVideoTest.msgTypes;

import com.example.appRewardedVideoTest.MsgType;
import java.util.Date;

public class HimMsgType implements MsgType {
    private String message;
    private Date date;

    public HimMsgType(String message, Date date) {
        this.message = message;
        this.date = date;
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }
}
