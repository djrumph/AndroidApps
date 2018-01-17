package com.example.dj.playing;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    // creates two sound variables
     MediaPlayer sound;
     MediaPlayer wrongSound;
    Button play;
    int count ;
    TextView mTextView;
    String info;
    private static final String TAG = "MainActivity";
    private String TEXT_CONTENTS = "TextContents";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // sets the title though it won't be seen
        setTitle("Test v0.04");

        super.onCreate(savedInstanceState);
        // an attempt at removing the title
        // only works before minimizing and reopening app window
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);

        // enables full screen immersive view
        getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);

        setContentView(R.layout.activity_main);


        //assigns sound files to variables
        sound = MediaPlayer.create(this, R.raw.bathroom);
        wrongSound = MediaPlayer.create(this, R.raw.recording);

        mTextView = (TextView) findViewById(R.id.textView);



    }

    //method to start the sound
    public void playMusic(View view) {
            sound.start();
            info = Integer.toString(count);

        count++;
        TEXT_CONTENTS = Integer.toString(count);
        mTextView.setText(TEXT_CONTENTS);


    }

    //method to start the sound
    public void playWrong (View view)
    {
        wrongSound.start();
    }

    public int clickCounter()
    {

        return this.count;

    }

    @Override
    protected void onRestart() {
        Log.d(TAG,"onRestart: in");
        super.onRestart();
        Log.d(TAG, "onRestart");
    }

    @Override
    protected void onPause() {
        Log.d(TAG,"onPause: in");
        super.onPause();
        Log.d(TAG, "onPause: out");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //where you save variables
        Log.d(TAG, "onSaveInstanceState: in");
        outState.putString(TEXT_CONTENTS, mTextView.getText().toString());
        super.onSaveInstanceState(outState);
        Log.d(TAG, "onSaveInstanceState: out");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        Log.d(TAG,"onRestoreInstanceState: in" );
        super.onRestoreInstanceState(savedInstanceState);
        String savedString = savedInstanceState.getString(TEXT_CONTENTS);
        mTextView.setText(savedString);
        Log.d(TAG,"onRestoreInstanceState: out" );
    }

    @Override
    protected void onStart() {
        Log.d(TAG, "onStart: in");
        super.onStart();
        Log.d(TAG, "onStart: out");
    }

    @Override
    protected void onResume() {
        Log.d(TAG,"onResume");
        super.onResume();
        Log.d(TAG, "onResume");
    }
}


