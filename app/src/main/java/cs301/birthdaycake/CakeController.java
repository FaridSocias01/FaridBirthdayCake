package cs301.birthdaycake;
import android.graphics.ColorSpace;
import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements View.OnClickListener,CompoundButton.OnCheckedChangeListener, SeekBar.OnSeekBarChangeListener {
    //~~~ Checkpoint 1 Lab 3 ~~~
    // Just labels to use around and the controller itself
    private CakeView cakeView;
    private CakeModel cakeModel;

    public CakeController(CakeView cakeView) {
        this.cakeView = cakeView;
        this.cakeModel = cakeView.getCakeModel();
    }

    //~~~ Checkpoint 2 Lab 3 ~~~
    // Added for the botton: event handler

    public void onClick(View view) {
        Log.d("cake", "click!");

        if (view.getId()==R.id.buttonBlowOut) {
            cakeModel.candlesLit = false;
            cakeView.invalidate();
        }
    }

    //~~~ Checkpoint 3 Lab 3 ~~~
    // Added for Candles switch: event handler
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        if (buttonView.getId() == R.id.switchCandles) {
            cakeModel.hasCandles = isChecked;
            cakeView.invalidate();
        }
    }

    //~~~ Checkpoint 4 Lab 3 ~~~
    // Added for the seekbar: event handler | Now I will just make sure that changes the number of candles by using the progress

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
        if (seekBar.getId() == R.id.candleSeek){
            cakeModel.numCandles = progress;
            cakeView.invalidate();}
    }
    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {/*don't need anything*/}
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {/*don't need anything*/}
}