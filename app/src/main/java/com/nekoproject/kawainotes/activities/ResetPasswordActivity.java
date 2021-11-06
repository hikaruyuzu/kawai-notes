package com.nekoproject.kawainotes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.nekoproject.kawainotes.R;

public class ResetPasswordActivity extends AppCompatActivity {

    EditText newTextPassword;
    EditText confirmTextPassword;
    EditText codeVeification;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        codeVeification = findViewById(R.id.edit_reset_code);
        newTextPassword = findViewById(R.id.edit_new_password);
        confirmTextPassword = findViewById(R.id.edit_confirm_password);
    }

    public void getResetPassword3(View view) {
        if (TextUtils.isEmpty(codeVeification.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Enter Verification Code", Toast.LENGTH_SHORT).show();
        }
        if (TextUtils.isEmpty(newTextPassword.getText().toString().trim()) && TextUtils.isEmpty(confirmTextPassword.getText().toString().trim())) {
            Toast.makeText(view.getContext(), "Password can't be Empty!", Toast.LENGTH_SHORT).show();
        } else {
        }
        if (!(newTextPassword.getText().toString().equals(confirmTextPassword.getText().toString()))) {
            Toast.makeText(view.getContext(), "The password you entered is not the same!", Toast.LENGTH_SHORT).show();
        } else {
            Intent i = new Intent(ResetPasswordActivity.this, SuceessChangePasswordActivity.class);
            startActivity(i);
        }
    }


    public final static boolean isValidCode(CharSequence target) {
        return android.util.Patterns.PHONE.matcher(target).matches();
    }
}