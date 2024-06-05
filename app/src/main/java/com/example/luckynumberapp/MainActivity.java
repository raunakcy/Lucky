package com.example.luckynumberapp;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    TextView txtTitle;
    EditText edtName ;
    Button btnOpen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtTitle =findViewById(R.id.txtTitle);
        btnOpen =findViewById(R.id.btnOpen);
        edtName = findViewById(R.id.edtName);

        btnOpen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userName = edtName.getText().toString();


                //Explicit intent
                Intent i = new Intent(getApplicationContext(), SecondActivity.class);

                //passing the name to second activity

                i.putExtra("name",userName);
                startActivity(i);

            }
        });
    }
}