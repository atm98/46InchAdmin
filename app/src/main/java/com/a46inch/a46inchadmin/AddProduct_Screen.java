package com.a46inch.a46inchadmin;

import android.app.Dialog;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.EditText;
import android.widget.Toast;

import com.a46inch.a46inchadmin.m_FireBase.FirebaseHelper;
import com.a46inch.a46inchadmin.m_UI.CustomAdapter;
import com.a46inch.a46inchadmin.m_model.Products;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.security.spec.ECField;


public class AddProduct_Screen extends AppCompatActivity {


    private DatabaseReference db;
    private FirebaseHelper helper;
    private ListView lv;
    private FloatingActionButton fab ;
    CustomAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product__screen);

        //INITIALIZE FIREBASE DB
        db= FirebaseDatabase.getInstance().getReferenceFromUrl("https://inch-bd53c.firebaseio.com/").child("Products");
        helper=new FirebaseHelper(db);
        lv = (ListView) findViewById(R.id.lv);
        adapter =new CustomAdapter(this,helper.Populateall());
        lv.setAdapter(adapter);
        fab = (FloatingActionButton) findViewById(R.id.addFab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                InputDialog();
            }
        });




    }
    public void InputDialog(){
        Dialog d=new Dialog(this);
        d.setTitle("Save To Firebase");
        d.setContentView(R.layout.input_dialog);
        final EditText nameTxt= (EditText) d.findViewById(R.id.NameeditText);
        final EditText descTxt= (EditText) d.findViewById(R.id.DesceditText3);
        final EditText priceTxt = (EditText) d.findViewById(R.id.PriceeditText2);
        final EditText sellerTxt = (EditText) d.findViewById(R.id.SellereditText4);
        final EditText catagoryTxt = (EditText) d.findViewById(R.id.CatagoryeditText5);
        final EditText quantityTxt = (EditText) d.findViewById(R.id.QuantityeditText6);

        Button saveBtn= (Button) d.findViewById(R.id.savebutton);
        //SAVE
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GET DATA
                String name=nameTxt.getText().toString();
                String desc=descTxt.getText().toString();
                String price = priceTxt.getText().toString();
                String seller = sellerTxt.getText().toString();
                String catagory = catagoryTxt.getText().toString();
                String qauntity = quantityTxt.getText().toString();
                //SET DATA
                Products s= new Products();
                s.setPname(name);
                s.setPdesc(desc);
                s.setPprice(price);
                s.setPseller(seller);
                s.setPcatagory(catagory);
                s.setPquant(qauntity);
                //SIMPLE VALIDATION
                if(!name.equals("")&&!desc.equals("")&&!price.equals("")&&!seller.equals("")&&!catagory.equals("")&&!qauntity.equals(""))
                {
                    //THEN SAVE
                    if(helper.save(s))
                    {
                        //IF SAVED CLEAR EDITXT
                        nameTxt.setText("");
                        descTxt.setText("");
                        priceTxt.setText("");
                        sellerTxt.setText("");
                        catagoryTxt.setText("");
                        quantityTxt.setText("");
                        adapter=new CustomAdapter(AddProduct_Screen.this,helper.retrieve());
                        lv.setAdapter(adapter);
                    }
                }else
                {
                    Toast.makeText(AddProduct_Screen.this, "Name Must Not Be Empty", Toast.LENGTH_SHORT).show();
                }
            }
        });
        d.show();

    }


}

