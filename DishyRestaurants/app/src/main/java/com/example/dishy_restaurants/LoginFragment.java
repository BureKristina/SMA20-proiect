package com.example.dishy_restaurants;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    private TextView email, password;
    private FirebaseAuth mAuth;
    private Context context;

    public LoginFragment(Context context) {
        // Required empty public constructor
        this.context = context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_login, container, false);

        email = (TextView) root.findViewById(R.id.et_email);
        password = (TextView) root.findViewById(R.id.et_password);

        mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword(email.getText(), password.getText()).addOnCompleteListener((Activity) getContext(), new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    //FragmentTransaction ft = getFragmentManager().beginTransaction();
                    //Fragment mFrag = new NextFragment();
                    //ft.replace(R.id.fragment_container, mFrag);
                    //ft.commit();
                }
                else {
                    Snackbar.make(getActivity().findViewById(android.R.id.content),
                            task.getException().getLocalizedMessage(), Snackbar.LENGTH_LONG).show();
                }

            }
        });

        return root;
    }

    @Override
    public void onStart() {
        super.onStart();
        // Check if user is signed in (non-null) and update UI accordingly.
        FirebaseUser currentUser = mAuth.getCurrentUser();
        updateUI(currentUser);
    }

    public void updateUI(FirebaseUser account){

        if(account != null){
            Toast.makeText(context,"U Signed In successfully",Toast.LENGTH_LONG).show();
            startActivity(new Intent(context,MainActivity.class));

        }else {
            Toast.makeText(context,"U Didnt signed in",Toast.LENGTH_LONG).show();
        }

    }
}
