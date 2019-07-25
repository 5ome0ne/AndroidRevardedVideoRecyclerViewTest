package com.example.app4pokerfavorit.msgTypes;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import com.example.app4pokerfavorit.MsgType;
import java.util.Date;

public class MyMsgType implements MsgType {
    private Context context;
    private String message;
    private Date date;

    public MyMsgType(Context context, String message, Date date) {
        this.context = context;
        this.message = message;
        this.date = date;
    }

    public View.OnClickListener getOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "CALLBACK TO Activity!", Toast.LENGTH_SHORT).show();
            }
        };
    }

    public String getMessage() {
        return message;
    }

    public Date getDate() {
        return date;
    }
}
