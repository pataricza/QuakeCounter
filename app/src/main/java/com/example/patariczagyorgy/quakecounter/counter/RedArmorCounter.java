package com.example.patariczagyorgy.quakecounter.counter;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Locale;

public class RedArmorCounter {

  private boolean redTimerRunning;
  private long redArmorMilisec = 26999;
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
       this.start();
      }
    }.start();

    redTimerRunning = true;
  }

  public void upDateRedTime() {
    int minutes = (int) (redArmorMilisec / 1000) / 60;
    int seconds = (int) (redArmorMilisec / 1000) % 60;

    String redTimer = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds-1);

    redArmorTime.setText(redTimer);
  }

  private void stopRedTimer() {
    redCountDownTimer.cancel();
    redTimerRunning = false;
  }
}
