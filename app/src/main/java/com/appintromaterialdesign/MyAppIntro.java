package com.appintromaterialdesign;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.github.appintro.AppIntro;
import com.github.appintro.AppIntroFragment;

public class MyAppIntro extends AppIntro {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        addSlide(AppIntroFragment.newInstance("Welcome to App Intro One","One Beautiful Amazing App Intro",
                R.drawable.pank, ContextCompat.getColor(getApplicationContext(),R.color.first)));

        addSlide(AppIntroFragment.newInstance("Welcome to App Intro Two","Two Beautiful Amazing App Intro",
                R.drawable.music, ContextCompat.getColor(getApplicationContext(),R.color.second)));

        addSlide(AppIntroFragment.newInstance("Welcome to App Intro Three","Three Beautiful Amazing App Intro",
                R.drawable.pank, ContextCompat.getColor(getApplicationContext(),R.color.third)));


        sharedPreferences = getApplicationContext().getSharedPreferences("MyPreference", Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if (sharedPreferences != null)
        {
            boolean checkShared = sharedPreferences.getBoolean("checkStatus",false);

            if (checkShared == true)
            {
                startActivity(new Intent(getApplicationContext(),MainActivity.class));
                finish();
            }
        }
    }

    @Override
    protected void onSkipPressed(Fragment currentFragment) {
        super.onSkipPressed(currentFragment);

        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        editor.putBoolean("checkStatus",false).commit();
        finish();
    }

    @Override
    protected void onDonePressed(Fragment currentFragment) {
        super.onDonePressed(currentFragment);

        startActivity(new Intent(getApplicationContext(),MainActivity.class));
        editor.putBoolean("checkStatus",true).commit();
finish();
    }
}
