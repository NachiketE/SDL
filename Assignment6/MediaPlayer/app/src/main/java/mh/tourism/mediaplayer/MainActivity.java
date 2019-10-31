package mh.tourism.mediaplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    Button play,stop,pause;
    TextView t1,t2;
    private  double finalTime=0;
    private double startTime=0;
    private double oneTimeOnly=0;
    SeekBar seekbar;
  MediaPlayer mplayer;
    private Handler myHandler=new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        play=(Button) findViewById(R.id.play);
        stop=(Button) findViewById(R.id.stop);
        pause=(Button)findViewById(R.id.pause);
        t1=(TextView) findViewById(R.id.text1);
        t2=(TextView) findViewById(R.id.text2);
         seekbar = (SeekBar)findViewById(R.id.seekBar);
        seekbar.setClickable(true);
         mplayer=MediaPlayer.create(this,R.raw.song);
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mplayer.start();
                finalTime = mplayer.getDuration();
                startTime = mplayer.getCurrentPosition();

                if (oneTimeOnly == 0) {
                    seekbar.setMax((int) finalTime);
                    oneTimeOnly = 1;
                }
                seekbar.setProgress((int)startTime);
               myHandler.postDelayed(UpdateSongTime,100);
                pause.setEnabled(true);
                play.setEnabled(false);

                t2.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) finalTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) finalTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                        finalTime)))
                );

                t1.setText(String.format("%d min, %d sec",
                        TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                        TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                                TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes((long)
                                        startTime)))
                );
                Toast.makeText(MainActivity.this,"Playing song",Toast.LENGTH_LONG).show();
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mplayer.pause();

                play.setEnabled(true);
                Toast.makeText(MainActivity.this,"Song pause",Toast.LENGTH_LONG).show();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mplayer.stop();
                play.setEnabled(true);
                Toast.makeText(MainActivity.this,"Playing stopped",Toast.LENGTH_LONG).show();
            }
        });
    }
    private Runnable UpdateSongTime = new Runnable() {
        public void run() {
            startTime = mplayer.getCurrentPosition();
            t1.setText(String.format("%d min, %d sec",
                    TimeUnit.MILLISECONDS.toMinutes((long) startTime),
                    TimeUnit.MILLISECONDS.toSeconds((long) startTime) -
                            TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.
                                    toMinutes((long) startTime)))
            );
            seekbar.setProgress((int)startTime);
            myHandler.postDelayed(this, 100);
        }
    };
}
