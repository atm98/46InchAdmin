package com.a46inch.a46inchadmin;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Home_Screen extends AppCompatActivity {
    private static final String TAG = "Home_Screen";
    private FirebaseAuth.AuthStateListener mAuthListener;
    private FirebaseAuth mAuth; //declare FirebaseAuth object
    private Button addProd;//declare addproduct button
    private Button delProd;//declare delproduct button
    private Button updtProd;//declare updateproduct button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home__screen);
        mAuth = FirebaseAuth.getInstance();
        addProd = (Button) findViewById(R.id.AddProductbutton);
        delProd = (Button) findViewById(R.id.DelProductbutton);
        updtProd = (Button) findViewById(R.id.UpdtProductbutton);

        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    Log.d(TAG, "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };
        addProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Screen.this,AddProduct_Screen.class));
                finish();
            }
        });
        delProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Screen.this,DelProduct_Screen.class));
                finish();
            }
        });
        updtProd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Home_Screen.this,UpdtProduct_Screen.class));
                finish();
            }
        });
    }
    @Override
    public void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener); //at the start of the activity Adds a listener that will be called when the connection becomes authenticated or unauthenticated.

    }
    @Override
    public void onStop() {
        super.onStop();
        if (mAuthListener != null) {
            mAuth.removeAuthStateListener(mAuthListener); //removes the AuthStateListener at the end of the activity
        }
    }
}
