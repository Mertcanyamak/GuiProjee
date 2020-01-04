package com.example.deneme3;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class welcomeActivity2 extends AppCompatActivity {

    ImageButton imageButton11 , imageButton12;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome2);

        imageButton11 = findViewById(R.id.imageButton11);
        imageButton12 = findViewById(R.id.imageButton12);

        imageButton11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LeftBarActivity.class);
                startActivity(intent);
            }
        });

        imageButton12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(welcomeActivity2.this, LeftBarActivity.class);
                startActivity(intent);
            }
        });
    }
}