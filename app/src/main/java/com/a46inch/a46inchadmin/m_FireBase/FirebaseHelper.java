package com.a46inch.a46inchadmin.m_FireBase;

/**
 * Created by S.H.I.E.L.D on 5/17/2017.
 */
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.a46inch.a46inchadmin.m_model.Products;

import java.util.ArrayList;


public class FirebaseHelper {
    DatabaseReference db;
    Boolean saved=null;
    ArrayList<Products> products = new ArrayList<>();

    public FirebaseHelper(DatabaseReference db) {
        this.db = db;
    }
    //IMPLEMENT FETCH DATA AND FILL ARRAYLIST
    private void fetchData(DataSnapshot dataSnapshot)
    {
        products.clear();

        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            Products product =ds.getValue(Products.class);
            products.add(product);
        }
    }
    //READ BY HOOKING ONTO DATABASE OPERATION CALLBACKS
    public ArrayList<Products> retrieve() {
        db.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {
                fetchData(dataSnapshot);

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        return products;
    }
    //WRITE IF NOT NULL
    public Boolean save(Products product)
    {
        if(product==null)
        {
            saved=false;
        }else
        {
            try
            {
                db.child("Products").push().setValue(product);
                saved=true;
            }catch (DatabaseException e)
            {
                e.printStackTrace();
                saved=false;
            }
        }
        return saved;
    }

}
