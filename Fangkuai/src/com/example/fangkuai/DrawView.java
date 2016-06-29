package com.example.fangkuai;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Handler;
import android.view.View;

public class DrawView extends View {
	// moving interval time
	private int TIME = 500;
	// rect upleft conner coodinate
	private float float_x = 0;
	private float float_y = 0;
	// rect move distance horizontally and vertically
	private float stepXf = 0;
	private float stepYf = 0;
	// rect count horizontally and vertically
	private int intCountX = 5;
	private int intCountY = 9;
	// window width and height
	private float widthf = 0;
	private float heightf = 0;
	// totol moved grid num
	private int totalNum = 1;

	// moving direction
	private int DIRRIGHT = 0;
	private int DIRDOWN = 1;
	private int DIRLEFT = 2;
	private int DIRUP = 3;

	private int currentDir = 0;

	public DrawView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		handler.postDelayed(runnable, TIME);
	}

	@SuppressLint("DrawAllocation")
	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);

		Paint paint = new Paint();
		paint.setColor(Color.YELLOW);

		widthf = canvas.getWidth();
		heightf = canvas.getHeight();

		stepXf = widthf / intCountX;
		stepYf = heightf / intCountY;
        
		// draw grid background
		for (int i = 0; i < (intCountY + 1); i++) {
			canvas.drawLine(0, stepYf * i, widthf, stepYf * i, paint);
		}

		for (int i = 0; i < (intCountX + 1); i++) {
			canvas.drawLine(stepXf * i, 0, stepXf * i, heightf, paint);
		}
		
		// draw square
		paint.setColor(Color.RED);

		canvas.drawRect(float_x, float_y, float_x + stepXf, float_y + stepYf,
				paint);

		onDirection();
	}

	Handler handler = new Handler();
	Runnable runnable = new Runnable() {

		@Override
		public void run() {
			// handler自带方法实现定时器
			try {
				handler.postDelayed(this, TIME);
				if (currentDir == DIRRIGHT) {
					float_x += stepXf;
					totalNum++;
				} else if (currentDir == DIRDOWN) {
					float_y += stepYf;
					totalNum++;
				} else if (currentDir == DIRLEFT) {
					float_x -= stepXf;
					totalNum++;
				} else if (currentDir == DIRUP) {
					float_y -= stepYf;
					totalNum++;
				}

				invalidate();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("exception...");
			}
		}
	};

	protected void onDirection() {
		if (totalNum == 24 || totalNum == 40) {
			currentDir = DIRRIGHT;
		} else if (totalNum == 5 || totalNum == 27 || totalNum == 41) {
			currentDir = DIRDOWN;
		} else if (totalNum == 13 || totalNum == 33) {
			currentDir = DIRLEFT;
		} else if (totalNum == 17 || totalNum == 35) {
			currentDir = DIRUP;
		} else if (totalNum == 45) {
			currentDir = 4;
		}
	}

}
