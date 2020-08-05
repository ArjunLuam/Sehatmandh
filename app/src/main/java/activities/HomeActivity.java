package com.example.mask_detector.activities;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.mask_detector.R;
import com.example.mask_detector.auth.Login;
import com.example.mask_detector.fragments.DocumentsFragment;
import com.example.mask_detector.fragments.HomeFragment;
import com.example.mask_detector.fragments.MediaFragment;
import com.example.mask_detector.fragments.ProfileFragment;
import com.example.mask_detector.fragments.ScanQRFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity {

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            item -> {
                Fragment selectedFragment = null;
                switch (item.getItemId()) {
                    case R.id.nav_home:
                        selectedFragment = new HomeFragment();
                        break;
                    case R.id.nav_doc:
                        selectedFragment = new DocumentsFragment();
                        break;
                    case R.id.nav_favorites:
                        selectedFragment = new ScanQRFragment();
                        break;
                    case R.id.nav_media:
                        selectedFragment = new MediaFragment();
                        break;
                    case R.id.nav_search:
                        selectedFragment = new ProfileFragment();
                        break;
                }
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                        selectedFragment).commit();
                return true;
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        BottomNavigationView bottomNav = findViewById(R.id.bottom_navigation);
        bottomNav.setOnNavigationItemSelectedListener(navListener);

        if (FirebaseAuth.getInstance().getCurrentUser() == null) {
            startActivity(new Intent(this, Login.class));
            finish();
        } else {
            Toast.makeText(this, FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber(), Toast.LENGTH_SHORT).show();
        }
        //I added this if statement to keep the selected fragment when rotating the device
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new HomeFragment()).commit();
        }
    }
}