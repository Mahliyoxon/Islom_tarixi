package com.example.hikoya;

import android.content.Context;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.result.contract.ActivityResultContracts;


public class ProgramAdapter extends ArrayAdapter<String> {
    Context context;
    int[] numimages;
    String[] lvTitle;


    public ProgramAdapter( Context context,String[] lvTitle, int[] numImage) {
        super(context, R.layout.single_item,R.id.textView1,lvTitle);
        this.context = context;
        this.numimages = numImage;
        this.lvTitle = lvTitle;

    }


    public View getView(int position, View convertView, ViewGroup parent)
    {
        View singleItem = convertView;
        ProgramViewHolder holder =null;
        if(singleItem==null){
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            singleItem = layoutInflater.inflate(R.layout.single_item,parent,false);
            holder = new ProgramViewHolder(singleItem);
            singleItem.setTag(holder);
        }
 else {
            holder = (ProgramViewHolder) singleItem.getTag();
        }
    holder.itemImage.setImageResource(numimages[position]);
    holder.lvTitel.setText(lvTitle[position]);
//    singleItem.setOnClickListener (new View.OnClickListener(){


//     @Override
//    public void onClick(View v) {
//    Toast.makeText(getContext(),"You clicked"+lvTitle[position],Toast.LENGTH_SHORT).show();
//        switch (position){
//
//            case 0:
//                Intent intent= new Intent(getContext(),entery.class);
//
//                break;
//        }
//     }
//
// });
        return singleItem;

    }

}
