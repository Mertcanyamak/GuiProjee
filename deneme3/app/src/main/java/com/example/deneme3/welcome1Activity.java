package com.example.deneme3;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class welcome1Activity extends AppCompatActivity {

    TextView textView3 , textView5;
    EditText editText7,editText8,editText9,editText10;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome1);

        textView3 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView5);
        editText7 = findViewById(R.id.editText7);
        editText8 = findViewById(R.id.editText8);
        editText9 = findViewById(R.id.editText9);
        editText10 = findViewById(R.id.editText10);
        button = findViewById(R.id.go);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Text7 = editText7.getText().toString();
                String Text8 = editText8.getText().toString();
                String Text9 = editText9.getText().toString();
                String Text10 = editText10.getText().toString();

                if (TextUtils.isEmpty(Text7) || TextUtils.isEmpty(Text8) || TextUtils.isEmpty(Text9) || TextUtils.isEmpty(Text10)) {
                    Toast.makeText(welcome1Activity.this, "Tüm Boşlukları Doldurun", Toast.LENGTH_SHORT).show();
                }else {
                    Intent intent = new Intent(welcome1Activity.this, welcomeActivity2.class);
                    startActivity(intent);
                }
            }
        });
    }
}