package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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


        // 1) Find the button in the layout
        goodbyeButton = findViewById(R.id.buttonGoodbye);
        goodbyeButton.setOnClickListener(this::goodbye);

        //Checkpoint 1 Lab 3
        View blowOutBtn = findViewById(R.id.buttonBlowOut);
        blowOutBtn.setOnClickListener(controller);
        }


        public void goodbye(View button) {

            Log.i("button", "Goodbye");
        }




    }

