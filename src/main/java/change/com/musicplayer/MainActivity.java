package change.com.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button play,pause,stop;
    MediaPlayer mediaPlayer;
    int pauseContentPosition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play = findViewById(R.id.btn_play);
        pause = findViewById(R.id.btn_pause);
        stop = findViewById(R.id.btn_stop);

        play.setOnClickListener(this);
        pause.setOnClickListener(this);
        stop.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn_play:
                if(mediaPlayer == null) {
                    mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.music);
                    mediaPlayer.start();
                }
                else if(!mediaPlayer.isPlaying())
                {
                    mediaPlayer.seekTo(pauseContentPosition);
                    mediaPlayer.start();
                }
                break;

            case R.id.btn_pause:
                if(mediaPlayer != null){
                    mediaPlayer.pause();
                    pauseContentPosition = mediaPlayer.getCurrentPosition();
                }
                break;

            case R.id.btn_stop:
                if(mediaPlayer != null){
                    mediaPlayer.stop();
                    mediaPlayer = null;
                }
                break;

        }
    }
}
