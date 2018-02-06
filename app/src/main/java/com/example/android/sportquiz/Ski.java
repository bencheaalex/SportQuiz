package com.example.android.sportquiz;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.annotation.DrawableRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

public class Ski extends AppCompatActivity {

    int score;
    RadioButton q1a1;
    RadioButton q1a2;
    RadioButton q1a3;
    RadioButton q2a1;
    RadioButton q2a2;
    RadioButton q2a3;
    RadioButton q3a1;
    RadioButton q3a2;
    RadioButton q3a3;
    RadioButton q4a1;
    RadioButton q4a2;
    RadioButton q4a3;
    RadioButton q5a1;
    RadioButton q5a2;
    RadioButton q5a3;
    TextView endMessage;
    int counter;
    ScrollView scroll;
    TextView countDownText;
    CountDownTimer countDownTimer;
    long timeLeftInMilliseconds = 180000;
    Button home;
    Button submit_button;
    Button reset;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ski);

        startTimer();
        countDownText = findViewById(R.id.ski_timmer);
        scroll = findViewById(R.id.scrollView);

        endMessage = (TextView) findViewById(R.id.end_message);
        endMessage.setVisibility(View.INVISIBLE);

        reset = findViewById(R.id.reset_button);

        home = findViewById(R.id.home_button);

        q1a1 = findViewById(R.id.ski_q1_a1);
        q1a2 = findViewById(R.id.ski_q1_a2);
        q1a3 = findViewById(R.id.ski_q1_a3);


        q2a1 = findViewById(R.id.ski_q2_a1);
        q2a2 = findViewById(R.id.ski_q2_a2);
        q2a3 = findViewById(R.id.ski_q2_a3);

        q3a1 = findViewById(R.id.ski_q3_a1);
        q3a2 = findViewById(R.id.ski_q3_a2);
        q3a3 = findViewById(R.id.ski_q3_a3);


        q4a1 = findViewById(R.id.ski_q4_a1);
        q4a2 = findViewById(R.id.ski_q4_a2);
        q4a3 = findViewById(R.id.ski_q4_a3);


        q5a1 = findViewById(R.id.ski_q5_a1);
        q5a2 = findViewById(R.id.ski_q5_a2);
        q5a3 = findViewById(R.id.ski_q5_a3);


        submit_button = findViewById(R.id.submit_button);

        //when reset button is clicked, the page is reloaded
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent footballIntent = new Intent(Ski.this, Ski.class);
                startActivity(footballIntent);

            }
        });

        //when the home button is clicked, the MainActivity intent is opened
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent skiIntent = new Intent(Ski.this, MainActivity.class);
                startActivity(skiIntent);

            }
        });
    }

    //method for starting the countdown timer
    public void startTimer() {
        if (countDownTimer != null) stopTimer();
        countDownTimer = new CountDownTimer(timeLeftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLeftInMilliseconds = l;
                updateTimer();
            }

            @Override
            public void onFinish() {
            }
        }.start();
    }

    //method for stopping the countdown timer
    public void stopTimer() {
        countDownTimer.cancel();
    }

    //method for updating the countdown timer
    public void updateTimer() {
        int minutes = (int) timeLeftInMilliseconds / 60000;
        int seconds = (int) timeLeftInMilliseconds % 60000 / 1000;
        String timeLeftText;
        timeLeftText = "" + minutes;
        timeLeftText += ":";
        if (seconds < 10) timeLeftText += "0";
        timeLeftText += seconds;
        countDownText.setText(timeLeftText);
        if (minutes == 0 && seconds == 0) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.message_out_of_time), Toast.LENGTH_LONG).show();
            submitMethod();
        }
        if ((minutes == 0) && (seconds == 59)) {
            Toast.makeText(getApplicationContext(), getResources().getString(R.string.message_one_minute_left), Toast.LENGTH_LONG).show();
        }
    }

    //method for the submit button that will call the submitMethod only if all the questions were answered
    public void submit(View view) {
        counter = 0;
        verify();
        if (counter != 5)
            Toast.makeText(this, "Please respond to all questions!", Toast.LENGTH_LONG).show();
        else {
            submitMethod();
            stopTimer();
        }
    }

    /*this method will check the answers and will post the end messege with the score
    also it will call the method changeBackground
     */
    public void submitMethod() {
        score = 0;
        if (q1a2.isChecked())
            score += 2;
        if (q2a2.isChecked())
            score += 2;
        if (q3a3.isChecked())
            score += 2;
        if (q4a2.isChecked())
            score += 2;
        if (q5a3.isChecked())
            score += 2;
        endMessage.setText("You finished the ski Quiz!\nYour score is:  " + score + " out of 10!");
        endMessage.setVisibility(View.VISIBLE);
        endMessage.setBackgroundColor(getResources().getColor(android.R.color.holo_orange_light));
        changeBackground();
        disable();
        submit_button.setEnabled(false);

    }

    /*this method will change the background of the answers
    with green will be the correct answers
    with red will be the selected wrog answers*/
    public void changeBackground() {
        q1a2.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        q2a2.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        q3a3.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        q4a2.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));
        q5a3.setBackgroundColor(getResources().getColor(android.R.color.holo_green_light));

        if (q1a1.isChecked())
            q1a1.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        if (q1a3.isChecked())
            q1a3.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        if (q2a1.isChecked())
            q2a1.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        if (q2a3.isChecked())
            q2a3.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        if (q3a1.isChecked())
            q3a1.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        if (q3a2.isChecked())
            q3a2.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        if (q4a1.isChecked())
            q4a1.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        if (q4a3.isChecked())
            q4a3.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        if (q5a1.isChecked())
            q5a1.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
        if (q5a2.isChecked())
            q5a2.setBackgroundColor(getResources().getColor(android.R.color.holo_red_light));
    }

    /*this method is to block the radio buttons and the check box after submit button is selected
    it also change the color of disabled text to black so it can be visible*/
    public void disable() {
        q1a1.setEnabled(false);
        q1a2.setEnabled(false);
        q1a3.setEnabled(false);
        q2a1.setEnabled(false);
        q2a2.setEnabled(false);
        q2a3.setEnabled(false);
        q3a1.setEnabled(false);
        q3a2.setEnabled(false);
        q3a3.setEnabled(false);
        q4a1.setEnabled(false);
        q4a2.setEnabled(false);
        q4a3.setEnabled(false);
        q5a1.setEnabled(false);
        q5a2.setEnabled(false);
        q5a3.setEnabled(false);
        q1a1.setTextColor(getResources().getColor(android.R.color.black));
        q1a2.setTextColor(getResources().getColor(android.R.color.black));
        q1a3.setTextColor(getResources().getColor(android.R.color.black));
        q2a1.setTextColor(getResources().getColor(android.R.color.black));
        q2a2.setTextColor(getResources().getColor(android.R.color.black));
        q2a3.setTextColor(getResources().getColor(android.R.color.black));
        q3a1.setTextColor(getResources().getColor(android.R.color.black));
        q3a2.setTextColor(getResources().getColor(android.R.color.black));
        q3a3.setTextColor(getResources().getColor(android.R.color.black));
        q4a1.setTextColor(getResources().getColor(android.R.color.black));
        q4a2.setTextColor(getResources().getColor(android.R.color.black));
        q4a3.setTextColor(getResources().getColor(android.R.color.black));
        q5a1.setTextColor(getResources().getColor(android.R.color.black));
        q5a2.setTextColor(getResources().getColor(android.R.color.black));
        q5a3.setTextColor(getResources().getColor(android.R.color.black));

    }

    //method that verify if all questions were answered
    public void verify() {
        if (q1a1.isChecked() || q1a2.isChecked() || q1a3.isChecked())
            counter++;
        if (q2a1.isChecked() || q2a2.isChecked() || q2a3.isChecked())
            counter++;
        if (q3a1.isChecked() || q3a2.isChecked() || q3a3.isChecked())
            counter++;
        if (q4a1.isChecked() || q4a2.isChecked() || q4a3.isChecked())
            counter++;
        if (q5a1.isChecked() || q5a2.isChecked() || q5a3.isChecked())
            counter++;
    }
}
