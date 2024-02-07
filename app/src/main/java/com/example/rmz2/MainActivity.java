package com.example.rmz2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

//          ▄▌▐▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▌
//       ▄▄██▌█ Autor: Sovyshka
//    ▄▄▄▌▐██▌█ Name: Bohdan Savchenko
//    ███████▌█▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▌
//    ▀(@)▀▀▀▀▀▀▀(@)(@)▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀(@)▀


public class MainActivity extends AppCompatActivity {
    private Button button;
    private int clickCounter;
    private TextView hackWriter;
    private String pauseString = "";
    private String[] joke = {
            "Random text 1",
            "Random text 2",
            "Random text 3",
            "Random text 4",
            "Random text 5",
            "Random text 6",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.click_me_button);
    }

    @Override
    protected void onStart() {
        super.onStart();

        hackWriter = findViewById(R.id.hackWriter);
        int randomIndex = (int) (Math.random() * joke.length);

        hackWriter.setText(joke[randomIndex]);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handleButtonClick();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        showToast("Shut me down!", Toast.LENGTH_SHORT);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        if (clickCounter > 0) {
            setButtonStyle(button, Color.BLACK, Color.WHITE, "Why did you come back?");
            hackWriter.setVisibility(View.GONE);
            clickCounter = 0;
        }
    }

    private void handleButtonClick(){
        if(clickCounter == 0){
            setButtonStyle(button, Color.BLACK, Color.WHITE, "Don't click on me anymore!");
            showToast("Hey, why you clicked me?!", Toast.LENGTH_SHORT);
            hackWriter.setVisibility(View.GONE);
            clickCounter++;

        }else if(clickCounter == 1){
            setButtonStyle(button, Color.WHITE, Color.BLACK, "Dude, you're not serious");
            clickCounter++;
        }else if(clickCounter == 2){
            showToast("I'm done with you!", Toast.LENGTH_LONG);
            finish();
        }
    }

    private void setButtonStyle(Button btn, int backgroundColor, int textColor, String buttonText) {
        btn.setBackgroundColor(backgroundColor);
        btn.setTextColor(textColor);
        btn.setText(buttonText);
    }

    private void showToast(String message, int duration) {
        Toast.makeText(this, message, duration).show();
    }
}