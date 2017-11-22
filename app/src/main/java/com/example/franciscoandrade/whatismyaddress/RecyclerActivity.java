package com.example.franciscoandrade.whatismyaddress;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class RecyclerActivity extends AppCompatActivity {

    private SharedPreferences registerPrefs;
    private static final String SHARED_PREFS_KEY = "address_shared_preferences";
     EmailViewHolder emailAdapter;
     ArrayList<Email> emailList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        ArrayList<String>list= new ArrayList<>();

        String texto = getIntent().getExtras().getString("sharedpref");

        registerPrefs = getApplicationContext().getSharedPreferences(SHARED_PREFS_KEY, MODE_PRIVATE);

        Map<String, ?> allEntries = registerPrefs.getAll();
        for (Map.Entry<String, ?> entry : allEntries.entrySet()) {
                list.add(entry.getValue()+"");

        }


        final RecyclerView emailRecyclerView= (RecyclerView)findViewById(R.id.idrecyclerView);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        emailRecyclerView.setLayoutManager(linearLayoutManager);

        for (int i=0; i<list.size(); i++){

            emailList.add(new Email(list.get(i)));
        }


       emailAdapter=new EmailViewHolder(emailList);
//        emailAdapter.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Toast.makeText(getApplicationContext(), "Selccion: "+emailList.get
//                        (emailRecyclerView.getChildAdapterPosition(view))
//                        .getEmail(), Toast.LENGTH_SHORT).show();
//            }
//        });



        emailRecyclerView.setAdapter(emailAdapter);



    }
}
