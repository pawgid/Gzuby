package com.greenbee.gzuby;

import android.icu.text.SimpleDateFormat;
import android.media.MediaMetadataRetriever;
import android.media.MediaPlayer;
import android.os.PowerManager;
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

    @BindView(R.id.duration)
    TextView durationTextView;

    @OnClick(R.id.play_button)
    protected void playClick(){

        textView.setText("PLAY");
        mediaPlayer = MediaPlayer.create(this, R.raw.incoming);
        mediaPlayer.setLooping(true);
        mediaPlayer.start();
        String duration = new SimpleDateFormat("mm:ss:SS").format(mediaPlayer.getDuration());
        durationTextView.setText("Dlugosc utworu: " + duration);
        mediaPlayer.setWakeMode(getApplicationContext(), PowerManager.PARTIAL_WAKE_LOCK);
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
