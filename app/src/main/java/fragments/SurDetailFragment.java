package com.example.mask_detector.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.mask_detector.R;
import com.example.mask_detector.model.SurCamera;

import java.util.ArrayList;


public class SurDetailFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sur_detail, container, false);
        ArrayList<SurCamera> surCameras = (ArrayList<SurCamera>) getActivity().getIntent().getExtras().getSerializable("masks");
        Toast.makeText(getContext(), surCameras.get(0).getPlace(), Toast.LENGTH_SHORT).show();
        return v;
    }
}