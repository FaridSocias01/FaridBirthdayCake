package cs301.birthdaycake;

import android.util.Log;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.SeekBar;

public class CakeController implements
        View.OnClickListener,
        CompoundButton.OnCheckedChangeListener,
        SeekBar.OnSeekBarChangeListener {

    private CakeView cakeView;
    private CakeModel cakeModel;

    public CakeController(CakeView cakeView) {
        this.cakeView = cakeView;
        this.cakeModel = cakeView.getCakeModel();
    }

    @Override
    public void onClick(View v) {
        Log.d("cake", "click!");
        // TODO more later (Checkpoint 2)
    }

    @Override
    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
        // TODO more later (Checkpoint 3)
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        // TODO more later (Checkpoint 4)
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        // TODO do-nothing (required by interface)
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        // TODO do-nothing (required by interface)
    }
}
