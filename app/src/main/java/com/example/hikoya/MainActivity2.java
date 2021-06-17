package com.example.hikoya;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    RecyclerView recyclerView;
    List<Version> versionList;
      protected void onCreate(Bundle savedInstanceState){
          super.onCreate( savedInstanceState );
          setContentView( R.layout.activity_main2 );
          recyclerView = findViewById( R.id.recycleView   );
          initData();
          setRecycleView();
          
      }

    private void setRecycleView() {
          VersionAdapter versionAdapter =  new VersionAdapter( versionList );
          recyclerView.setAdapter( versionAdapter );
          recyclerView.setHasFixedSize(  true);
    }

    private void initData() {
          versionList = new ArrayList<>();
          versionList.add( new Version( getString( R.string.m9_1 ) ,getString( R.string.m9_1_1 )) );
          versionList.add( new Version( getString( R.string.m9_2 ) ,getString( R.string.m_9_2 )) );
          versionList.add( new Version( getString( R.string.m9_3 ) ,getString( R.string.m_9_3 )) );
         versionList.add( new Version( getString( R.string.m9_4) ,getString( R.string.m_9_4 )) );
        versionList.add( new Version( getString( R.string.m9_5 ) ,getString( R.string.m_9_5 )) );
        versionList.add( new Version( getString( R.string.m9_6 ) ,getString( R.string.m_9_6 )) );
        versionList.add( new Version( getString( R.string.m9_7 ) ,getString( R.string.m_9_7 )) );
        versionList.add( new Version( getString( R.string.m9_8 ) ,getString( R.string.m_9_8 )) );
        versionList.add( new Version( getString( R.string.m9_9) ,getString( R.string.m_9_9 )) );

    }
}