package com.example.mask_detector.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.mask_detector.R;
import com.example.mask_detector.activities.ShowRecommendedActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class RecVideoAdapter extends RecyclerView.Adapter<RecVideoAdapter.VideoHolder> {
    HashMap<String, String> videos;
    Context context;
    ArrayList<String> videosNames;


    public RecVideoAdapter(HashMap<String, String> videos, Context context) {
        this.videos = videos;
        this.context = context;
        Set<String> set = videos.keySet();
        videosNames = new ArrayList<>(set);
    }

    @NonNull
    @Override
    public VideoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View v = inflater.inflate(R.layout.video_item, parent, false);
        VideoHolder vh = new VideoHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull VideoHolder holder, final int position) {
        // Glide
        String url = "https://img.youtube.com/vi/" + videos.get(videosNames.get(position)).split("=")[1] + "/0.jpg";
        Glide.with(context).load(url).into(holder.iv);
        holder.tv.setText(videosNames.get(position));
        holder.rl_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    Intent i = new Intent(context, ShowRecommendedActivity.class);
                    i.putExtra("recVideo", videos.get(videosNames.get(position)));
                    context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return videos.size();
    }

    public class VideoHolder extends RecyclerView.ViewHolder {
        TextView tv;
        ImageView iv;
        private RelativeLayout rl_item;
        public VideoHolder(@NonNull View itemView) {
            super(itemView);
            tv = itemView.findViewById(R.id.textView2);
            iv = itemView.findViewById(R.id.videoWebView);
            rl_item = itemView.findViewById(R.id.rl_item);

        }
    }
}
