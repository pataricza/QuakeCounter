package com.example.patariczagyorgy.quakecounter.counter;

import android.os.CountDownTimer;
import android.widget.TextView;

public class RedArmorCounter {

  private boolean redTimerRunning;
  private long redArmorMilisec = 25000;
  private TextView redArmorTime;
  private CountDownTimer redCountDownTimer;

  public RedArmorCounter(TextView redArmorTime) {
    this.redArmorTime = redArmorTime;
  }

  public void startMatchTimer() {
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
