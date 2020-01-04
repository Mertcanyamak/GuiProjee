package com.example.deneme3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class LeftBarActivity extends AppCompatActivity {
    ImageView user;
    ImageButton anamenu;
    Button mainmenubar,dailybar,progressbar,goalsbar,nutritionbar,waterreqbar,receipbar,settingsbar,logoutbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leftbar);

        user = findViewById(R.id.imageView15);
        anamenu = findViewById(R.id.imageButton2);
        dailybar = findViewById(R.id.dailybar);
        progressbar = findViewById(R.id.progressbar);
        goalsbar = findViewById(R.id.goalsbar);
        nutritionbar = findViewById(R.id.nutritionbar);
        waterreqbar = findViewById(R.id.waterreqbar);
        receipbar = findViewById(R.id.receipbar);
        settingsbar = findViewById(R.id.settingsbar);
        logoutbar = findViewById(R.id.logoutbar);

        anamenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), LeftBarActivity.class);
                startActivity(intent);

            }
        });

        nutritionbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), NutrientActivity.class);
                startActivity(intent);

            }
        });

        waterreqbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), WaterreqActivity.class);
                startActivity(intent);

            }
        });

        logoutbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Log_outActivity.class);
                startActivity(intent);

            }
        });
    }

}