package com.example.patariczagyorgy.quakecounter.counter;

import android.os.CountDownTimer;
import android.widget.TextView;

import java.util.Locale;

public class MegaHealthCounter {

    private static final long MEGA_HEALTH_MILISEC = 36999;

    private boolean megaTimerRunning;
    private long megaHealthMilisec = MEGA_HEALTH_MILISEC;
    private TextView megaHealthTime;
    private CountDownTimer megaCountDownTimer;

    public MegaHealthCounter(TextView megaHealthTime) {
        this.megaHealthTime = megaHealthTime;
    }

    public void startMatchTimer() {
        if(megaTimerRunning) {
            stopMegaTimer();
        } else {
            startMegaTimer();
        }
    }

    private void startMegaTimer() {
        megaCountDownTimer = new CountDownTimer(megaHealthMilisec, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                megaHealthMilisec = millisUntilFinished;
                upDateMegaTime();
            }

            @Override
            public void onFinish() {
                this.start();
            }
        }.start();

        megaTimerRunning = true;
    }

    public void upDateMegaTime() {
        int minutes = (int) (megaHealthMilisec / 1000) / 60;
        int seconds = (int) (megaHealthMilisec / 1000) % 60;

        String megaTimer = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds-1);

        megaHealthTime.setText(megaTimer);
    }

    private void stopMegaTimer() {
        megaCountDownTimer.cancel();
        megaHealthMilisec = MEGA_HEALTH_MILISEC;
        upDateMegaTime();
        megaTimerRunning = false;
    }
}
