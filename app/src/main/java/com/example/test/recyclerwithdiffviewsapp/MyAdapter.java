package com.example.test.recyclerwithdiffviewsapp;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by test on 28/2/17.
 */
public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private List<Object> items;

    private final int SMALL_VIEW=0,MEDIUM_VIEW=1,LARGE_VIEW=2,VERY_LARGE_VIEW=3;
    private final String MEDIUM="medium", LARGE="large", SMALL = "small";
    private final String TAG = "MyAdapter";
    private ItemClickListener clickListener;


    public MyAdapter(List<Object> items){
        this.items = items;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder ;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        switch (viewType){
            case MEDIUM_VIEW:
                View v1 = inflater.inflate(R.layout.layout_viewholder1,parent,false);
                viewHolder = new ViewHolder1(v1);
                break;
            case SMALL_VIEW:
                View v5 = inflater.inflate(R.layout.layout_viewholder5,parent,false);
                viewHolder = new ViewHolder5(v5);
                break;
            case LARGE_VIEW:
                View v4 = inflater.inflate(R.layout.layout_viewholder4,parent,false);
                viewHolder = new ViewHolder4(v4);
                break;


            default:
                View v = inflater.inflate(android.R.layout.simple_list_item_1,parent,false);
                viewHolder = new RecyclerViewHolder(v);
                break;
        }

        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (holder.getItemViewType()){
            case MEDIUM_VIEW:
                Log.i(TAG,"user");
                ViewHolder1 vh1 = (ViewHolder1)holder;
                configureViewHolder1(vh1, position);
                break;
            case LARGE_VIEW:
                Log.i(TAG,"usermedium");
                ViewHolder4 vh4 = (ViewHolder4)holder;
                configureViewHolder4(vh4, position);
                break;
            case SMALL_VIEW:
                Log.i(TAG,"usersmall");
                ViewHolder5 vh5 = (ViewHolder5)holder;
                configureViewHolder5(vh5, position);
                break;

            default:
                Log.i(TAG,"default means simple label");
                RecyclerViewHolder rv = (RecyclerViewHolder)holder;
                configureDefaultViewHolder(rv,position);
                break;
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        //return super.getItemViewType(position);
        User user = (User) items.get(position);
        if(user.getType().equalsIgnoreCase(MEDIUM) ){
            return MEDIUM_VIEW;
        }else if(user.getType().equalsIgnoreCase(SMALL)){
            return SMALL_VIEW;
        }
        else if(user.getType().equalsIgnoreCase(LARGE)){
            return LARGE_VIEW;
        }
        /*if(items.get(position) instanceof User ){
            return MEDIUM_VIEW;
        }else if(items.get(position) instanceof UserSmall){
            return SMALL_VIEW;
        }
        else if(items.get(position) instanceof UserMedium){
            return LARGE_VIEW;
        }*/

        return -1;
    }
    private void configureDefaultViewHolder(RecyclerViewHolder vh, int position) {

        vh.getLabel().setText(String.valueOf(items.get(position)));
    }

    private void configureViewHolder1(ViewHolder1 vh1, int position) {
        User user = (User) items.get(position);
        if (user != null) {
            vh1.getLabel1().setText("Name: " + user.getName());
            vh1.getLabel2().setText("Hometown: " + user.getRegion());
        }
    }
    private void configureViewHolder4(ViewHolder4 vh1, int position) {
        User user = (User) items.get(position);
        if (user != null) {
            vh1.getLabel1().setText("Name: " + user.getName());
            vh1.getLabel2().setText("Hometown: " + user.getRegion());
        }
    }
    private void configureViewHolder5(ViewHolder5 vh1, int position) {
        User user = (User) items.get(position);
        if (user != null) {
            //vh1.getLabel1().setText("Name: " + user.getName());
            //vh1.getLabel2().setText("Hometown: " + user.getRegion());
        }
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.clickListener = itemClickListener;
    }
    public class ViewHolder1 extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtView1, txtView2;
        public ViewHolder1(View itemView) {
            super(itemView);
            txtView1 = (TextView)itemView.findViewById(R.id.txtView1);
            txtView2 = (TextView)itemView.findViewById(R.id.txtView2);
            itemView.setOnClickListener(this);
        }

        public TextView getLabel1(){
            return txtView1;
        }
        public TextView getLabel2(){
            return txtView2;
        }

        public void setLabel1(TextView txtView1){
            this.txtView1 = txtView1;
        }

        public void setLabel2(TextView txtView2){
            this.txtView2 = txtView2;
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) clickListener.onClick(v, getAdapterPosition());
        }
    }
    public class ViewHolder4 extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtView1, txtView2;

        public ViewHolder4(View itemView) {
            super(itemView);
            txtView1 = (TextView) itemView.findViewById(R.id.txtView3);
            txtView2 = (TextView) itemView.findViewById(R.id.txtView4);
            itemView.setOnClickListener(this);
        }

        public TextView getLabel1() {
            return txtView1;
        }

        public TextView getLabel2() {
            return txtView2;
        }

        public void setLabel1(TextView txtView1) {
            this.txtView1 = txtView1;
        }

        public void setLabel2(TextView txtView2) {
            this.txtView2 = txtView2;
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) clickListener.onClick(v, getAdapterPosition());
        }
    }
    public class ViewHolder5 extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView txtView1, txtView2;

        public ViewHolder5(View itemView) {
            super(itemView);
            txtView1 = (TextView) itemView.findViewById(R.id.txtView5);
            txtView2 = (TextView) itemView.findViewById(R.id.txtView6);
            itemView.setOnClickListener(this);
        }

        public TextView getLabel1() {
            return txtView1;
        }

        public TextView getLabel2() {
            return txtView2;
        }

        public void setLabel1(TextView txtView1) {
            this.txtView1 = txtView1;
        }

        public void setLabel2(TextView txtView2) {
            this.txtView2 = txtView2;
        }

        @Override
        public void onClick(View v) {
            if (clickListener != null) clickListener.onClick(v, getAdapterPosition());
        }
    }

}
