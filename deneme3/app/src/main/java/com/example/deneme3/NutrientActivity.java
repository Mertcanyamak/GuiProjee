package com.example.deneme3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class NutrientActivity extends AppCompatActivity {
    ImageButton bell,back,menu;
    Button cal,nut,gi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nutrient);

        bell = findViewById(R.id.bellnut);
        back = findViewById(R.id.imageButton4);
        cal = findViewById(R.id.calories2);
        nut = findViewById(R.id.nutriens);
        gi = findViewById(R.id.glycemixindex);
        menu = findViewById(R.id.mainnut);


        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LeftBarActivity.class);
                startActivity(intent);

            }
        });




        bell.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });




        nut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NutrientActivity.class);
                startActivity(intent);

            }
        });

        gi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), GlicemikActivity.class);
                startActivity(intent);

            }
        });

    }
}
