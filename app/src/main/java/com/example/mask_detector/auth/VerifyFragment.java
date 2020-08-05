package com.example.mask_detector.auth;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.alimuzaffar.lib.pin.PinEntryEditText;
import com.example.mask_detector.R;
import com.example.mask_detector.activities.HomeActivity;
import com.example.mask_detector.model.Constants;
import com.google.android.gms.tasks.TaskExecutors;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;


public class VerifyFragment extends Fragment {
    private String verificationId;
    private FirebaseAuth mAuth;
    private String phoneNumber;

    private PinEntryEditText pinEntryEditText;
    private PhoneAuthProvider.OnVerificationStateChangedCallbacks mCallBack = new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
        @Override
        public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {
            String code = phoneAuthCredential.getSmsCode();
            if (code != null) {
                pinEntryEditText.setText(code);
                verifyCode(code);
            }
        }

        @Override
        public void onVerificationFailed(@NonNull FirebaseException e) {
            Toast.makeText(getContext(), "Error : " + e.getMessage(), Toast.LENGTH_LONG).show();
        }

        @Override
        public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
            super.onCodeSent(s, forceResendingToken);
            verificationId = s;
            Toast.makeText(getContext(), "Verification Code Sent", Toast.LENGTH_SHORT).show();
        }

//        @Override
//        public void onCodeAutoRetrievalTimeOut(@NonNull String s) {
//            super.onCodeAutoRetrievalTimeOut(s);
//            Toast.makeText(getContext(), "Auto Retrieval Timeout, Enter code manually", Toast.LENGTH_SHORT).show();
//        }
    };

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mAuth = FirebaseAuth.getInstance();
    }

    private void verifyCode(String code) {
        PhoneAuthCredential credential = PhoneAuthProvider.getCredential(verificationId, code);
        signInWithCredential(credential);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_verify, container, false);
        Button verify = view.findViewById(R.id.btnVerify);
        pinEntryEditText = view.findViewById(R.id.etCode);
        final Bundle bundle = getArguments();
        if (bundle != null) {
            phoneNumber = bundle.getString(Constants.PHONE_NUMBER);
            String phn_no = "+" + 91 + phoneNumber;
            sendVerificationCode(phn_no);
        }
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pinEntryEditText.setError(false);
                String code = pinEntryEditText.getText().toString();
                if (code.isEmpty() || code.length() < 6) {
                    pinEntryEditText.setError(true);
                    pinEntryEditText.requestFocus();
                    return;
                }
                verifyCode(code);
            }
        });
        return view;
    }

    private void sendVerificationCode(String number) {

        PhoneAuthProvider.getInstance().verifyPhoneNumber(
                number,
                60,
                TimeUnit.SECONDS,
                TaskExecutors.MAIN_THREAD,
                mCallBack
        );

    }

    private void signInWithCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential)
                .addOnCompleteListener(task -> {
                    if (task.isSuccessful()) {
                        startActivity(new Intent(getContext(), HomeActivity.class));
                        getActivity().finish();
                    }
                });
    }
}