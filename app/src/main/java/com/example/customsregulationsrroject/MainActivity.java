package com.example.customsregulationsrroject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void countries_click(View v)
    {
        startActivity (new Intent(this, CountryRulsList.class));
    }
    public void facts_click(View v)
    {
        startActivity (new Intent(this, CountryFactsList.class));
    }
}