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

    private EditText nameEditTxt;
    private EditText desctxt;
    private EditText priceTxt;
    private EditText sellerTxt;
    private EditText catagoryTxt;
    private ECField quantityTxt;
    private DatabaseReference db;
    private FirebaseHelper helper;
    private ListView lv;
    private FloatingActionButton fab ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product__screen);


        lv = (ListView) findViewById(R.id.lv);
        //INITIALIZE FIREBASE DB
        db= FirebaseDatabase.getInstance().getReference();
        helper=new FirebaseHelper(db);
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
        nameEditTxt= (EditText) d.findViewById(R.id.nameEditText);
        desctxt= (EditText) d.findViewById(R.id.descEditText);
        EditText nameTxt= (EditText) findViewById(R.id.NameeditText);
        EditText descTxt= (EditText) findViewById(R.id.DesceditText3);
        EditText priceTxt = (EditText) findViewById(R.id.PriceeditText2);
        EditText sellerTxt = (EditText) findViewById(R.id.SellereditText4);
        EditText catagoryTxt = (EditText) findViewById(R.id.CatagoryeditText5);
        EditText quantityTxt = (EditText) findViewById(R.id.QuantityeditText6);

        Button saveBtn= (Button) d.findViewById(R.id.saveBtn);
        //SAVE
        saveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //GET DATA
                String name=nameEditTxt.getText().toString();
                String desc=desctxt.getText().toString();
                //SET DATA
                Products s= new Products();
                s.setPname(name);
                s.setPdesc(desc);
                //SIMPLE VALIDATION
                if(name.length()>0)
                {
                    //THEN SAVE
                    if(helper.save(s))
                    {
                        //IF SAVED CLEAR EDITXT
                        nameEditTxt.setText("");
                        desctxt.setText("");
                        final CustomAdapter adapter=new CustomAdapter(AddProduct_Screen.this,helper.retrieve());
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

