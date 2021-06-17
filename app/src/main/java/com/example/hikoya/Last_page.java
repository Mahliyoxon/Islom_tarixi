package com.example.hikoya;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.media.VolumeShaper;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;



import java.util.ArrayList;
import java.util.Locale;
import java.util.Objects;

import petrov.kristiyan.colorpicker.ColorPicker;

public  class Last_page extends AppCompatActivity  {
 TextView last_text ;
 String copy_text;
 int text_size;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        loadLocale();
        Intent intent = getIntent();
        int pos_title = intent.getIntExtra( "positon",0 );
        String name_title = intent.getStringExtra( "title");
//        String[] all_lv_titles= intent.getStringArrayExtra("all_titles"  );
        setTitle( name_title );
        setContentView( R.layout.activity_last_page );

//

         Objects.requireNonNull( getSupportActionBar() ).setDisplayHomeAsUpEnabled( true );



        last_text = findViewById( R.id.last_text );
        switch (name_title){
            case "Musulmonlarni ikkiga ajralib ketish sabablari":
                   last_text.setText( R.string.m_2_1 );

                   break;
            case "Fitnalarning avj olishi":
                last_text.setText( R.string.m_2_2 );
                break;
            case "Musulmonlarning yagona xalifa ostida birlashishi":
                last_text.setText(R.string.m_2_3 );
                break;
            case "Yazid ibn Muoviya va Husayn ibn Ali o‘rtasidagi nizo sababi":
                last_text.setText( R.string.m_3_1 );
            case "Kufaga yo‘l olishi":
                last_text.setText( R.string.m_3_2 );
                break;
            case "Karbalo fojiasi":
                last_text.setText( R.string.m_3_3 );
                break;
            case "Abdul Malik ibn Marvonning xalifa etib saylanishi":
                last_text.setText( R.string.m_4_1 );
                break;
            case "Abdul Malik ibn Marvon va Abdulloh ibn Zubayr orasidagi ziddiyat":
                last_text.setText( R.string.m_4_2 );
                break;
            case "Valid ibn Abdul Malik xalifaligi":
                last_text.setText( R.string.m_4_3 );
                break;
            case "Umaviylar davlatining qulashi sabablari. Bani Umayyaga nisbatan adolat":
                last_text.setText( R.string.m_5_1 );
                break;
            case "Ummaviylarning qulashiga sabab bo‘lgan voqealar":
                last_text.setText( R.string.m_5_2 );
                break;
            case "Abbosiylar sulolasining taxt tepasiga kelishi":
                last_text.setText( R.string.m_6_1);
                break;
            case "Abbosiylar davlatida siyosiy, iqtisodiy va madaniy hayot":
                last_text.setText( R.string.m_6_2 );
                break;
                case "Abbosiy xalifalarning davlatchilikni mustahkamlash yo‘lidagi xatti-harakatlari":
                last_text.setText( R.string.m_7_1 );
                break;
            case "Ma’mun akademiyasi va xalifalikdagi madaniy hayot":
                last_text.setText( R.string.m_7_2 );
                break;
            case "Abbosiylar davlatidan mustaqil davlatlarning ajralib chiqishi":
                last_text.setText( R.string.m_8_1 );
                break;
            case "Abbosiylar davlatining mo‘g‘illar tarafidan tugatilishi":
                last_text.setText( R.string.m_8_2 );
                break;



        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate( R.menu.menu_tasks,menu );
        return true;
    }

    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        switch (item.getItemId()){
            case R.id.tem1:

                openDialog();

                return true;
            case R.id.tem2:
                openSecondDialog();
                return true;
            case R.id.tem3:
                openLanguageDialog();
             default:return super.onOptionsItemSelected( item );
        }


    }

    public void openDialog() {

        final AlertDialog.Builder popDialog = new AlertDialog.Builder(this);
        final SeekBar seek = new SeekBar(this);
        seek.setMax(255);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            seek.setMin(24);
        }
        seek.setKeyProgressIncrement(1);

        popDialog.setIcon(android.R.drawable.btn_star_big_on);
        popDialog.setTitle("Text hajmini tanlang: ");

        popDialog.setView(seek);


        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {



            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser){


//                txtView.setText("Value of : " + progress);
                last_text.setTextSize( progress );

                text_size = progress;

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                popDialog.setMessage( "shrift hajmi:" + seekBar.getProgress() );
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
               popDialog.setMessage( "shrift hajmi" + seekBar.getProgress() );
            }

        });

        // Button OK
        popDialog.setPositiveButton("OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });

        popDialog.create();
        popDialog.show();
    }
    public void openSecondDialog(){
       final ColorPicker colorPicker = new ColorPicker(Last_page.this );
        colorPicker.setTitle( "SHrift rangini tanlang " );

        ArrayList<String> colors = new ArrayList<>();
        colors.add("#258174");
        colors.add( "#3C8D2F" );
        colors.add( "#0d0f04" );
        colors.add( "# c639a4" );
        colors.add( "#c65b39" );
        colors.add( "#c6393a" );
        colors.add( "#393ac6" );
        colors.add( "#7475d7" );
        colors.add( "#81c639" );


        colorPicker.setColors(colors)
                .setColumns( 3 )
                .setRoundColorButton( true )

                .setOnChooseColorListener( new ColorPicker.OnChooseColorListener() {
                    @Override
                    public void onChooseColor(int position, int color) {
                         last_text.setTextColor( color );
                    }

                    @Override
                    public void onCancel() {

                    }

                } ).show();
    }
    public void openLanguageDialog(){
        final String[]  listname = {"Kril","Lotin"};
        AlertDialog.Builder mbuilder = new AlertDialog.Builder( Last_page.this );
        mbuilder.setTitle( "Shrift turi" );

        mbuilder.setSingleChoiceItems( listname, -1 , new  DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               if(i == 0){
                   setLocale("ach");
                   recreate();
               }
               else if (i == 1) {
                   setLocale("ab");
                   recreate();
               }
               dialogInterface.dismiss();
            }

        } );

        AlertDialog mydilaog = mbuilder.create();
        mydilaog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale( lang );
        Locale.setDefault( locale );
        Configuration config = new Configuration();
        config.locale=locale;
        getBaseContext().getResources().updateConfiguration( config,getBaseContext().getResources().getDisplayMetrics() );
        SharedPreferences.Editor editor = getSharedPreferences( "Settings",MODE_PRIVATE ).edit();
        editor.putString( "My_Lang",lang );
        editor.apply();
    }
    public void loadLocale(){
       SharedPreferences prefs = getSharedPreferences( "Settings", Activity.MODE_PRIVATE );
       String language = prefs.getString( "My_Lang","" );
       setLocale( language );

    }
  
}
