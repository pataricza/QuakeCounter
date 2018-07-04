package com.example.patariczagyorgy.quakecounter;

import android.app.Activity;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.patariczagyorgy.quakecounter.counter.MegaHealthCounter;
import com.example.patariczagyorgy.quakecounter.counter.QuadDamageCounter;
import com.example.patariczagyorgy.quakecounter.counter.RedArmorCounter;

public class MainActivity extends Activity {

  private TextView quadDamageTime;
  private QuadDamageCounter quadDamageCounter;
  private Button pickedUpQuadDamage;

  private TextView megaHealthTime;
  private MegaHealthCounter megaHealthCounter;
  private Button pickedUpMegaHealth;

  private TextView redArmorTime;
  private RedArmorCounter redArmorCounter;
  private Button pickedUpRedArmor;

  private Button startMatch;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    quadDamageTime = findViewById(R.id.quadDamageTime);
    quadDamageCounter = new QuadDamageCounter(quadDamageTime);
    pickedUpQuadDamage = findViewById(R.id.pickedUpQuadDamage);

    megaHealthTime = findViewById(R.id.megaHealthTime);
    megaHealthCounter = new MegaHealthCounter(megaHealthTime);
    pickedUpMegaHealth = findViewById(R.id.pickedUpMegaHealth);

    redArmorTime = findViewById(R.id.redArmorTime);
    redArmorCounter = new RedArmorCounter(redArmorTime);
    pickedUpRedArmor = findViewById(R.id.pickedUpRedArmor);

    startMatch = findViewById(R.id.startMatch);

    startMatch.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View v) {
        redArmorCounter.startMatchTimer();
        megaHealthCounter.startMatchTimer();
      }
    });
  }
}
