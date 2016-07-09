package com.example.els;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;

public class MyView extends View {
	private int[][] arr = new int[15][10];

	private int Y = 0;
	private int X = 0;

	private int T = 1;
	private int Z = 2;
	private int blockType = 0;

	private int TIME = 1000;

	private Bitmap rightBitmap = null;
	private Bitmap leftBitmap = null;

	private int score = 0;
	
	private int[] color1={0x94e6d4};

	public MyView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		// Load resources
		rightBitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_right);
		leftBitmap = BitmapFactory.decodeResource(getResources(),
				R.drawable.arrow_left);

		// Init array
		for (int y = 0; y < 15; y++) {
			for (int x = 0; x < 10; x++) {
				arr[y][x] = 1;
			}
		}

		// Init block
		createBlock();

		handler.postDelayed(runnable, TIME);
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint paint = new Paint();

		// draw grid background
		paint.setColor(Color.GRAY);
		paint.setStrokeWidth(2);
		for (int x = 1; x < 11; x++) {
			for (int y = 1; y < 16; y++) {
				canvas.drawLine(0, y * 52 - 1, 520, y * 52 - 1, paint);
			}

			canvas.drawLine(x * 52 - 1, 0, x * 52 - 1, 780, paint);
		}

		// draw block
		paint.setColor(Color.CYAN);
		for (int x = 0; x < 10; x++) {
			for (int y = 0; y < 15; y++) {
				if (arr[y][x] == 0) {
					canvas.drawRect(x * 52, y * 52, (x + 1) * 52 - 2,
							(y + 1) * 52 - 2, paint);
				}
			}
		}

		// draw button
		canvas.drawBitmap(rightBitmap, 470, 790, paint);
		canvas.drawBitmap(leftBitmap, 5, 790, paint);

		// draw status
		paint.setColor(Color.DKGRAY);
		paint.setTextSize(28);
		canvas.drawText("成绩：", 550, 50, paint);
		canvas.drawText(String.valueOf(score), 640, 50, paint);
	}

	Handler handler = new Handler();
	Runnable runnable = new Runnable() {

		@Override
		public void run() {
			// handler自带方法实现定时器
			try {
				handler.postDelayed(this, TIME);

				if (blockType == T) {
					if (Y < 13) {
						arr[Y][X] = 1;
						arr[Y + 1][X] = 1;
						arr[Y + 1][X - 1] = 1;
						arr[Y + 1][X + 1] = 1;
						Y = Y + 1;
						arr[Y][X] = 0;
						arr[Y + 1][X] = 0;
						arr[Y + 1][X - 1] = 0;
						arr[Y + 1][X + 1] = 0;

						if (Y == 13 || arr[Y + 2][X] == 0
								|| arr[Y + 2][X - 1] == 0
								|| arr[Y + 2][X + 1] == 0) {
							createBlock();
						}
					}
				} else if (blockType == Z) {
					arr[Y][X] = 1;
					arr[Y][X - 1] = 1;
					arr[Y + 1][X] = 1;
					arr[Y + 1][X + 1] = 1;
					Y = Y + 1;
					arr[Y][X] = 0;
					arr[Y][X - 1] = 0;
					arr[Y + 1][X] = 0;
					arr[Y + 1][X + 1] = 0;

					if (Y == 13 || arr[Y + 1][X - 1] == 0 || arr[Y + 2][X] == 0
							|| arr[Y + 2][X + 1] == 0) {
						createBlock();
					}
				}

				invalidate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("exception...");
			}
		}
	};

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		float x = event.getX();
		float y = event.getY();
		// right arrow
		if (x > 470 && x < 502 && y > 790 && y < 861) {
			if (blockType == T) {
				if (X < 8) {
					arr[Y][X] = 1;
					arr[Y + 1][X - 1] = 1;
					X = X + 1;
				}
			} else if (blockType == Z) {
				if (X < 8) {
					arr[Y][X] = 1;
					arr[Y][X - 1] = 1;
					X = X + 1;
				}
			}
		}
		// left arrow
		if (x > 5 && x < 37 && y > 790 && y < 861) {
			if (blockType == T) {
				if (X > 1) {
					arr[Y][X] = 1;
					arr[Y + 1][X + 1] = 1;
					X = X - 1;
				}
			} else if (blockType == Z) {
				if (X > 1) {
					arr[Y][X] = 1;
					arr[Y + 1][X + 1] = 1;
					X = X - 1;
				}
			}
		}

		return super.onTouchEvent(event);
	}

	public void createBlock() {
		Y = 0;
		blockType = (int) Math.ceil(Math.random() * 2);
		if (blockType == T) {
			// T
			X = (int) Math.ceil(Math.random() * 8);

			arr[Y][X] = 0;
			arr[Y + 1][X] = 0;
			arr[Y + 1][X - 1] = 0;
			arr[Y + 1][X + 1] = 0;
		} else if (blockType == Z) {
			// Z
			X = (int) Math.ceil(Math.random() * 8);

			arr[Y][X] = 0;
			arr[Y][X - 1] = 0;
			arr[Y + 1][X] = 0;
			arr[Y + 1][X + 1] = 0;
		}
	}
}
