package com.mfb.frennpaylibrary.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.text.Editable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ActionMode;

import androidx.appcompat.widget.AppCompatEditText;

import com.mfb.frennpaylibrary.R;

public class OtpEditText extends AppCompatEditText {
    private float mSpace = 24; //24 dp by default, space between the lines
    private float mNumChars = 4;
    private float mLineSpacing = 8; //8dp by default, height of the text from our lines
    private int mMaxLength = 4;
    private float mLineStroke = 2;
    private Paint mLinesPaint;
    private OnClickListener mClickListener;

    public OtpEditText(Context context) {
        super(context);
    }

    public OtpEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public OtpEditText(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        float multi = context.getResources().getDisplayMetrics().density;
        mLineStroke = multi * mLineStroke;
        mLinesPaint = new Paint(getPaint());
        mLinesPaint.setStrokeWidth(mLineStroke);
        mLinesPaint.setColor(getResources().getColor(R.color.white));
        setBackgroundResource(0);
        mSpace = multi * mSpace; //convert to pixels for our density
        mLineSpacing = multi * mLineSpacing; //convert to pixels for our density
        mNumChars = mMaxLength;

        super.setOnClickListener(v -> {
            setSelection(getText().length());
            if (mClickListener != null) {
                mClickListener.onClick(v);
            }
        });
    }

    @Override
    public void setOnClickListener(OnClickListener l) {
        mClickListener = l;
    }

    @Override
    public void setCustomSelectionActionModeCallback(ActionMode.Callback actionModeCallback) {
        throw new RuntimeException("setCustomSelectionActionModeCallback() not supported.");
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int availableWidth = getWidth() - getPaddingRight() - getPaddingLeft();
        float mCharSize;
        if (mSpace < 0) {
            mCharSize = (availableWidth / (mNumChars * 2 - 1));
        } else {
            mCharSize = (availableWidth - (mSpace * (mNumChars - 1))) / mNumChars;
        }

        int startX = getPaddingLeft();
        int bottom = getHeight() - getPaddingBottom();

        //Text Width
        Editable text = getText();
        int textLength = text.length();
        float[] textWidths = new float[textLength];
        getPaint().getTextWidths(getText(), 0, textLength, textWidths);
        mLinesPaint.setStyle(Paint.Style.FILL);
        mLinesPaint.setColor(Color.WHITE);
        for (int i = 0; i < mNumChars; i++) {
            float left = startX;
            float top = getPaddingTop();
            float right = startX + mCharSize;
            float btm = getHeight() - getPaddingBottom();

            canvas.drawRect(left, top, right, btm, mLinesPaint);
//            canvas.drawLine(startX, bottom, startX + mCharSize, bottom, mLinesPaint);
            if (getText().length() > i) {
                float middle = startX + mCharSize / 2;
                float y = getPaddingTop() + btm / 2;
                Log.d("Paint", "y: " + y);
                canvas.drawText(text, i, i + 1, middle - textWidths[0] / 2, y, getPaint());
            }
            if (mSpace < 0) {
                startX += mCharSize * 2;
            } else {
                startX += mCharSize + mSpace;
            }
        }
    }
}