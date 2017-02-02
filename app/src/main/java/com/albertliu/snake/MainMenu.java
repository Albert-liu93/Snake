package com.albertliu.snake;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;

public class MainMenu extends AppCompatActivity {

    private RelativeLayout snakeLayout;
    private Animation compileAnim;
    private AdView adView;
    private ImageView classicBtn;
    private ImageView noWallsBtn;
    private ImageView settingsBtn;
    private ImageView bombBtn;
    private TextView titleLeft, titleMiddle, titleRight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);
        snakeLayout = (RelativeLayout)findViewById(R.id.snake_layout);

        View decorView = getWindow().getDecorView();
        int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(uiOptions);
        if (getSupportActionBar() != null){
            getSupportActionBar().hide();
        }

        adView = new AdView(this);
        adView.setAdSize(AdSize.SMART_BANNER);
        adView.setAdUnitId(GameSettings.MY_AD_ID);

        snakeLayout.addView(adView);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        adView.loadAd(adRequest);


        initClassic();
        initNoWalls();
        initBomb();
        initSettings();
        initTitle();

    }

private void initClassic(){
    classicBtn = (ImageView) findViewById(R.id.classic);
    compileAnim = AnimationUtils.loadAnimation(MainMenu.this, R.anim.anim_for_classic_button);
    compileAnim.setDuration(GameSettings.ANIMATION_OPEN_BUTTON_DURATION);
    compileAnim.setAnimationListener(new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            classicBtn.setImageResource(R.mipmap.classic);
            classicBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intentClassic = new Intent(MainMenu.this, classicSnake.class);
                    intentClassic.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intentClassic);
                }
            });
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    });
    classicBtn.startAnimation(compileAnim);
    }

private void initNoWalls(){
    noWallsBtn = (ImageView) findViewById(R.id.no_walls);
    compileAnim = AnimationUtils.loadAnimation(MainMenu.this, R.anim.anim_for_no_button);
    compileAnim.setDuration(GameSettings.ANIMATION_OPEN_BUTTON_DURATION);
    compileAnim.setAnimationListener(new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(Animation animation) {
            //when animation ends start mode
            noWallsBtn.setImageResource(R.mipmap.no_walls);
            noWallsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(MainMenu.this, noWallsSnake.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);
                }
            });
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    });
    noWallsBtn.startAnimation(compileAnim);
}

    private void initBomb() {
        bombBtn = (ImageView) findViewById(R.id.bomb);
        compileAnim = AnimationUtils.loadAnimation(MainMenu.this, R.anim.anim_for_bomb_button);
        compileAnim.setDuration(GameSettings.ANIMATION_OPEN_BUTTON_DURATION);
        compileAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                bombBtn.setImageResource(R.mipmap.bombsnake);
                bombBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent bombSnakeIntent = new Intent(MainMenu.this, bombSnake.class);
                        bombSnakeIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(bombSnakeIntent);
                    }
                });

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        bombBtn.startAnimation(compileAnim);
    }

    private void initTitle(){
        titleLeft = (TextView) findViewById(R.id.snake_left);
        titleMiddle = (TextView) findViewById(R.id.snake_middle);
        titleRight = (TextView) findViewById(R.id.snake_right);

        compileAnim = AnimationUtils.loadAnimation(MainMenu.this, R.anim.back_anim_for_title_left);
        compileAnim.setDuration(GameSettings.ANIMATION_HIDE_TITLE_DURATION);
        compileAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        titleLeft.startAnimation(compileAnim);

        compileAnim = AnimationUtils.loadAnimation(MainMenu.this, R.anim.back_anim_for_title_middle);
        compileAnim.setDuration(GameSettings.ANIMATION_HIDE_TITLE_DURATION);
        compileAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        titleMiddle.startAnimation(compileAnim);

        compileAnim = AnimationUtils.loadAnimation(MainMenu.this, R.anim.back_anim_for_title_right);
        compileAnim.setDuration(GameSettings.ANIMATION_HIDE_TITLE_DURATION);
        compileAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        titleRight.startAnimation(compileAnim);
    }

private void initSettings(){
    settingsBtn = (ImageView)findViewById(R.id.settings);
    compileAnim = AnimationUtils.loadAnimation(MainMenu.this, R.anim.anim_for_settings_button);
    compileAnim.setDuration(GameSettings.ANIMATION_OPEN_BUTTON_DURATION);
    compileAnim.setAnimationListener(new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }

        @Override
        public void onAnimationEnd(final Animation animation) {
            settingsBtn.setImageResource(R.mipmap.settings);
            settingsBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    getWindow().setFlags(WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE,
                            WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE);
                    settingsBtn.setImageResource(R.mipmap.menu_options);
                    classicBtn.setImageResource(R.mipmap.menu_options);
                    bombBtn.setImageResource(R.mipmap.menu_options);
                    noWallsBtn.setImageResource(R.mipmap.menu_options);

                    Animation animation1= AnimationUtils.loadAnimation(MainMenu.this, R.anim.reverse_for_classic_button);
                    animation1.setDuration(GameSettings.ANIMATION_CLOSE_BUTTON_DURATION);

                    Animation animation2= AnimationUtils.loadAnimation(MainMenu.this, R.anim.reverse_for_bomb_button);
                    animation2.setDuration(GameSettings.ANIMATION_CLOSE_BUTTON_DURATION);

                    Animation animation3= AnimationUtils.loadAnimation(MainMenu.this, R.anim.reverse_for_no_button);
                    animation3.setDuration(GameSettings.ANIMATION_CLOSE_BUTTON_DURATION);

                    Animation animation4= AnimationUtils.loadAnimation(MainMenu.this, R.anim.reverse_for_settings_button);
                    animation4.setDuration(GameSettings.ANIMATION_CLOSE_BUTTON_DURATION);

                    Animation animationtitleLeft= AnimationUtils.loadAnimation(MainMenu.this, R.anim.anim_for_title_left);
                    animationtitleLeft.setDuration(GameSettings.ANIMATION_SHOW_TITLE_DURATION);

                    Animation animationtitleMiddle= AnimationUtils.loadAnimation(MainMenu.this, R.anim.anim_for_title_middle);
                    animationtitleMiddle.setDuration(GameSettings.ANIMATION_SHOW_TITLE_DURATION);

                    Animation animationtitleRight= AnimationUtils.loadAnimation(MainMenu.this, R.anim.anim_for_title_right);
                    animationtitleRight.setDuration(GameSettings.ANIMATION_SHOW_TITLE_DURATION);

                    classicBtn.startAnimation(animation1);
                    bombBtn.startAnimation(animation2);
                    noWallsBtn.startAnimation(animation3);
                    settingsBtn.startAnimation(animation4);
                    titleLeft.startAnimation(animationtitleLeft);
                    titleMiddle.startAnimation(animationtitleMiddle);
                    titleRight.startAnimation(animationtitleRight);

                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent settingsIntent = new Intent(MainMenu.this, Settings.class);
                            settingsIntent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                            startActivity(settingsIntent);
                        }
                    }, GameSettings.START_NEW_ACTIVITY_DURATION);

                }
            });
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    });
    settingsBtn.setAnimation(compileAnim);
}


}
