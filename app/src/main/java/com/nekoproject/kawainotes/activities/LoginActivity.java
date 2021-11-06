package com.nekoproject.kawainotes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nekoproject.kawainotes.R;

public class LoginActivity extends AppCompatActivity {

    EditText editTextEmail;
    EditText editTextPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        editTextEmail = findViewById(R.id.edit_text_email);
        editTextPassword = findViewById(R.id.edit_text_password);

    }

    public void getLogin4(View view) {

        if (TextUtils.isEmpty(editTextEmail.getText().toString().trim()) && TextUtils.isEmpty(editTextPassword.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email and Password can't be Emty!", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(editTextEmail.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email can't be Emty!", Toast.LENGTH_SHORT).show();
        }
        else {
            if (!isValidEmail(editTextEmail.getText().toString().trim())) {
                Toast.makeText(view.getContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
            }else if (TextUtils.isEmpty(editTextPassword.getText().toString().trim())){
                Toast.makeText(view.getContext(), "Password can't be Empty!", Toast.LENGTH_SHORT).show();
            } else{
                Intent i = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(i);
            }
        }
    }

    public void getResetPassword1(View view) {
        Intent i = new Intent(LoginActivity.this, VerifyEmailResetPasswordActivity.class);
        startActivity(i);
    }

    public static boolean isValidEmail(CharSequence email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());

    }
}