package com.example.appRewardedVideoTest.msgTypes;

import android.content.Context;
import android.view.View;
import android.widget.Toast;
import java.util.Date;

public class MyMsgType extends HimMsgType {
    private Context context;

    public MyMsgType(Context context, String message, Date date) {
        super(message, date);
        this.context = context;
    }

    public View.OnClickListener getOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "CALLBACK TO Activity!", Toast.LENGTH_SHORT).show();
            }
        };
    }
}
