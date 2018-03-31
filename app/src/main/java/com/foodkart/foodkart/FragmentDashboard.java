package com.foodkart.foodkart;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.Button;

import org.w3c.dom.Text;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentDashboard extends Fragment {


    public FragmentDashboard() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_dashboard, container, false);
        Button btn = (Button) v.findViewById(R.id.dashboard);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Dashboard", "Button was Clicked");
                ((MainActivity)getActivity()).onFpView();
            }
        });


       return v;
    }


}
