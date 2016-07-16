package com.vivekbalachandra.android.saventsencesample.Adapater;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.malinskiy.materialicons.IconDrawable;
import com.malinskiy.materialicons.Iconify;
import com.vivekbalachandra.android.saventsencesample.Mediater;
import com.vivekbalachandra.android.saventsencesample.R;

public class Myadapter extends RecyclerView.Adapter<Myadapter.myViewholder> {

        LayoutInflater inflater;
        Mediater med;
        Context ctx;
        String arlist[];
        int flag;
        Iconify.IconValue[] mZMDI;
        public Myadapter(Context context, String[] name, Iconify.IconValue[] icon,int option) {
            inflater = LayoutInflater.from(context);
            arlist=name;
            mZMDI=icon;
            med= (Mediater) context;
            ctx=context;
            flag=option;
        }

        @Override
        public myViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view;
            if(flag==1)
             view = inflater.inflate(R.layout.list_item, parent, false);
            else
              view = inflater.inflate(R.layout.list_item_programs, parent, false);
            myViewholder viewholder = new myViewholder(view);
            return viewholder;
        }

        @Override
        public void onBindViewHolder(myViewholder holder, int position) {
            holder.sText.setText(arlist[position]);
            holder.iconText.setCompoundDrawablesWithIntrinsicBounds(new IconDrawable(ctx,mZMDI[position] ).colorRes((flag==1)?R.color.Black:R.color.white).sizeDp(20), null, null, null);


        }

        @Override
        public int getItemCount() {
            return arlist.length;
        }

        class myViewholder extends RecyclerView.ViewHolder implements View.OnClickListener {


            TextView sText,iconText;

            public myViewholder(View itemView) {
                super(itemView);
                sText = (TextView) itemView.findViewById(R.id.section_text);
                iconText =(TextView) itemView.findViewById(R.id.icon);

                itemView.setOnClickListener(this);
            }


            @Override
            public void onClick(View v) {
                if(flag==1) {
                    int position = getAdapterPosition();
                    // Toast.makeText(getActivity(), "hello at pos" + position, Toast.LENGTH_SHORT).show();

                    //call responce fo mediater interface override at MainActivity to change the fragments on clicking the respective conversion types on navigation fragment
                    med.transfercontrol(position);
                }
                else
                {
                    //TODO
                }
            }


        }


    }