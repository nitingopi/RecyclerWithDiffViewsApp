package com.example.test.recyclerwithdiffviewsapp;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Switch;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    ArrayList<Object> list;
    RecyclerView recyclerView;

    MyAdapter adapter;
    private final int index = 1;
    private AdapterView.OnItemClickListener mListener;

    private final String TAG = "MainActivity";
    LinearLayout layout1, layout4, layout5;
    private final String MEDIUM="medium", LARGE="large", SMALL = "small";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = getSampleArrayList();

        layout1 = (LinearLayout) findViewById(R.id.layout1Container);//medium view
        layout4 = (LinearLayout) findViewById(R.id.layout1Container4);//big view
        layout5 = (LinearLayout) findViewById(R.id.layout1Container5);//small view
        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerView.ItemAnimator itemAnimator = new DefaultItemAnimator();
        //itemAnimator.setAddDuration(5000);
        itemAnimator.setChangeDuration(300);
        //itemAnimator.setRemoveDuration(5000);
        recyclerView.setItemAnimator(itemAnimator);
        bindDataToAdapter();
    }

    private ArrayList<Object> getSampleArrayList() {
        ArrayList<Object> items = new ArrayList<>();
        items.add(new User("Dany Targaryen", "Valyria",MEDIUM));
        items.add(new User("Rob Stark", "Winterfell",MEDIUM));
        items.add(new User("Jon Snow", "Castle Black", MEDIUM));
        items.add(new User("Tyrion Lanister", "King's Landing",MEDIUM));

        return items;
    }

    private void bindDataToAdapter() {
        // Bind adapter to recycler view object
        adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);
        adapter.setClickListener(this);
    }


    @Override
    public void onClick(View view, int position) {
        Log.i(TAG, "inside onclick");

        String tag = (String) view.getTag();

        if (tag.equalsIgnoreCase("layout1")) {
            changeView("layout1", "layout4", position);
        } else if (tag.equalsIgnoreCase("layout4")) {
            changeView("layout4", "layout4", position);
        } else if (tag.equalsIgnoreCase("layout5")) {
            changeView("layout5", "layout4", position);
        }

    }

    public void changeView(String from, String to, int position) {
        list.clear();
        if (from.equalsIgnoreCase("layout1") || from.equalsIgnoreCase("layout5")) {
            list.add(new User("Dany Targaryen", "Valyria",SMALL));
            list.add(new User("Jon Snow", "Castle Black",SMALL));
            list.add(new User("Rob Stark", "Winterfell",SMALL));
            list.add(new User("Tyrion Lanister", "King's Landing",SMALL));
            list.remove(position);
            if (position == 0) {

                list.add(position, new User("Dany Targaryen", "Valyria",LARGE));
            } else if (position == 1) {

                list.add(position, new User("Jon Snow", "Castle Black",LARGE));
            } else if (position == 2) {

                list.add(position, new User("Rob Stark", "Winterfell",LARGE));
            } else if (position == 3) {

                list.add(position, new User("Tyrion Lanister", "King's Landing",LARGE));
            }
            /*adapter.notifyItemRemoved(position);
            adapter.notifyItemInserted(position);*/
            adapter.notifyItemRangeChanged(0, 4);
        } else if (from.equalsIgnoreCase("layout4")) {
            list.add(new User("Dany Targaryen", "Valyria",MEDIUM));
            list.add(new User("Jon Snow", "Castle Black",MEDIUM));
            list.add(new User("Rob Stark", "Winterfell",MEDIUM));
            list.add(new User("Tyrion Lanister", "King's Landing",MEDIUM));
            adapter.notifyItemRangeChanged(0, 4);
        }
        //adapter.notifyItemRangeChanged(0, 4);
    }
}
