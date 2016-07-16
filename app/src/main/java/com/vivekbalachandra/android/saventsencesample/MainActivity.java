package com.vivekbalachandra.android.saventsencesample;

import android.app.FragmentManager;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.vivekbalachandra.android.saventsencesample.fragment.About;
import com.vivekbalachandra.android.saventsencesample.fragment.Home;
import com.vivekbalachandra.android.saventsencesample.fragment.Navigation_fragment;
import com.vivekbalachandra.android.saventsencesample.fragment.ServiceProvided;


public class MainActivity extends AppCompatActivity implements Mediater  {

        Toolbar toolbar;
        android.support.v4.widget.DrawerLayout mDrawerLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.companyname);
        setSupportActionBar(toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        toolbar.setLogo(getDrawable(R.mipmap.saventsence));
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));

        mDrawerLayout= (DrawerLayout) findViewById(R.id.drawerlayout);
        Navigation_fragment mNfragment= (Navigation_fragment) getSupportFragmentManager().findFragmentById(R.id.navigation_bar);
        mNfragment.setup(R.id.navigation_bar, mDrawerLayout, toolbar);
        Fragment fragment=new Home();
                android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
                FragmentTransaction transaction=fragmentManager.beginTransaction();
                transaction.replace(R.id.frgament_replacing_layout,fragment);
                toolbar.setTitle("Home");
                transaction.commit();




    }

    @Override
    public void transfercontrol(int state) {
        Log.d("MainActivity","activity");
        Fragment fragment;
        if(state==0) {
            fragment = new Home();
            toolbar.setTitle("Home");
        }else if(state==1) {
            fragment = new ServiceProvided();
            toolbar.setTitle("Service");
        }else {
            fragment = new About();
            toolbar.setTitle("About us");

        }android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.replace(R.id.frgament_replacing_layout,fragment);
        transaction.commit();


    }
}
