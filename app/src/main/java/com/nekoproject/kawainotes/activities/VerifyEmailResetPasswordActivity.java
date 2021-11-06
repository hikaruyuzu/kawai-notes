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

public class VerifyEmailResetPasswordActivity extends AppCompatActivity {

    EditText editTextEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify_email_reset_password);

        editTextEmail = findViewById(R.id.edit_text_email);
    }

    public void getResetPassword2(View view) {
        if (TextUtils.isEmpty(editTextEmail.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Email can't be Emty!", Toast.LENGTH_SHORT).show();
        }

        if(!isValidEmail(editTextEmail.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Invalid Email", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(VerifyEmailResetPasswordActivity.this, ResetPasswordActivity.class);
            startActivity(i);
        }
    }
    public static boolean isValidEmail(CharSequence email) {
        return (Patterns.EMAIL_ADDRESS.matcher(email).matches());
    }

}