package com.a46inch.a46inchadmin.m_UI;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.view.LayoutInflater;
import android.widget.TextView;

import com.a46inch.a46inchadmin.ProductDetail_Screen;
import com.a46inch.a46inchadmin.R;
import com.a46inch.a46inchadmin.m_model.Products;

import java.util.ArrayList;

/**
 * Created by S.H.I.E.L.D on 5/17/2017.
 */

public class CustomAdapter extends BaseAdapter{
    Context c;
    ArrayList<Products> products;
    public CustomAdapter(Context c, ArrayList<Products> products) {
        this.c = c;
        this.products = products;
    }
    @Override
    public int getCount() {
        return products.size();
    }
    @Override
    public Object getItem(int pos) {
        return products.get(pos);
    }
    @Override
    public long getItemId(int pos) {
        return pos;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup viewGroup) {
        if(convertView==null)
        {
            convertView= LayoutInflater.from(c).inflate(R.layout.model,viewGroup,false);
        }
        TextView nameTxt= (TextView) convertView.findViewById(R.id.nameTxt);
        TextView descTxt= (TextView) convertView.findViewById(R.id.descTxt);
        final Products s= (Products) this.getItem(position);
        nameTxt.setText(s.getPname());
        descTxt.setText(s.getPdesc());
        convertView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //OPEN DETAIL
                openDetailActivity(s.getPname(),s.getPdesc());
            }
        });
        return convertView;
    }
    //OPEN DETAIL ACTIVITY
    private void openDetailActivity(String...details)
    {
        Intent i=new Intent(c,ProductDetail_Screen.class);
        i.putExtra("NAME_KEY",details[0]);
        i.putExtra("DESC_KEY",details[1]);
        c.startActivity(i);
    }
}
