package com.example.franciscoandrade.whatismyaddress;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText text1;
    Button btn1;
    Button btn2;

    private static final String SHARED_PREFS_KEY = "address_shared_preferences";
    private SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        text1    = (EditText) findViewById(R.id.idEditText1);
        btn1     = (Button)findViewById(R.id.idBtn1);
        btn2     = (Button)findViewById(R.id.idBtn2);

        sharedPreferences = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

    }

    public void onClick(View view) {

        SharedPreferences.Editor editor = sharedPreferences.edit();
        switch (view.getId()){

            case R.id.idBtn1:
                    editor.putString(text1.getText().toString(), text1.getText().toString());
                    editor.commit();
                    text1.setText("");
//
                break;
            case R.id.idBtn2:
                Intent intent= new Intent(MainActivity.this, RecyclerActivity.class);
                intent.putExtra("sharedpref", SHARED_PREFS_KEY);
                break;


        }

    }
}
