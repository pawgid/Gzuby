package com.greenbee.gzuby;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    private MediaPlayer mediaPlayer;

    @BindView(R.id.text_view)
    TextView textView;

    @OnClick(R.id.play_button)
    protected void playClick(){

        textView.setText("PLAY");
        mediaPlayer = MediaPlayer.create(this, R.raw.oblivion);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
    }

    @OnClick(R.id.stop_button)
    protected void stopClick(){
        mediaPlayer.stop();
        mediaPlayer.release();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

    }
}
