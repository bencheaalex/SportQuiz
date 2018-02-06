package com.example.android.sportquiz;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout football = (LinearLayout) findViewById(R.id.football_view);
        LinearLayout ski = (LinearLayout) findViewById(R.id.ski_view);

        //Link to Football intent
        football.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent footballIntent = new Intent(MainActivity.this, Football.class);
                startActivity(footballIntent);

            }
        });

        //Link to Ski intent
        ski.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent skiIntent = new Intent(MainActivity.this, Ski.class);
                startActivity(skiIntent);
            }
        });

    }
}
