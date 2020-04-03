package com.example.timestablesapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar seekBar=findViewById(R.id.seekBar);
        final ListView myListView=findViewById(R.id.myListView);
        seekBar.setMax(20);
        seekBar.setProgress(10);



        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
               int min=1;
               int timesTableNumber;
               if(progress<min)
               {
                   timesTableNumber=min;
                   seekBar.setProgress(min);
               }
               else
               {
                   timesTableNumber=progress;
               }

                ArrayList<String> timesTableContent=new ArrayList<String>();

               for(int i=1;i<11;i++)
               {
                   timesTableContent.add(Integer.toString(timesTableNumber*i));
               }
                ArrayAdapter<String> arrayAdapter=new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,timesTableContent);
               myListView.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}
