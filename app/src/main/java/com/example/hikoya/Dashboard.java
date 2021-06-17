package com.example.hikoya;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity {
    ListView lvprogram;

    int[] numImage = {R.drawable.moon, R.drawable.moon,R.drawable.moon,R.drawable.moon,R.drawable.moon,R.drawable.moon,R.drawable.moon,R.drawable.moon,R.drawable.moon};

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dashboard );
        lvprogram = findViewById( R.id.lvprogram );
        System.out.println("Mahliyo");
        Resources res = getResources();

        String[] lvTitle = res.getStringArray(R.array.first_menu);
        ProgramAdapter programAdapter = new ProgramAdapter( this, lvTitle, numImage );
        lvprogram.setAdapter( programAdapter );
        System.out.println("Mahliyo");
        lvprogram.setOnItemClickListener( new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TextView txtname =(TextView)view.findViewById( R.id.textView1 );
                String name = txtname.getText().toString();
                if (position == 0){
//                    Toast.makeText(view.getContext(),"You clicked"+pos,Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(view.getContext(),Entery.class);
                        intent.putExtra( "name_title",name );
                           startActivity( intent );


                }
                 else if(position == 8 ){
                     Intent intent3 = new Intent(view.getContext(),MainActivity2.class);
                      startActivity( intent3 );
                }
               else {
                    Intent intent1 = new Intent(view.getContext(),Second_Dashboard.class);
                    intent1.putExtra( "pos_title", position );
                    intent1.putExtra( "name_title",name );
                    startActivity( intent1 );

//                    Toast.makeText(view.getContext(),"You clicked"+pos,Toast.LENGTH_SHORT).show();
               }
            }
        } );

    }
}