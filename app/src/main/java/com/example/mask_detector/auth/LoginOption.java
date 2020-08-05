package com.example.mask_detector.auth;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.mask_detector.R;


public class LoginOption extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_login_option, container, false);
        Button user=view.findViewById(R.id.btn_user);
        user.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                phoneNumberFragment phoneNumberFragment = new phoneNumberFragment();
                getActivity().getSupportFragmentManager().beginTransaction().replace(R.id.container, phoneNumberFragment).addToBackStack(null).commit();
            }
        });

        return view;
    }
}