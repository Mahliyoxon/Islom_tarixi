package com.example.hikoya;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Locale;

import petrov.kristiyan.colorpicker.ColorPicker;

public class Entery extends AppCompatActivity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        Intent intent = getIntent();
        int pos_title = intent.getIntExtra( "pos_title",0 );
        String name_title = intent.getStringExtra( "name_title");
        setTitle( name_title );
        setContentView( R.layout.activity_entery );
        getSupportActionBar().setDisplayHomeAsUpEnabled( true );
          textView = findViewById( R.id.entry);
         textView.setText( getText( R.string.m1_1) );
    }
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
                textView.setTextSize( progress );


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
        final ColorPicker colorPicker = new ColorPicker(Entery.this );
        colorPicker.setTitle( "SHrift rangini tanlang " );

        ArrayList<String> colors = new ArrayList<>();
        colors.add("#258174");
        colors.add( "#3C8D2F" );
        colors.add( "#0d0f04" );
        colors.add( "#c639a4" );
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
                        textView.setTextColor( color );
                    }

                    @Override
                    public void onCancel() {

                    }

                } ).show();
    }
    public void openLanguageDialog(){
        final String[]  listname = {"Kril","Lotin"};
        AlertDialog.Builder mbuilder = new AlertDialog.Builder( Entery.this );
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