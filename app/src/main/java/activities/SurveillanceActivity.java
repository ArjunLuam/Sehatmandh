package com.example.mask_detector.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mask_detector.R;
import com.example.mask_detector.adapter.SurAdapter;
import com.example.mask_detector.model.SurCamera;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class SurveillanceActivity extends AppCompatActivity {
    DatabaseReference dbRef = FirebaseDatabase.getInstance().getReference();
    ArrayList<ArrayList<SurCamera>> cameras;
    ArrayList<SurCamera> cam1;
    ArrayList<SurCamera> cam2;
    ArrayList<SurCamera> cam3;
    ArrayList<SurCamera> cam4;
    RecyclerView rv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_surveillance);
        cam1 = new ArrayList<>();
        cam2 = new ArrayList<>();
        cam3 = new ArrayList<>();
        cam4 = new ArrayList<>();
        cameras = new ArrayList<>();
        rv = findViewById(R.id.rv);

        dbRef.child("Cameras").child("Cam 1").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cam1.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    SurCamera frames = snapshot.getValue(SurCamera.class);
                    cam1.add(frames);
                }
                cameras.add(cam1);
                callCam2();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void callCam2() {
        dbRef.child("Cameras").child("Cam 2").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cam2.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    SurCamera frames = snapshot.getValue(SurCamera.class);
                    cam2.add(frames);
                }
                cameras.add(cam2);
                callCam3();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void callCam3() {
        dbRef.child("Cameras").child("Cam 3").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cam3.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    SurCamera frames = snapshot.getValue(SurCamera.class);
                    cam3.add(frames);
                }
                cameras.add(cam3);
                callCam4();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void callCam4() {
        dbRef.child("Cameras").child("Cam 4").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                cam4.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    SurCamera frames = snapshot.getValue(SurCamera.class);
                    cam4.add(frames);
                }
                cameras.add(cam4);
                findViewById(R.id.pb).setVisibility(View.GONE);
                rv.setAdapter(new SurAdapter(getApplicationContext(), cameras));
                rv.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                Log.d("Cameras", String.valueOf(cameras.size()));
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}