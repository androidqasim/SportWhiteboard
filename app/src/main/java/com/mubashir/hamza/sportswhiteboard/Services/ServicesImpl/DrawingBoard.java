package com.mubashir.hamza.sportswhiteboard.Services.ServicesImpl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.view.MotionEvent;
import android.view.View;

public class DrawingBoard extends View {

    Context _context;
    private Paint _paint;
    private int _width;
    private int _height;
    private Bitmap _bitmap;
    private Canvas _canvas;
    private Path _path;
    private Paint _paintBitmap;

    public DrawingBoard(Context context, int colorId) {
        super(context);
        this._context = context;
        _path = new Path();
        _paintBitmap = new Paint(Paint.DITHER_FLAG);

        _paint = new Paint();
        _paint.setAntiAlias(true);
        _paint.setDither(true);
        _paint.setStyle(Paint.Style.STROKE);
        _paint.setStrokeJoin(Paint.Join.ROUND);
        _paint.setStrokeCap(Paint.Cap.ROUND);

        setEraseColor(false);
        setPaintColor(colorId);
    }

    public void setPaintColor(int colorId) {
        _paint.setColor(colorId);
    }

    public void setEraseColor(boolean value) {
        if (value) {
            _paint.setStrokeWidth(15);
            _paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.CLEAR));
        }
        else {
            _paint.setStrokeWidth(7);
            _paint.setXfermode(null);
        }
    }

    public void setResetWindow() {
        //_canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.CLEAR);
        _canvas.drawColor(Color.TRANSPARENT, PorterDuff.Mode.MULTIPLY);
        invalidate();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h,oldw, oldh);

        _bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        _canvas = new Canvas(_bitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(_bitmap, 0, 0, _paintBitmap);
        canvas.drawPath(_path, _paint);
    }

    private float mX, mY;
    private static final float TOUCH_TOLERANCE = 1;

    private void touch_start(float x, float y) {
        _path.reset();
        _path.moveTo(x, y);
        mX = x;
        mY = y;
    }

    private void touch_move(float x, float y) {
        float dx = Math.abs(x - mX);
        float dy = Math.abs(y - mY);

        if (dx >= TOUCH_TOLERANCE || dy >= TOUCH_TOLERANCE) {
            _path.quadTo(mX, mY, (x + mX)/2, (y + mY)/2);

            _path.lineTo(mX, mY);
            // commit the path to our offscreen
            _canvas.drawPath(_path, _paint);
            _path.reset();
            _path.moveTo(mX, mY);

            mX = x;
            mY = y;
        }
    }

    private void touch_up() {
        _path.reset();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x = event.getX();
        float y = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN :
                touch_start(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_MOVE :
                touch_move(x, y);
                invalidate();
                break;
            case MotionEvent.ACTION_UP :
                touch_up();
                invalidate();
                break;
        }
        return true;
    }
}
