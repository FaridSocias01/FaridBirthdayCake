package cs301.birthdaycake;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class CakeView extends SurfaceView {

    /* These are the paints we'll use to draw the birthday cake below */
    Paint cakePaint = new Paint();
    Paint frostingPaint = new Paint();
    Paint candlePaint = new Paint();
    Paint outerFlamePaint = new Paint();
    Paint innerFlamePaint = new Paint();
    Paint wickPaint = new Paint();

    //Checkpoint 1 Lab 3
    private CakeModel model;


    /* These constants define the dimensions of the cake.  While defining constants for things
        like this is good practice, we could be calculating these better by detecting
        and adapting to different tablets' screen sizes and resolutions.  I've deliberately
        stuck with hard-coded values here to ease the introduction for CS371 students.
     */
    public static final float cakeTop = 400.0f;
    public static final float cakeLeft = 100.0f;
    public static final float cakeWidth = 1200.0f;
    public static final float layerHeight = 200.0f;
    public static final float frostHeight = 50.0f;
    public static final float candleHeight = 300.0f;
    public static final float candleWidth = 40.0f;
    public static final float wickHeight = 30.0f;
    public static final float wickWidth = 6.0f;
    public static final float outerFlameRadius = 30.0f;
    public static final float innerFlameRadius = 15.0f;



    /**
     * ctor must be overridden here as per standard Java inheritance practice.  We need it
     * anyway to initialize the member variables
     */
    public CakeView(Context context, AttributeSet attrs) {
        super(context, attrs);

        //~~~ Checkpoint 1 Lab 3 ~~~

        model = new CakeModel();

        //This is essential or your onDraw method won't get called
        setWillNotDraw(false);

        //Setup our palette
        cakePaint.setColor(0xFFC755B5);  //violet-red
        cakePaint.setStyle(Paint.Style.FILL);
        frostingPaint.setColor(0xFFFFFACD);  //pale yellow
        frostingPaint.setStyle(Paint.Style.FILL);
        candlePaint.setColor(0xFF32CD32);  //lime green
        candlePaint.setStyle(Paint.Style.FILL);
        outerFlamePaint.setColor(0xFFFFD700);  //gold yellow
        outerFlamePaint.setStyle(Paint.Style.FILL);
        innerFlamePaint.setColor(0xFFFFA500);  //orange
        innerFlamePaint.setStyle(Paint.Style.FILL);
        wickPaint.setColor(Color.BLACK);
        wickPaint.setStyle(Paint.Style.FILL);

        setBackgroundColor(Color.WHITE);  //better than black default
    }

    public CakeModel getCakeModel() {
        return model;
    }

    /**
     * draws a candle at a specified position.  Important:  the left, bottom coordinates specify
     * the position of the bottom left corner of the candle
     */


    public void drawCandle(Canvas canvas, float left, float bottom) {

        //~~~ Checkpoint 3 Lab 3 ~~~
        // If the model says candles are off then it stops this method

        if (!model.hasCandles) return;

        canvas.drawRect(left, bottom - candleHeight, left + candleWidth, bottom, candlePaint);

        //New : draw the wick (before anything so it stays when the flames are blow)
        float wickLeft = left + candleWidth / 2 - wickWidth / 2;
        float wickTop = bottom - wickHeight - candleHeight;
        canvas.drawRect(wickLeft, wickTop, wickLeft + wickWidth, wickTop + wickHeight, wickPaint);

        if (model.candlesLit) {
            float flameCenterX = left + candleWidth/2;
            float flameCenterY = bottom - wickHeight - candleHeight - outerFlameRadius/3;
            canvas.drawCircle(flameCenterX, flameCenterY, outerFlameRadius, outerFlamePaint);

            flameCenterY += outerFlameRadius/3;
            canvas.drawCircle(flameCenterX, flameCenterY, innerFlameRadius, innerFlamePaint);
        }

        /* This code was for lab 2 but had to change it a bit
        //draw the outer flame
        float flameCenterX = left + candleWidth / 2;
        float flameCenterY = bottom - wickHeight - candleHeight - outerFlameRadius / 3;
        canvas.drawCircle(flameCenterX, flameCenterY, outerFlameRadius, outerFlamePaint);

        //draw the inner flame
        flameCenterY += outerFlameRadius / 3;
        canvas.drawCircle(flameCenterX, flameCenterY, innerFlameRadius, innerFlamePaint);
         */
    }

    /**
     * onDraw is like "paint" in a regular Java program.  While a Canvas is
     * conceptually similar to a Graphics in javax.swing, the implementation has
     * many subtle differences.  Show care and read the documentation.
     *
     * This method will draw a birthday cake
     */
    @Override
    public void onDraw(Canvas canvas)
    {
        //top and bottom are used to keep a running tally as we progress down the cake layers
        float top = cakeTop;
        float bottom = cakeTop + frostHeight;

        //Frosting on top
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, frostingPaint);
        top += frostHeight;
        bottom += layerHeight;

        //Then a cake layer
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, cakePaint);
        top += layerHeight;
        bottom += frostHeight;

        //Then a second frosting layer
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, frostingPaint);
        top += frostHeight;
        bottom += layerHeight;

        //Then a second cake layer
        canvas.drawRect(cakeLeft, top, cakeLeft + cakeWidth, bottom, cakePaint);


        //~~~ Checkpoint 4 Lab 3 ~~~


        // Draw candles based on model.numCandles
        int c = model.numCandles;

        // Keep candles fully on cake: use inner boundaries that account for candle width
        float cakeLeftFloat = cakeLeft;
        float cakeRightFloat = cakeLeft + cakeWidth;

        // Those two are inside the cake only making limits so the candles are not in the edge or going out of the cake
        float insideCakeLeftFloat = cakeLeftFloat;
        float insideCakeRightFloat = cakeRightFloat - candleWidth;

        // Gives the width of the good zone where candle left edges can go
        float insideCakeWidthFloat = insideCakeRightFloat - insideCakeLeftFloat;

        // Place candles at fractions i/(n+1) across insideCakeWidthFloat
        for (int i = 1; i <= c; i++) {
            //this is important because this will create the spaces between candles and will look like gaps
            // c + 1 because will make an extra gap and make it never in the edge of the cake
            float x = insideCakeLeftFloat + (i * insideCakeWidthFloat) / (c + 1);
            drawCandle(canvas, x, cakeTop);
        }

/*
        //Now two candles in the cake ---> I don't need this anymore because I will change the candles number with seekbar

        drawCandle(canvas, cakeLeft + cakeWidth/2 - candleWidth/2, cakeTop);
        drawCandle(canvas, cakeLeft + cakeWidth/3 - candleWidth/2, cakeTop);
*/
    }//onDraw


}//class CakeView

