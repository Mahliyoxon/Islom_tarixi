package com.example.hikoya;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ProgramViewHolder {
    ImageView itemImage;
    TextView lvTitel;
    ProgramViewHolder(View v){
        itemImage = v.findViewById(R.id.imageView);
        lvTitel = v.findViewById(R.id.textView1);

    }

}
