package com.example.franciscoandrade.whatismyaddress;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity {

    TextView text1;
    TextView text2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        text1=(TextView)findViewById(R.id.text1);
        text2=(TextView)findViewById(R.id.text2);
    }
}
