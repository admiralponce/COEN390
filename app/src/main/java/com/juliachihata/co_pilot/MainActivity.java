package com.juliachihata.co_pilot;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //setting text font for textview in main activity xml
    TextView mytv;
    Typeface myfont;
    BluetoothAdapter myBluetooth = null;
    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        myBluetooth = BluetoothAdapter.getDefaultAdapter();
        SharedPreferences preferences = getSharedPreferences("settings", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putInt("stop",0);
        editor.commit();

        //Get the ref of textview in the code
        mytv = (TextView)findViewById(R.id.copilot_title);
        myfont = Typeface.createFromAsset(this.getAssets(),"fonts/forced_square.ttf");
        mytv.setTypeface(myfont);

        //setting buttons for main activity
        Button but1=(Button) findViewById(R.id.calculations_button);
        Button but2=(Button) findViewById(R.id.awareness_button);
        Button but3=(Button) findViewById(R.id.dictionary_button);
        Button but4=(Button) findViewById(R.id.logbook_button);
        Button but5=(Button) findViewById(R.id.blue_button);

        if(!myBluetooth.isEnabled()) {
            Intent enableBtIntent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(enableBtIntent, 1);
        }


        but1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1= new Intent(MainActivity.this, CalculationsActivity.class);
                startActivity(int1);
            }


        });

        but2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int2= new Intent(MainActivity.this, AwarenessActivity.class);
                startActivity(int2);
            }

        });

        but3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int3= new Intent(MainActivity.this, DictionaryActivity.class);
                startActivity(int3);
            }
        });

        but4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int4= new Intent(MainActivity.this, LogbookActivity.class);
                startActivity(int4);
            }


        });

        but5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int5= new Intent(MainActivity.this, BluetoothSettingActivity.class);
                startActivity(int5);
            }


        });


    }
}
