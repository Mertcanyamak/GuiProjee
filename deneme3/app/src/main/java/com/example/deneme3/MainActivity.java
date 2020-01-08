package com.example.deneme3;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.ProviderQueryResult;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {
    private EditText editTextEmail, editTextPassword;
    public Button btn_gonder;
    private FirebaseAuth mAuth;
    private String txt_email;
    private String txt_password;
    private boolean isAlreadySignUp;
    private FirebaseDatabase database;
    private DatabaseReference myRef;


    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize Firebase Auth
        mAuth = FirebaseAuth.getInstance();
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference();

        editTextEmail = findViewById(R.id.editTextEmail);
        editTextPassword = findViewById(R.id.editTextPassword);
        btn_gonder = findViewById(R.id.login);


        btn_gonder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 txt_email = editTextEmail.getText().toString();
                 txt_password = editTextPassword.getText().toString();

                 if(isUserAlreadySignUp()){
                     signIn();
                 }else{
                     createNewUser();
                 }


                if (TextUtils.isEmpty(txt_email) || TextUtils.isEmpty(txt_password)) {
                    Toast.makeText(MainActivity.this, "Tüm Boşlukları Doldurun", Toast.LENGTH_SHORT).show();
                } else {

                }

            }
        });



    }

    public boolean isUserAlreadySignUp(){

        mAuth.fetchProvidersForEmail(txt_email).addOnCompleteListener(new OnCompleteListener<ProviderQueryResult>() {
            @Override
            public void onComplete(@NonNull Task<ProviderQueryResult> task) {
                isAlreadySignUp =  !task.getResult().getProviders().isEmpty();
            }
        });
        return isAlreadySignUp;
    }

    public void createNewUser(){

        mAuth.createUserWithEmailAndPassword(txt_email, txt_password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("information", "createUserWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            sendToWelcome1();
                            HashMap<String, Object> userMap = new HashMap<>();
                            userMap.put("email", user.getEmail());
                            myRef.child("UserInfo").child(user.getUid()).setValue(userMap);
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("information", "createUserWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }

    public void sendToWelcome1(){
        Intent intent = new Intent(MainActivity.this, welcome1Activity.class);
        startActivity(intent);
    }
    public void signIn(){
        mAuth.signInWithEmailAndPassword(txt_email, txt_password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();
                            sendToWelcome1();
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(MainActivity.this, "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }

                        // ...
                    }
                });
    }


}
