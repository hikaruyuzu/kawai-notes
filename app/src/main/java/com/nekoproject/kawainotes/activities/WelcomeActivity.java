package com.nekoproject.kawainotes.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.nekoproject.kawainotes.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
    }

    public void registerWelcome(View view) {
        Intent i = new Intent(WelcomeActivity.this, RegisterActivity.class);
        startActivity(i);

    }

    public void getLogin(View view) {
        Intent i = new Intent(WelcomeActivity.this, LoginActivity.class);
        startActivity(i);
    }
}