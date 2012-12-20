package com.klavaro.cftimepicker;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.SeekBar;

/**
 * TODO: document your custom view class.
 */
public class SeekCircleView extends SeekBar {
	private Paint basicPaint;
	private int value;
	private int min;
	private int max;
	private boolean showHand;

	public SeekCircleView(Context context) {
		super(context);
		init(null, 0);
	}

	public SeekCircleView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(attrs, 0);
	}

	public SeekCircleView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(attrs, defStyle);
	}

	private void init(AttributeSet attrs, int defStyle) {
		// Load attributes
		final TypedArray a = getContext().obtainStyledAttributes(attrs,
				R.styleable.SeekCircleView, defStyle, 0);
		
		// Handle attributes

		a.recycle();

		// Set up basic Paint
		basicPaint = new Paint();

		invalidateAppearance();
	}

	private void invalidateAppearance() {
		// update appearance from supposedly modified fields
	}

	@Override
	protected void onDraw(Canvas canvas) {
		super.onDraw(canvas);
		
		// TODO Can we use canvas.getClipBounds or similar?
		RectF rectf_full = new RectF(getPaddingLeft(), getPaddingTop(),
				getWidth()-getPaddingRight(), getHeight()-getPaddingBottom());
		canvas.drawArc(rectf_full, 0, theta(), false, basicPaint);
		if (showHand) {
			// TODO Figure out where to do these calculations. When could W&H be changed?
			float centerX = getWidth() / 2;
			float centerY = getHeight() / 2;
			float stopX = centerX * (1 + (float) Math.cos(Math.toRadians(90-theta())));
			float stopY = centerY * (1 + (float) Math.sin(Math.toRadians(90-theta())));
			canvas.drawLine(centerX, centerY, stopX, stopY, basicPaint);
		}
	}

	private float theta() {
		return (float) (value - min) / (float) (max - min) * 360;
	}
	
	public int getValue() {
		return value;
	}
	
	public void setValue(int newValue) {
		if (newValue < min || newValue > max)
			throw new IllegalArgumentException("Value must < range");
		value = newValue;
		invalidateAppearance();
	}
	
	public int getRangeMin() {
		return min;
	}
	
	public int getRangeMax() {
		return max;
	}
	
	public void setRange(int newMin, int newMax) {
		if (newMin >= newMax)
			throw new IllegalArgumentException("newMin must < newMax");
		min = newMin;
		max = newMax;
		if (value > max) value = max;
		else if (value < min) value = min;
	}
}
