package com.a46inch.a46inchadmin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ProductDetail_Screen extends AppCompatActivity {
    private TextView Prodname;
    private TextView Proddesc;
    private TextView Prodprice;
    private TextView Prodseller;
    private TextView Prodcatagory;
    private TextView Prodqauntity;
    private String name,desc,price,seller,catagory,quantity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail__screen);
        Prodname = (TextView) findViewById(R.id.nametextView);
        Proddesc = (TextView) findViewById(R.id.desctextView6);
        Prodprice = (TextView) findViewById(R.id.pricetextView2);
        Prodseller = (TextView) findViewById(R.id.sellertextView7);
        Prodcatagory = (TextView) findViewById(R.id.catagorytextView9);
        Prodqauntity = (TextView) findViewById(R.id.quantitytextView2);
        Intent i=this.getIntent();
        name=i.getExtras().getString("NAME_KEY");
        desc=i.getExtras().getString("DESC_KEY");
        price=i.getExtras().getString("PRICE_KEY");
        seller=i.getExtras().getString("SELLER_KEY");
        catagory=i.getExtras().getString("CATAGORY_KEY");
        quantity=i.getExtras().getString("QUANTITY_KEY");
        Prodname.setText(name);
        Proddesc.setText(desc);
        Prodprice.setText(price);
        Prodseller.setText(seller);
        Prodcatagory.setText(catagory);
        Prodqauntity.setText(quantity);
    }

}
