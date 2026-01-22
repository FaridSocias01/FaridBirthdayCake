package cs301.birthdaycake;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;



public class MainActivity extends AppCompatActivity {


    private Button goodbyeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        setContentView(R.layout.activity_main);

        // 1) Find the button in the layout
        goodbyeButton = findViewById(R.id.buttonGoodbye);

        // 2) Register for click events (this is the "better" way)
        goodbyeButton.setOnClickListener(view -> {
            Log.i("button", "Goodbye");
        });
    }
}
