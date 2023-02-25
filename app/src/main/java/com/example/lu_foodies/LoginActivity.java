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
import com.example.lu_foodies.RegistrationActivity;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {
    EditText email, pass;
    Button logIN;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        email = findViewById(R.id.editText2);
        pass = findViewById(R.id.editText3);
        logIN = findViewById(R.id.button);

        logIN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth = FirebaseAuth.getInstance();


                String Email = email.getText().toString();
                String Pass = pass.getText().toString();
                System.out.println("check_E: " + Email);
                System.out.println("Check_P: " + Pass);

                String passwordRegex = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[@$!%*#?&])[A-Za-z\\d@$!%*#?&]{8,}$";


                if (TextUtils.isEmpty(Email) || TextUtils.isEmpty(Pass)) {

                    email.setError("Field can not empty");
                    pass.setError("Field can not empty");


                    email.requestFocus();
                    pass.requestFocus();
                }else if (!Pass.matches(passwordRegex)) {
                    pass.setError("Password must contain at least 8 characters including a letter, a number, and a special character");
                    pass.requestFocus();
                } else {


                    mAuth.signInWithEmailAndPassword(Email, Pass)
                            .addOnSuccessListener(new OnSuccessListener<AuthResult>() {
                                @Override
                                public void onSuccess(AuthResult authResult) {
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    startActivity(intent);

                                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_LONG).show();

                                }
                            }).addOnFailureListener(new OnFailureListener() {
                                @Override
                                public void onFailure(@NonNull Exception e) {
                                    Toast.makeText(LoginActivity.this, "Login Failed", Toast.LENGTH_LONG).show();

                                }
                            });



                }
            }

            public void register(View view) {
                startActivity(new Intent(LoginActivity.this, RegistrationActivity.class));
            }

        });
    }
}
