package com.example.appRewardedVideoTest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.appRewardedVideoTest.msgTypes.AdsMsgType;
import com.example.appRewardedVideoTest.msgTypes.HimMsgType;
import com.example.appRewardedVideoTest.msgTypes.MyMsgType;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Locale;

public class MultipleTypesAdapter extends RecyclerView.Adapter {

    private List<MsgType> mMsgTypes;

    public MultipleTypesAdapter(List<MsgType> dataSet) {
        this.mMsgTypes = dataSet;
    }

    @Override
    public int getItemViewType(int position) {
        if (mMsgTypes.get(position) instanceof MyMsgType) {
            return MsgType.MY_MSG_TYPE;
        } else if (mMsgTypes.get(position) instanceof HimMsgType) {
            return MsgType.HIM_MSG_TYPE;
        } else if (mMsgTypes.get(position) instanceof AdsMsgType) {
            return MsgType.ADS_MSG_TYPE;
        } else {
            return -1;
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == MsgType.MY_MSG_TYPE) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.msg_my, parent, false);
            return new MyViewHolder(view);
        } else if (viewType == MsgType.HIM_MSG_TYPE) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.msg_him, parent, false);
            return new HimViewHolder(view);
        } else if (viewType == MsgType.ADS_MSG_TYPE) {
            View view = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.msg_ads, parent, false);
            return new AdsViewHolder(view);
        } else {
            return null;
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy", Locale.ROOT);

        if (holder instanceof MyViewHolder) {
            ((MyViewHolder) holder).linearLayout
                    .setOnClickListener(((MyMsgType) mMsgTypes.get(position)).getOnClickListener());
            ((MyViewHolder) holder).textViewMsg
                    .setText(((MyMsgType) mMsgTypes.get(position)).getMessage());
            ((MyViewHolder) holder).textViewDate
                    .setText(format.format(((MyMsgType) mMsgTypes.get(position)).getDate()));
            ((MyViewHolder) holder).imageView
                    .setImageResource(R.drawable.ic_arrow_forward_black_24dp);
        } else if (holder instanceof HimViewHolder) {
            ((HimViewHolder) holder).textViewMsg
                    .setText(((HimMsgType) mMsgTypes.get(position)).getMessage());
            ((HimViewHolder) holder).textViewDate
                    .setText( format.format(((HimMsgType) mMsgTypes.get(position)).getDate()));
            ((HimViewHolder) holder).imageView
                    .setImageResource(R.drawable.ic_arrow_back_black_24dp);
        } else if (holder instanceof AdsViewHolder) {
            ((AdsViewHolder) holder).button
                    .setOnClickListener(((AdsMsgType) mMsgTypes.get(position)).getOnClickListener());
        }
    }

    @Override
    public int getItemCount() {
        return mMsgTypes.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public LinearLayout linearLayout;
        private TextView textViewMsg;
        private TextView textViewDate;
        private ImageView imageView;

        public MyViewHolder(View itemView) {
            super(itemView);
            linearLayout = itemView.findViewById(R.id.linearLayout);
            textViewMsg = itemView.findViewById(R.id.textViewMessage);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    public static class HimViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewMsg;
        private TextView textViewDate;
        private ImageView imageView;

        public HimViewHolder(View itemView) {
            super(itemView);
            textViewMsg = itemView.findViewById(R.id.textViewMessage);
            textViewDate = itemView.findViewById(R.id.textViewDate);
            imageView = itemView.findViewById(R.id.imageView);
        }
    }

    public static class AdsViewHolder extends RecyclerView.ViewHolder {

        private Button button;

        public AdsViewHolder(View itemView) {
            super(itemView);
            button = itemView.findViewById(R.id.buttonShow);
        }
    }
}
