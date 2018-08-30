package com.example.nit_appdev_002.quizapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent(this, QuizActivity.class);
        startActivity(intent);
        finish();
    }

}
