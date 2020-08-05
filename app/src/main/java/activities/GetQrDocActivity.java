package com.example.mask_detector.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.mask_detector.R;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

public class GetQrDocActivity extends AppCompatActivity {
    String url;
    ProgressBar pb;
    ImageView ivDoc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_qr_doc);
        if (getIntent().getExtras() != null)
            url = getIntent().getExtras().getString("url");
        pb = findViewById(R.id.pb);
        ivDoc = findViewById(R.id.document);
        loadDocument(url);
    }

    private void loadDocument(String url) {
        Picasso.get()
                .load(url)
                .fit()
                .centerCrop()
                .into(ivDoc, new Callback() {
                    @Override
                    public void onSuccess() {
                        pb.setVisibility(View.GONE);
                    }

                    @Override
                    public void onError(Exception e) {
                        pb.setVisibility(View.GONE);
                    }
                });
    }
}