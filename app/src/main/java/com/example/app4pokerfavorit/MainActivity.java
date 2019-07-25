package com.example.app4pokerfavorit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.app4pokerfavorit.msgTypes.AdsMsgType;
import com.example.app4pokerfavorit.msgTypes.HimMsgType;
import com.example.app4pokerfavorit.msgTypes.MyMsgType;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity implements RewardedVideoAdListener {

    private static final String AD_UNIT_ID = "ca-app-pub-3940256099942544/5224354917";
    private RewardedVideoAd mRewardedVideoAd;
    private RecyclerView mRecyclerView;

    MultipleTypesAdapter mMultipleTypesAdapter;
    List<MsgType> msgTypeArrayList = new ArrayList<>();
    Random mRandom = new Random(new Date().getTime());
    private int numberMgs = 211;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize the Mobile Ads SDK.
        MobileAds.initialize(this, String.valueOf(R.string.app_id));

        mRewardedVideoAd = MobileAds.getRewardedVideoAdInstance(this);
        mRewardedVideoAd.setRewardedVideoAdListener(this);

        loadRewardedVideoAd();

        //-------------------------------------
        mRecyclerView = findViewById(R.id.recycler_view);

        //load messages
        for (int i = 0; i < numberMgs; i++) {
            switch (mRandom.nextInt(3)) {
                case 0 :
                    msgTypeArrayList.add(new MyMsgType(this,"My message " + i, new Date(new Date().getTime() + mRandom.nextInt())));
                    break;
                case 1 :
                    msgTypeArrayList.add(new HimMsgType("Him message " + i, new Date(new Date().getTime() + mRandom.nextInt())));
                    break;
                case 2 :
                    msgTypeArrayList.add(new AdsMsgType(this));
            }
        }

        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mMultipleTypesAdapter = new MultipleTypesAdapter(msgTypeArrayList);
        mRecyclerView.setAdapter(mMultipleTypesAdapter);
        //-------------------------------------
    }

    private void loadRewardedVideoAd() {
        if (!mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.loadAd(AD_UNIT_ID, new AdRequest.Builder().build());
        }
    }

    public void showRewardedVideoAd() {
        if (mRewardedVideoAd.isLoaded()) {
            mRewardedVideoAd.show();
        }
    }

    @Override
    public void onRewardedVideoAdLoaded() {
//        Toast.makeText(this, "onRewardedVideoAdLoaded", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdOpened() {
//        Toast.makeText(this, "onRewardedVideoAdOpened", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoStarted() {
//        Toast.makeText(this, "onRewardedVideoStarted", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdClosed() {
//        Toast.makeText(this, "onRewardedVideoAdClosed", Toast.LENGTH_SHORT).show();
        loadRewardedVideoAd();
    }

    @Override
    public void onRewarded(RewardItem rewardItem) {
//        Toast.makeText(this, "onRewarded ->" + rewardItem.toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdLeftApplication() {
//        Toast.makeText(this, "onRewardedVideoAdLeftApplication", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoAdFailedToLoad(int i) {
//        Toast.makeText(this, "onRewardedVideoAdFailedToLoad -> " + i, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRewardedVideoCompleted() {
//        Toast.makeText(this, "onRewardedVideoCompleted", Toast.LENGTH_SHORT).show();
    }
}
