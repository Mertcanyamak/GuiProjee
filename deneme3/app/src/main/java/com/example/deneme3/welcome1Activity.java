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

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class welcome1Activity extends AppCompatActivity {

    TextView textView3 , textView5;
    EditText height,goalWeight,location,age;
    Button button;
    private FirebaseAuth mAuth;
    private FirebaseDatabase database;
    private DatabaseReference myRef;
    private FirebaseUser firebaseUser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome1);

        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();
        firebaseUser = mAuth.getCurrentUser();

        textView3 = findViewById(R.id.textView3);
        textView5 = findViewById(R.id.textView5);
        height = findViewById(R.id.height);
        age = findViewById(R.id.age);
        location = findViewById(R.id.location);
        goalWeight = findViewById(R.id.goalWeight);
        button = findViewById(R.id.go);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String height1 = height.getText().toString();
                String age1 = age.getText().toString();
                String location1 = location.getText().toString();
                String goalWeight1 = goalWeight.getText().toString();

                if (TextUtils.isEmpty(height1) || TextUtils.isEmpty(age1) || TextUtils.isEmpty(location1) || TextUtils.isEmpty(goalWeight1)) {
                    Toast.makeText(welcome1Activity.this, "Tüm Boşlukları Doldurun", Toast.LENGTH_SHORT).show();
                }else {
                    HashMap<String, Object> userMap = new HashMap<>();
                    userMap.put("height", height1);
                    userMap.put("age", age1);
                    userMap.put("location", location1);
                    userMap.put("goalWeight", goalWeight1);
                    myRef.child("UserInfo").child(firebaseUser.getUid()).updateChildren(userMap);

                    Intent intent = new Intent(welcome1Activity.this, welcomeActivity2.class);
                    startActivity(intent);
                }
            }
        });
    }
}