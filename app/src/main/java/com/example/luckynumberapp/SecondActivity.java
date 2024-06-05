package com.example.luckynumberapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Random;

public class SecondActivity extends AppCompatActivity {
    TextView txtTitle,textView;
    Button btnShare;
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        txtTitle = findViewById(R.id.txtTitle);
        textView = findViewById(R.id.textView);
        btnShare = findViewById(R.id.btnShare);


        //retrieve the data from Main activity to second activity

        Intent i = getIntent();
        String userName = i.getStringExtra("name");


        //Generating random  number
        int random_num = generateRandomNumber();

        textView.setText(""+random_num);
        btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareContent(userName,random_num);

            }
        });
    }




    public int generateRandomNumber(){
        Random random = new Random();  //Random number object creation from java class
        int upper_Limit = 1000;            // set a max limit of 1-1000
       int  randomNumberGenerated = random.nextInt(upper_Limit);
       return randomNumberGenerated;

    }
    public void shareContent(String userName,int random_num){
        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType("text/plain");

        //Additional info
        i.putExtra(Intent.EXTRA_SUBJECT,userName+"got lucky today!");
        i.putExtra(Intent.EXTRA_TEXT,"His lucky number is:"+random_num);
        startActivity(Intent.createChooser(i,"Choose a platform"));
    }
}