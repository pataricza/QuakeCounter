package com.example.patariczagyorgy.quakecounter;

import android.app.Activity;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

  private TextView redArmorTime;
  private Button pickedUpRedArmor;
  private boolean redTimerRunning;
  private long redArmorMilisec = 25000;

  private Button startMatch;

  private CountDownTimer redCountDownTimer;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    redArmorTime = findViewById(R.id.redArmorTime);
    pickedUpRedArmor = findViewById(R.id.pickedUpRedArmor);
    startMatch = findViewById(R.id.startMatch);

    startMatch.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        startMatchTimer();
      }
    });
  }

  private void startMatchTimer() {
    if(redTimerRunning) {
      stopRedTimer();
    } else {
      startRedTimer();
    }
  }

  private void startRedTimer() {
    redCountDownTimer = new CountDownTimer(redArmorMilisec, 1000) {
      @Override
      public void onTick(long millisUntilFinished) {
        redArmorMilisec = millisUntilFinished;
        upDateRedTime();
      }

      @Override
      public void onFinish() {

      }
    }.start();

    redTimerRunning = true;
  }

  private void upDateRedTime() {
    int minutes = (int) redArmorMilisec / 60000;
    int seconds = (int) redArmorMilisec % 60000 / 1000;

    String redTimer;

    redTimer = "" + minutes;
    redTimer += ":";
    if(seconds < 10) {
      redTimer +="0";
    }
    redTimer += seconds;

    redArmorTime.setText(redTimer);
  }

  private void stopRedTimer() {
    redCountDownTimer.cancel();
    redTimerRunning = false;
  }
}
