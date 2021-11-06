package com.nekoproject.kawainotes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nekoproject.kawainotes.R;

public class SuceessChangePasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suceess_change_password);
    }

    public void loginNow5(View view) {
        Intent i = new Intent(SuceessChangePasswordActivity.this, LoginActivity.class);
        startActivity(i);
    }
}