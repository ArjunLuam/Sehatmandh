package com.example.mask_detector.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mask_detector.R;
import com.example.mask_detector.activities.SurDetailActivity;
import com.example.mask_detector.model.SurCamera;

import java.util.ArrayList;
import java.util.Random;

import static android.content.Intent.FLAG_ACTIVITY_NEW_TASK;

public class SurAdapter extends RecyclerView.Adapter<SurAdapter.ViewHolder> implements View.OnClickListener {
    Context context;
    ArrayList<ArrayList<SurCamera>> cameras;

    public SurAdapter(Context context, ArrayList<ArrayList<SurCamera>> cameras) {
        this.context = context;
        this.cameras = cameras;
        Log.d("CamerasAdapter", String.valueOf(cameras.size()));
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_camera, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        SurCamera surCamera = cameras.get(position).get(0);
        holder.name.setText("Camera@" + position + "_" + surCamera.getLatitude().concat(surCamera.getLongitude()));
        holder.lat.setText("Latitude: " + surCamera.getLatitude());
        holder.lon.setText("Longitude: " + surCamera.getLongitude());
        setStatus(holder, position);
        setConnection(holder, position);
        holder.place.setText("Place: " + surCamera.getPlace());

        holder.cv.setOnClickListener(details -> {
            Intent i = new Intent(context, SurDetailActivity.class);
            i.putExtra("camera", position);
            i.addFlags(FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(i);
        });
    }

    private void setConnection(ViewHolder holder, int position) {
        Random random = new Random();
        int rand = random.nextInt(4);
        switch (rand) {
            case 0:
                holder.connection.setText("Stable");
                holder.ivconnection.setImageResource(R.drawable.ic_tick);
                break;
            case 1:
                holder.connection.setText("Slow");
                holder.ivconnection.setImageResource(R.drawable.ic_warning);
                break;
            case 2:
                holder.connection.setText("Unstable");
                holder.ivconnection.setImageResource(R.drawable.ic_warning);

                break;
            case 3:
                holder.connection.setText("Unavailable");
                holder.ivconnection.setImageResource(R.drawable.ic_alert);
                break;

        }
    }

    private void setStatus(ViewHolder holder, int position) {
        Random random = new Random();
        int rand = random.nextInt(4);
        switch (rand) {
            case 0:
                holder.status.setText("Connected");
                holder.ivstatus.setImageResource(R.drawable.green);
                break;
            case 1:
                holder.connection.setText("Disconnected");
                holder.ivstatus.setImageResource(R.drawable.red);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return cameras.size();
    }

    @Override
    public void onClick(View v) {
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, lat, lon, status, connection, place;
        CardView cv;
        ImageView ivstatus, ivconnection;

        public ViewHolder(@NonNull View i) {
            super(i);
            name = i.findViewById(R.id.name);
            lat = i.findViewById(R.id.lat);
            lon = i.findViewById(R.id.lon);
            status = i.findViewById(R.id.status);
            connection = i.findViewById(R.id.connection);
            place = i.findViewById(R.id.place);
            cv = i.findViewById(R.id.cam);
            ivstatus = i.findViewById(R.id.ivstatus);
            ivconnection = i.findViewById(R.id.ivconnection);

        }
    }
}
