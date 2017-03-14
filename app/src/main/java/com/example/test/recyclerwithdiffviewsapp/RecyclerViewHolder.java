package com.example.test.recyclerwithdiffviewsapp;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by test on 28/2/17.
 */
public class RecyclerViewHolder extends RecyclerView.ViewHolder {
    TextView txtView;
    public RecyclerViewHolder(View itemView) {
        super(itemView);
        txtView = (TextView)itemView.findViewById(android.R.id.text1);
    }
    public TextView getLabel(){
        return txtView;
    }
    public void setLabel(TextView txtView){
        this.txtView = txtView;
    }
}
