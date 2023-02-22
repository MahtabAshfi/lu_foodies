package com.example.lu_foodies;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.lu_foodies.MainActivity;
import com.example.lu_foodies.R;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationActivity extends AppCompatActivity {
    EditText fullName,Email, pass;
    Button logIn;
    FirebaseAuth mAuth;
    FirebaseFirestore firestore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        fullName = findViewById(R.id.editText);
        Email = findViewById(R.id.editText2);
        pass = findViewById(R.id.editText3);

        logIn= findViewById(R.id.button);

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();
                firestore = FirebaseFirestore.getInstance();

                String FullName = fullName.getText().toString();
                String email = Email.getText().toString().trim();
                String Pass = pass.getText().toString();

                String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";





                if (TextUtils.isEmpty(FullName) || TextUtils.isEmpty(email) || TextUtils.isEmpty(Pass) ){
                    fullName.setError("Field can not empty");
                    Email.setError("Field can not empty");
                    pass.setError("Field can not empty");

                    fullName.requestFocus();
                    Email.requestFocus();
                    pass.requestFocus();
                }else if (!Pass.matches(passwordRegex)) {
                    pass.setError("Password must contain at least 8 characters including a letter, a number, and a special character");
                    pass.requestFocus();
                } else{
                    mAuth.createUserWithEmailAndPassword(email, Pass)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    firestore.collection("Users").document(FirebaseAuth.getInstance().getUid()).set(new model(FullName, email));
                                    Intent intent = new Intent(RegistrationActivity.this, MainActivity.class);
                                    startActivity(intent);
                                    finish();
                                    Toast.makeText(RegistrationActivity.this, "Reg Successfull", Toast.LENGTH_LONG).show();


                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(RegistrationActivity.this, "Reg Failed", Toast.LENGTH_LONG).show();
                                }
                            });

                }

            }
        });

    }

    public void login(View view) {
        startActivity(new Intent(RegistrationActivity.this, LoginActivity.class));
    }


}