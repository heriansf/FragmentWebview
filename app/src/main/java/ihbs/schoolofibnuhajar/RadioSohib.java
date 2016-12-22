package ihbs.schoolofibnuhajar;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.io.IOException;

public class RadioSohib extends AppCompatActivity implements View.OnClickListener {

    private String url_radio = "http://live.radiorodja.com/";
    private ProgressBar progressBar;
    ImageView playRadio, stopRadio;
    MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sohibradio);
        deklarasiWidget();
        deklarasiMediaPlayer();

    }

    private void deklarasiWidget(){
        progressBar = (ProgressBar)findViewById(R.id.progressbarsohibradio);
        progressBar.setMax(100);
        progressBar.setVisibility(View.INVISIBLE);
        progressBar.setIndeterminate(true);
        playRadio = (ImageView)findViewById(R.id.imagesplayradio);
        playRadio.setOnClickListener(this);
        stopRadio = (ImageView)findViewById(R.id.imagesstopradio);
        stopRadio.setOnClickListener(this);
        stopRadio.setVisibility(View.INVISIBLE);


    }
    private void stopPlaying() throws IllegalStateException{
        try{
            if(mediaPlayer != null && mediaPlayer.isPlaying()){
                mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
                    @Override
                    public void onBufferingUpdate(MediaPlayer mp, int percent) {
                        mediaPlayer.stop();
                        mediaPlayer.release();
                        deklarasiMediaPlayer();
                    }
                });

            }
        }catch (IllegalStateException e){
        }

        playRadio.setVisibility(View.VISIBLE);
        stopRadio.setVisibility(View.VISIBLE);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(View.INVISIBLE);
    }
    private void deklarasiMediaPlayer(){
        mediaPlayer = new MediaPlayer();
        try{
            mediaPlayer.setDataSource(url_radio);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }catch (IllegalStateException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }

        mediaPlayer.setOnBufferingUpdateListener(new MediaPlayer.OnBufferingUpdateListener() {
            @Override
            public void onBufferingUpdate(MediaPlayer mp, int percent) {
                progressBar.setIndeterminate(false);
                progressBar.setSecondaryProgress(100);
                Log.i("Buffering", "" + percent);
            }
        });
    }

    @Override
    public void onClick(View v) {
        if (v==playRadio){
            startPlaying();
        }else if (v==stopRadio){
            stopPlaying();
        }

    }
    private void startPlaying(){
        playRadio.setVisibility(View.INVISIBLE);
        stopRadio.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.VISIBLE);
        mediaPlayer.prepareAsync();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mediaPlayer.start();
                mediaPlayer.setLooping(false);
                progressBar.setVisibility(View.GONE);
            }
        });
    }
}
