package cs301.birthdaycake;
import android.util.Log;
import android.view.View;

public class CakeController implements View.OnClickListener {
    private CakeView cakeView;
    private CakeModel cakeModel;

    public CakeController(CakeView cakeView) {
        this.cakeView = cakeView;
        this.cakeModel = cakeView.getCakeModel();
    }

//Checkpoint 2 Lab 3
    @Override
    public void onClick(View v) {
        Log.d("cake", "click!");

        if (v.getId()==R.id.buttonBlowOut) {
            cakeModel.candlesLit = false;
            cakeView.invalidate();
        }
    }
}