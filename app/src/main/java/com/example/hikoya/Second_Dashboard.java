package com.example.hikoya;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.Objects;

public class Second_Dashboard extends AppCompatActivity {
    ListView lvprogram2;

//    String[] text = {String.valueOf(R.string.birinchi), String.valueOf( R.string.ikkinchi )};


    int[] numImage = {R.drawable.moon, R.drawable.moon};
    int[]numImage1={R.drawable.moon,R.drawable.moon,R.drawable.moon};
    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        int pos_title = intent.getIntExtra( "pos_title",0 );
        String name_title = intent.getStringExtra( "name_title");
        setTitle( name_title );

        setContentView(R.layout.activity_second_dashboard);
        lvprogram2 = findViewById( R.id.lvprogram2 );
        Resources res = getResources();

        String[] lvTitle = res.getStringArray(R.array.first_menu);
        String[] lvTitle2 =  res.getStringArray(R.array.second_menu);
        String[] lvTitle3 =  res.getStringArray(R.array.third_menu);
        String[] lvTitle4 =  res.getStringArray(R.array.fourth_menu);
        String[] lvTitle5 =  res.getStringArray(R.array.five_menu);
        String[] lvTitle6 =  res.getStringArray(R.array.six_menu);
        String[] lvTitle7 =  res.getStringArray(R.array.seven_menu);
        String[] lvTitle8 =  res.getStringArray(R.array.eight_menu);

        String[][] all_lvtitle ={lvTitle2,lvTitle3,lvTitle4,lvTitle5,lvTitle6,lvTitle7,lvTitle8};

            getSupportActionBar().setDisplayHomeAsUpEnabled( true );

         if(pos_title == 4 || pos_title == 5||pos_title==6||pos_title ==7) {
             ProgramAdapter programAdapter = new ProgramAdapter( this, all_lvtitle[pos_title - 1], numImage );
             lvprogram2.setAdapter( programAdapter );
             lvprogram2.setOnItemClickListener( new AdapterView.OnItemClickListener() {

                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                     TextView txtname = (TextView) view.findViewById( R.id.textView1 );
                     String name = txtname.getText().toString();


                     Intent intent1 = new Intent( view.getContext(), Last_page.class );

                     intent1.putExtra( "title", name );
                     intent.putExtra( "position", position );
                     startActivity( intent1 );

//                    Toast.makeText(view.getContext(),"You clicked"+pos,Toast.LENGTH_SHORT).show();

                 }
             } );
         }
         else { ProgramAdapter programAdapter1 = new ProgramAdapter( this, all_lvtitle[pos_title - 1], numImage1 );
             lvprogram2.setAdapter( programAdapter1 );
             lvprogram2.setOnItemClickListener( new AdapterView.OnItemClickListener() {

                 public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                     TextView txtname = (TextView) view.findViewById( R.id.textView1 );
                     String name1 = txtname.getText().toString();


                     Intent intent2 = new Intent( view.getContext(), Last_page.class );

                     intent2.putExtra( "title", name1 );
                     intent2.putExtra( "position", position );
                     intent2.putExtra(  "all_titles",all_lvtitle );
                     startActivity( intent2 );

//                    Toast.makeText(view.getContext(),"You clicked"+pos,Toast.LENGTH_SHORT).show();

                 }
             } );
         }
    }
}