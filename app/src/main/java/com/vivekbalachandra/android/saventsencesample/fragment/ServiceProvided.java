package com.vivekbalachandra.android.saventsencesample.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.vivekbalachandra.android.saventsencesample.Adapater.ViewPagerAdapter;
import com.vivekbalachandra.android.saventsencesample.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ServiceProvided extends Fragment {


    public ServiceProvided() {
        // Required empty public constructor

    }
    View root;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        root=inflater.inflate(R.layout.fragment_service_provided, container, false);
        ViewPager viewPager = (ViewPager) root.findViewById(R.id.viewPager);
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new college(), "COLLEGE");
        adapter.addFragment(new corporate(), "CORPORATE");
        adapter.addFragment(new Individual(), "INDIVIDUAL");
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) root.findViewById(R.id.tab);
        tabLayout.setTabTextColors(getResources().getColorStateList(R.color.white));
        tabLayout.setupWithViewPager(viewPager);




        return root;
    }

}
