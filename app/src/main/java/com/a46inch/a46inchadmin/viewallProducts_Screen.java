package com.a46inch.a46inchadmin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.a46inch.a46inchadmin.m_FireBase.FirebaseHelper;
import com.a46inch.a46inchadmin.m_UI.CustomAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class viewallProducts_Screen extends AppCompatActivity {
    DatabaseReference mref;
    ListView prodList;
    FirebaseHelper helper;
    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewall_products__screen);
        prodList = (ListView) findViewById(R.id.ProductList);
        mref = FirebaseDatabase.getInstance().getReferenceFromUrl("");
        helper =  new FirebaseHelper(mref);
        adapter=new CustomAdapter(this,helper.retrieve());
        prodList.setAdapter(adapter);


    }
}
