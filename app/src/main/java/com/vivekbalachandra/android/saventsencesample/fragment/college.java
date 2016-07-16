package com.vivekbalachandra.android.saventsencesample.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vivekbalachandra.android.saventsencesample.Adapater.Myadapter;
import com.vivekbalachandra.android.saventsencesample.R;
import com.vivekbalachandra.android.saventsencesample.StaticData;

/**
 * A simple {@link Fragment} subclass.
 */
public class college extends Fragment {


    public college() {
        // Required empty public constructor
    }

    View root;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        root=inflater.inflate(R.layout.fragment_college, container, false);
        RecyclerView recyclerView= (RecyclerView) root.findViewById(R.id.programs);

        Myadapter myadapter = new Myadapter(getActivity(), StaticData.str, StaticData.mZMDIPlus,0);
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        return root;
    }

}
