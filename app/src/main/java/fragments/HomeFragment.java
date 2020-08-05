package com.example.mask_detector.fragments;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.mask_detector.R;
import com.example.mask_detector.activities.ShowDocActivity;
import com.example.mask_detector.activities.SurveillanceActivity;
import com.google.firebase.auth.FirebaseAuth;

public class HomeFragment extends Fragment {
    TextView welcome;
    private CardView cv1, cv2, cv3;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        cv1 = v.findViewById(R.id.cardView2);
        cv2 = v.findViewById(R.id.cardView3);
        cv1.setOnClickListener(appointment -> {
            startActivity(new Intent(getContext(), SurveillanceActivity.class));
        });
        cv2.setOnClickListener(read -> {
            startActivity(new Intent(getContext(), ShowDocActivity.class));
        });
        v.findViewById(R.id.helpCard4).setOnClickListener(paytm -> {
//            net.one97.paytm
            if (appInstalledOrNot("net.one97.paytm")) {
                //open bitbns
                Intent launchIntent = getContext().getPackageManager().getLaunchIntentForPackage("net.one97.paytm");
                if (launchIntent != null) {
                    getContext().startActivity(launchIntent);//null pointer check in case package name was not found
                }
            } else {
                openWebsiteOnWeb("https://paytm.com/");
            }
        });
        v.findViewById(R.id.helpCard5).setOnClickListener(help -> {
            Intent intent = new Intent(Intent.ACTION_DIAL);
            intent.setData(Uri.parse("tel:" + "1075"));
            startActivity(intent);
        });
        welcome = v.findViewById(R.id.welcome);
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            String name = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
            welcome.setText("WELCOME, ".concat(name));
        } else {
            welcome.setText("WELCOME, ".concat("User"));
        }
        return v;
    }

    //check and redirect to huobi, gateio, binance and kucoin app in playstore to download
    private boolean appInstalledOrNot(String uri) {
        PackageManager pm = getContext().getPackageManager();
        try {
            pm.getPackageInfo(uri, PackageManager.GET_ACTIVITIES);
            return true;
        } catch (PackageManager.NameNotFoundException ignored) {
        }

        return false;
    }

    private void openWebsiteOnWeb(String website) {
        Intent webIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
        webIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        getContext().startActivity(webIntent);
    }
}