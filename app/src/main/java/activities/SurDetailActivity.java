package com.example.mask_detector.activities;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mask_detector.R;
import com.example.mask_detector.adapter.SurDetailAdapter;
import com.example.mask_detector.model.SurCamera;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Random;

public class SurDetailActivity extends AppCompatActivity {
    RecyclerView rv;
    ArrayList<SurCamera> cameraFrames;
    int camera;
    String camValue = "Cam 1";
    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
    TextView connection, status;
    ImageView ivconnection, ivstatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sur_detail);
        camera = getIntent().getExtras().getInt("camera");

        cameraFrames = new ArrayList<>();
        rv = findViewById(R.id.rv);
        connection = findViewById(R.id.connection);
        ivconnection = findViewById(R.id.ivconnection);
        status = findViewById(R.id.status);
        ivstatus = findViewById(R.id.ivstatus);
        TextView name = findViewById(R.id.name);
        TextView lat = findViewById(R.id.lat);
        TextView lon = findViewById(R.id.lon);
        TextView place = findViewById(R.id.place);

        switch (camera) {
            case 0:
                camValue = "Cam 1";
                break;
            case 1:
                camValue = "Cam 2";
                break;
            case 2:
                camValue = "Cam 3";
                break;
            case 3:
                camValue = "Cam 4";
                break;
        }
        setConnection();
        setStatus();
        dbRef.child("Cameras").child(camValue).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cameraFrames.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    SurCamera frames = snapshot.getValue(SurCamera.class);
                    cameraFrames.add(frames);
                }

                name.setText("Camera@" + camera + "_" + cameraFrames.get(0).getLatitude().concat(cameraFrames.get(0).getLongitude()));
                lat.setText("Latitude: ".concat(cameraFrames.get(0).getLatitude()));
                lon.setText("Longitude: ".concat(cameraFrames.get(0).getLongitude()));
                place.setText("Place: " + cameraFrames.get(0).getPlace());

                rv.setAdapter(new SurDetailAdapter(getApplicationContext(), cameraFrames));
                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void setConnection() {
        Random random = new Random();
        int rand = random.nextInt(4);
        switch (rand) {
            case 0:
                connection.setText("Stable");
                ivconnection.setImageResource(R.drawable.ic_tick);
                break;
            case 1:
                connection.setText("Slow");
                ivconnection.setImageResource(R.drawable.ic_tick);
                break;
            case 2:
                connection.setText("Unstable");
                ivconnection.setImageResource(R.drawable.ic_warning);

                break;
            case 3:
                connection.setText("Unavailable");
                ivconnection.setImageResource(R.drawable.ic_alert);
                break;

        }
    }

    private void setStatus() {
        Random random = new Random();
        int rand = random.nextInt(4);
        switch (rand) {
            case 0:
                status.setText("Connected");
                ivstatus.setImageResource(R.drawable.green);
                break;
            case 1:
                connection.setText("Disconnected");
                ivstatus.setImageResource(R.drawable.red);
                break;
        }
    }

}