package com.example.mask_detector.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mask_detector.R;
import com.example.mask_detector.model.SurCamera;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.TimeZone;

public class SurDetailAdapter extends RecyclerView.Adapter<SurDetailAdapter.ViewHolder> {
    Context context;
    ArrayList<SurCamera> cameraFrames;

    public SurDetailAdapter(Context context, ArrayList<SurCamera> cameraFrames) {
        this.context = context;
        this.cameraFrames = cameraFrames;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.frame_detail, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.mask.setText(cameraFrames.get(position).getMask());
        holder.nomask.setText(cameraFrames.get(position).getNo_mask());
        holder.time.setText("Timestamp: Sun Jun 21 2020 ".concat(getTime()));
    }

    private String getTime() {
        DateFormat df = DateFormat.getTimeInstance();
        df.setTimeZone(TimeZone.getTimeZone("gmt"));
        return df.format(new Date());
    }

    @Override
    public int getItemCount() {
        return cameraFrames.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView mask, nomask, time;

        public ViewHolder(@NonNull View i) {
            super(i);
            mask = i.findViewById(R.id.mask);
            nomask = i.findViewById(R.id.without_mask);
            time = i.findViewById(R.id.time);
        }
    }
}
