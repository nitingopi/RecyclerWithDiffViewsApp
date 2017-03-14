package com.example.test.recyclerwithdiffviewsapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by test on 6/3/17.
 */
public class SmallFragment extends Fragment {
    TextView txtView1,txtView2;
    Button btn;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.layout_viewholder5, container, false);
        txtView1 = (TextView)view.findViewById(R.id.txtView5);
        txtView2 = (TextView)view.findViewById(R.id.txtView6);
        btn = (Button)view.findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "I am clicked! help me", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}
