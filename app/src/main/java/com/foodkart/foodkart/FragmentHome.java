package com.foodkart.foodkart;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentHome extends Fragment {


    public FragmentHome() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_home, container, false);
        CardView fp = (CardView) v.findViewById(R.id.fp_check);
        CardView swiggy = (CardView) v.findViewById(R.id.swiggy_check);
        CardView zomato = (CardView) v.findViewById(R.id.zomato_check);
        CardView uberEats = (CardView) v.findViewById(R.id.uber_eats_check);
        CardView freshMenu = (CardView) v.findViewById(R.id.fresh_menu_check);

        fp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("Dashboard", "Button was Clicked");
                ((MainActivity)getActivity()).onFpView();
            }
        });

        swiggy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onSwiggyView();
            }
        });

        zomato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onZomatoView();
            }
        });

        uberEats.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onUberEatsView();
            }
        });

        freshMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onFreshMenuView();
            }
        });


        return v;
    }

}
