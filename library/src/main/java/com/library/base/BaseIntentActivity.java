package com.library.base;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

public class BaseIntentActivity extends AppCompatActivity {
    public void startActivity(Class<? extends Activity> tarActivity) {
        Intent intent = new Intent(this, tarActivity);
        startActivity(intent);
    }
}
