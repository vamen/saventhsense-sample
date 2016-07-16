package com.vivekbalachandra.android.saventsencesample.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vivekbalachandra.android.saventsencesample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class About extends Fragment {


    public About() {
        // Required empty public constructor
    }

    View root;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root=inflater.inflate(R.layout.fragment_about, container, false);

        return root;
    }

}
