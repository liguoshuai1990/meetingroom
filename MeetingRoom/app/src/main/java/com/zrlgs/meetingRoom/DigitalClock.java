package com.zrlgs.meetingRoom;

import java.util.Calendar;
import android.content.Context;
import android.os.Handler;
import android.os.SystemClock;
import android.support.v7.widget.AppCompatTextView;
import android.text.format.DateFormat;
import android.util.AttributeSet;

public class DigitalClock extends AppCompatTextView {
	private Calendar mCalendar;
	private Runnable mTicker;
	private Handler mHandler;

	private boolean mTickerStopped = false;

	public DigitalClock(Context context) {
		super(context);
	}

	public DigitalClock(Context context, AttributeSet attrs) {
		super(context, attrs);
	}

	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();

		if (mCalendar == null) {
			mCalendar = Calendar.getInstance();
		}
		mTickerStopped = false;
		mHandler = new Handler();

		mTicker = new Runnable() {
			public void run() {
				if (mTickerStopped)
					return;
				mCalendar.setTimeInMillis(System.currentTimeMillis());
				setText(DateFormat.format("yyyy.M.d hh:mm:ss", mCalendar));
				invalidate();
				long now = SystemClock.uptimeMillis();
				long next = now + (1000 - System.currentTimeMillis() % 1000);
				mHandler.postAtTime(mTicker, next);
			}
		};
		mTicker.run();
	}

	@Override
	protected void onDetachedFromWindow() {
		super.onDetachedFromWindow();
		mTickerStopped = true;
	}

}