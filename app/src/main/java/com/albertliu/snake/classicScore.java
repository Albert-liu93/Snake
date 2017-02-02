package com.albertliu.snake;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class classicScore extends AppCompatActivity {

    private TextView scoreTextView, highScoreTextView;
    private ImageView  playAgainImageView, mainMenuImageView;
    private Animation animation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic_score);


    }

    private void initScore(){
        scoreTextView = (TextView)findViewById(R.id.player_score);
        animation = AnimationUtils.loadAnimation(this, R.anim.anim_for_classic_button);
        animation.setDuration(GameSettings.ANIMATION_OPEN_BUTTON_DURATION);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                SharedPreferences preferences = getApplicationContext().getSharedPreferences(GameSettings.PREF_NAME,
                        Context.MODE_PRIVATE);
                int playerScore = preferences.getInt("Score", 0);
                scoreTextView.setText("Score: " + String.valueOf(playerScore));
                scoreTextView.setTextColor(Color.WHITE);
                scoreTextView.setGravity(Gravity.CENTER);
                scoreTextView.setBackgroundResource(R.mipmap.menu_options);

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        scoreTextView.startAnimation(animation);
    }

    private void initHighScore(){
        highScoreTextView = (TextView)findViewById(R.id.mode_high_score);
        animation = AnimationUtils.loadAnimation(this, R.anim.anim_for_no_button);
        animation.setDuration(GameSettings.ANIMATION_OPEN_BUTTON_DURATION);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
              setHighScore();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        highScoreTextView.startAnimation(animation);
    }

    private void initPlayAgain(){
        playAgainImageView = (ImageView) findViewById(R.id.play_again);
        animation = AnimationUtils.loadAnimation(this, R.anim.anim_for_settings_button);
        animation.setDuration(GameSettings.ANIMATION_OPEN_BUTTON_DURATION);
        animation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                playAgainImageView.setImageResource(R.mipmap.again);
                playAgainImageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intentClassicMode = new Intent(classicScore.this, classicSnake.class);
                        intentClassicMode.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intentClassicMode);
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        playAgainImageView.startAnimation(animation);
    }

    private void setHighScore(){
        SharedPreferences preferences = getApplicationContext().getSharedPreferences(
                GameSettings.PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        int highScore = preferences.getInt("HighScoreClassic", 0);
        int lastScore = preferences.getInt("Score", 0);
        if (lastScore > highScore){
            editor.putInt("HighScoreClassic", lastScore);
            editor.commit();
            highScore = lastScore;
        }
        highScoreTextView = (TextView)findViewById(R.id.mode_high_score);
        highScoreTextView.setText(String.valueOf(highScore));
        highScoreTextView.setTextColor(Color.WHITE);
        highScoreTextView.setGravity(Gravity.CENTER);
        highScoreTextView.setBackgroundResource(R.mipmap.menu_options);
    }









}

