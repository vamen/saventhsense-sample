package com.vivekbalachandra.android.saventsencesample.fragment;


import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.vivekbalachandra.android.saventsencesample.R;

import java.util.BitSet;

/**
 * A simple {@link Fragment} subclass.
 */
public class Home extends Fragment {


    public Home() {
        // Required empty public constructor
    }
    HorizontalScrollView container;
    View rootView;
    String TAG=Home.class.getSimpleName();
    int mHight;
    int mWidth;
    ImageView pic1;
    ImageView pic2;
    ImageView pic3;
    ImageView pic4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         rootView=inflater.inflate(R.layout.fragment_home, container, false);




        return rootView;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        container= (HorizontalScrollView) rootView.findViewById(R.id.horizontal);
         pic1= (ImageView) rootView.findViewById(R.id.pic1);
         pic2= (ImageView) rootView.findViewById(R.id.pic2);
         pic3= (ImageView) rootView.findViewById(R.id.pic3);
         pic4= (ImageView) rootView.findViewById(R.id.pic4);



        mWidth =1080; //container.getWidth();
        mHight = 600;//container.getHeight()/2;

        Log.d(TAG, " " + mHight + ": " + mWidth);


        Bitmap bm= BitmapFactory.decodeResource(getResources(), R.drawable.pic1);
        Bitmap small=Bitmap.createScaledBitmap(bm, mWidth, mHight, false);
        pic1.setImageBitmap(small);

        bm= BitmapFactory.decodeResource(getResources(), R.drawable.pic2);
        small=Bitmap.createScaledBitmap(bm,mWidth,mHight,false);
        pic2.setImageBitmap(small);

        bm= BitmapFactory.decodeResource(getResources(), R.drawable.pic3);
        small=Bitmap.createScaledBitmap(bm, mWidth, mHight, false);
        pic3.setImageBitmap(small);

        bm= BitmapFactory.decodeResource(getResources(), R.drawable.pic4);
        small=Bitmap.createScaledBitmap(bm,mWidth,mHight,false);
        pic4.setImageBitmap(small);




      /*  ViewTreeObserver vto = container.getViewTreeObserver();
        vto.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                mWidth = container.getWidth();
                mHight = container.getHeight()/2;

                Log.d(TAG, " " + mHight + ": " + mWidth);


                Bitmap bm= BitmapFactory.decodeResource(getResources(), R.drawable.pic1);
                Bitmap small=Bitmap.createScaledBitmap(bm, mWidth, mHight, false);
                pic1.setImageBitmap(small);

                bm= BitmapFactory.decodeResource(getResources(), R.drawable.pic2);
                small=Bitmap.createScaledBitmap(bm,mWidth,mHight,false);
                pic2.setImageBitmap(small);

                bm= BitmapFactory.decodeResource(getResources(), R.drawable.pic3);
                small=Bitmap.createScaledBitmap(bm, mWidth, mHight, false);
                pic3.setImageBitmap(small);

                bm= BitmapFactory.decodeResource(getResources(), R.drawable.pic4);
                small=Bitmap.createScaledBitmap(bm,mWidth,mHight,false);
                pic4.setImageBitmap(small);









            }
        });
*/
        /*container.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {

            }
        });     */




    }

    @Override
    public void onResume() {
        super.onResume();

    }
}
