package com.example.admin.text2speech;

import android.media.MediaPlayer;
import android.provider.MediaStore;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements TextToSpeech.OnInitListener {
EditText e;
Button b ,b1,b2;
MediaPlayer mp1,mp2;
TextToSpeech tts;
String s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tts=new TextToSpeech(MainActivity.this,this);
        e= findViewById(R.id.e1);
        b=findViewById(R.id.b);
        mp1=MediaPlayer.create(this,R.raw.song1);
        mp2=MediaPlayer.create(this,R.raw.song2);
        b1=findViewById(R.id.b2);
        b2=findViewById(R.id.b3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             s=e.getText().toString();
             tts.speak(s,TextToSpeech.QUEUE_ADD,null);
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               if(mp2.isPlaying()){
                   mp2.pause();
                   mp1.start();
               }
               else {
                   mp1.start();
               }
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp1.isPlaying()){
                    mp1.pause();
                    mp2.start();
                }
                else {
                    mp2.start();
                }
            }
        });
    }

    @Override
    public void onInit(int i) {
    //text2speechmethod
        tts.setLanguage(Locale.ENGLISH);
        tts.setSpeechRate(0.8f);
    }
}
