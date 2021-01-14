package com.example.appRewardedVideoTest.msgTypes;

import android.content.Context;
import android.view.View;
import com.example.appRewardedVideoTest.MainActivity;
import com.example.appRewardedVideoTest.MsgType;

public class AdsMsgType implements MsgType {
    private Context context;

    public AdsMsgType(Context context) {
        this.context = context;
    }

    public View.OnClickListener getOnClickListener() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (context instanceof MainActivity){
                    ((MainActivity)context).showRewardedVideoAd();
                }
            }
        };
    }
}
