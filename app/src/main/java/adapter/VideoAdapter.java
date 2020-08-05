package com.example.mask_detector.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mask_detector.R;
import com.example.mask_detector.activities.AllContentActivity;
import com.example.mask_detector.model.VideoDataUtil;

import java.util.ArrayList;


public class VideoAdapter extends RecyclerView.Adapter<VideoAdapter.ExampleViewHolder> {
    private ArrayList<VideoDataUtil> mExampleList;
    private Context context;

    public VideoAdapter(ArrayList<VideoDataUtil> exampleList, Context context) {
        this.mExampleList = exampleList;
        this.context = context;
    }

    @Override
    public ExampleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.video_item, parent, false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(ExampleViewHolder holder, final int position) {
        final VideoDataUtil currentItem = mExampleList.get(position);
        // Glide
        String url = "https://img.youtube.com/vi/" + currentItem.getUrl().split("=")[1] + "/0.jpg";
        Glide.with(context).load(url).into(holder.thumb);
        holder.name.setText(currentItem.getName());

        holder.rl_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context, AllContentActivity.class);
                i.putExtra("video", currentItem);
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return mExampleList.size();

    }

    public static class ExampleViewHolder extends RecyclerView.ViewHolder {
        public ImageView thumb;
        public TextView name;
        private RelativeLayout rl_item;

        public ExampleViewHolder(View itemView) {
            super(itemView);
            thumb = itemView.findViewById(R.id.videoWebView);
            name = itemView.findViewById(R.id.textView2);
            rl_item = itemView.findViewById(R.id.rl_item);
        }
    }
}
