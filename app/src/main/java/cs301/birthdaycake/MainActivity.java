package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.SeekBar;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {


    private Button goodbyeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        CakeView cakeView = findViewById(R.id.cakeview);

        // create controller
        CakeController controller = new CakeController(cakeView);

        // Find the button in the layout
        goodbyeButton = findViewById(R.id.buttonGoodbye);
        goodbyeButton.setOnClickListener(this::goodbye);


        //~~~ Checkpoint 1 Lab 3 ~~~
        View blowOutBtn = findViewById(R.id.buttonBlowOut);
        blowOutBtn.setOnClickListener(controller);


        //~~~ Checkpoint 3 Lab 3 ~~~
        CompoundButton switchCandles = findViewById(R.id.switchCandles);
        switchCandles.setOnCheckedChangeListener(controller);


        //~~~ Checkpoint 4 Lab 3 ~~~
        SeekBar candleSeekBar = findViewById(R.id.candleSeek);
        candleSeekBar.setOnSeekBarChangeListener(controller);
        }

        public void goodbye(View button) {

            Log.i("button", "Goodbye");
        }

    }

