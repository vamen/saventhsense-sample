package com.vivekbalachandra.android.saventsencesample.fragment;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.vivekbalachandra.android.saventsencesample.Adapater.Myadapter;
import com.vivekbalachandra.android.saventsencesample.Mediater;
import com.vivekbalachandra.android.saventsencesample.R;
import com.vivekbalachandra.android.saventsencesample.StaticData;

public class Navigation_fragment extends android.support.v4.app.Fragment {

    public static final String Key_User_Learnt_Drawer = "User_Learnt_Drawer";
    public static final String Pref_file_name = "testpref";
    public Myadapter myadapter;
    //conversion types list

    private DrawerLayout mdrawerlayout;
    private ActionBarDrawerToggle mDrawertoggle;
    private boolean muserlearntDrawer;
    private boolean mfromsavedinstancestate;
    private View continerview;
    private RecyclerView recyclerView;
    Mediater med;//interface reference
    Context context;
    public Navigation_fragment() {
        // Required empty public constructor
    }
    //saving to sharedpreferance to check whether Drawer is called for first time
    public static void saveTopreference(Context context, String preferenceKey, boolean preferencevalue) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(Pref_file_name, context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(preferenceKey, preferencevalue);
        editor.apply();
    }
    //retrieving data from sharedpreffrence whether Drawer is called for first time
    public static boolean ReadFrompreference(Context context, String Preferencekey, boolean defaultvalue) {

        SharedPreferences sharedPreferences = context.getSharedPreferences(Pref_file_name, context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(Preferencekey, defaultvalue);
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //check weather user have seen navigation Bar i.e is he starting the activity for first time
        muserlearntDrawer = ReadFrompreference(getActivity(), Key_User_Learnt_Drawer, false);
        if (savedInstanceState != null) {
            //if user Have opend the fragment for first time
            mfromsavedinstancestate = true;
        }
        context=getActivity();

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        View rootview = inflater.inflate(R.layout.fragment_navigation_fragment, container, false);
        recyclerView = (RecyclerView) rootview.findViewById(R.id.my_recycler_view);


        myadapter = new Myadapter(getActivity(), StaticData.arlist,StaticData.mZMDI,1);
        recyclerView.setAdapter(myadapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        //code if divider b/w recycler view is required by using third party library
        /*recyclerView.addItemDecoration(
                new HorizontalDividerItemDecoration.Builder(getActivity())
                        .color(R.color.accent_material_dark)
                        .sizeResId(R.dimen.divider)
                        .marginResId(R.dimen.leftmargin, R.dimen.rightmargin)
                        .build());*/


        return rootview;
    }
    @Override
    public void onActivityCreated(Bundle savedInstanceState){
        super.onActivityCreated(savedInstanceState);
        med=(Mediater)getActivity();
    }
    public void setup(int fragmentid, DrawerLayout drawerLayout, final Toolbar toolbar) {
        //get the view of the fragment
        continerview = getActivity().findViewById(fragmentid);
        mdrawerlayout = drawerLayout;
        //Drawer listner
        mDrawertoggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.drawer_open, R.string.drawer_close) {

            @Override
            public void onDrawerOpened(View drawerView) {
                if (!muserlearntDrawer) {
                    //user have seen drawer
                    muserlearntDrawer = true;
                    //save it to sharedprefarence
                    saveTopreference(getActivity(), Key_User_Learnt_Drawer, muserlearntDrawer);
                }
                //Invalidate the option menu when drawer is open and redraw the option menu
                getActivity().invalidateOptionsMenu();
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                //Invalidate the option menu when drawer is closed and redraw the option menu
                getActivity().invalidateOptionsMenu();
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {
                //make the Behind seen blur when drawer is drawn till 0.6
                if (slideOffset < 0.6)
                    toolbar.setAlpha(1 - slideOffset);
            }
        };
        mdrawerlayout.setDrawerListener(mDrawertoggle);

        if (!muserlearntDrawer && !mfromsavedinstancestate) {//if user have never seen drawer or the fragment is started for first time then open the Drawer
            mdrawerlayout.openDrawer(continerview);
        }

        mdrawerlayout.post(new Runnable() {
            @Override
            public void run() {
                mDrawertoggle.syncState();
            }
        });

    }

    public void opensorclose(boolean val) {

        if(val)mdrawerlayout.openDrawer(continerview);
        else mdrawerlayout.closeDrawer(continerview);
    }





}
