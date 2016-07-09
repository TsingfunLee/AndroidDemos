package com.example.wzq;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class MyView extends View {

	private int arr[][] = new int[9][9];
	private int arrHistory[][] = new int[5][5];
	private int historyNum = 0;

	// Number of chess per line
	private int NUM = 9;
	private int GRIDWIDTH = 70;
	private boolean isBlack = true;

	private String win_loss = "";

	public MyView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		for (int y = 0; y < NUM; y++) {
			for (int x = 0; x < NUM; x++) {
				arr[y][x] = 0;
			}
		}
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint p = new Paint();

		float screenWidth = canvas.getWidth();
		GRIDWIDTH = (int) (screenWidth / (NUM + 1));

		// draw chessboard
		p.setColor(Color.BLACK);
		for (int i = 0; i < NUM; i++) {
			canvas.drawLine(GRIDWIDTH, GRIDWIDTH + GRIDWIDTH * i, GRIDWIDTH
					* NUM, GRIDWIDTH + GRIDWIDTH * i, p);
			canvas.drawLine(GRIDWIDTH + GRIDWIDTH * i, GRIDWIDTH, GRIDWIDTH
					+ GRIDWIDTH * i, GRIDWIDTH * NUM, p);
		}

		// -----draw chess--------//
		// get bitmap
		Bitmap bitmapHei = BitmapFactory.decodeResource(getResources(),
				R.drawable.hei);
		Bitmap bitmapBai = BitmapFactory.decodeResource(getResources(),
				R.drawable.bai);
		// set scale matrix
		Matrix matrix = new Matrix();
		float bitmapWidth = bitmapHei.getWidth();
		float bitmapHeight = bitmapHei.getHeight();
		if (bitmapWidth > GRIDWIDTH) {
			matrix.postScale(GRIDWIDTH / bitmapWidth, GRIDWIDTH / bitmapHeight);
		} else if (bitmapWidth <= GRIDWIDTH) {
			matrix.postScale(bitmapWidth / GRIDWIDTH, bitmapHeight / GRIDWIDTH);
		}
		// set bitmap size fitting chessboard
		Bitmap bitmapHeiResize = Bitmap.createBitmap(bitmapHei, 0, 0,
				bitmapHei.getWidth(), bitmapHei.getHeight(), matrix, true);
		Bitmap bitmapBaiResize = Bitmap.createBitmap(bitmapBai, 0, 0,
				bitmapBai.getWidth(), bitmapBai.getHeight(), matrix, true);

		// draw chess
		for (int y = 0; y < NUM; y++) {
			for (int x = 0; x < NUM; x++) {
				if (arr[y][x] == 1) { // Black
					canvas.drawBitmap(bitmapHeiResize, GRIDWIDTH + GRIDWIDTH
							* x - GRIDWIDTH / 2, GRIDWIDTH + GRIDWIDTH * y
							- GRIDWIDTH / 2, p);
				} else if (arr[y][x] == 2) { // White
					canvas.drawBitmap(bitmapBaiResize, GRIDWIDTH + GRIDWIDTH
							* x - GRIDWIDTH / 2, GRIDWIDTH + GRIDWIDTH * y
							- GRIDWIDTH / 2, p);
				}
			}
		}

		// -----draw game state------//
		p.setTextSize(30);
		if (isBlack) {
			canvas.drawText("黑棋", GRIDWIDTH, GRIDWIDTH * (NUM + 1), p);
		} else {
			canvas.drawText("白棋", GRIDWIDTH, GRIDWIDTH * (NUM + 1), p);
		}

		p.setTextSize(44);
		p.setColor(Color.RED);
		canvas.drawText(win_loss, 4 * GRIDWIDTH, GRIDWIDTH * (NUM + 2), p);

		p.setColor(Color.GRAY);
		canvas.drawRect((float) (3.5 * GRIDWIDTH), GRIDWIDTH * (NUM + 4),
				(float) (6.5 * GRIDWIDTH), (float) (GRIDWIDTH * (NUM + 5.5)), p);

		p.setTextSize(40);
		p.setColor(Color.BLACK);
		canvas.drawText("重新开始", 4 * GRIDWIDTH, GRIDWIDTH * (NUM + 5), p);

		p.setColor(Color.GRAY);
		canvas.drawRect((float) (3.5 * GRIDWIDTH),
				(float) (GRIDWIDTH * (NUM + 6.5)), (float) (6.5 * GRIDWIDTH),
				(float) (GRIDWIDTH * (NUM + 8)), p);

		p.setTextSize(40);
		p.setColor(Color.BLACK);
		canvas.drawText("悔棋", (float) (4.5 * GRIDWIDTH),
				(float) (GRIDWIDTH * (NUM + 7.5)), p);
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		// TODO Auto-generated method stub
		int x = (int) event.getX();
		int y = (int) event.getY();
		int xNum = x / GRIDWIDTH - 1;
		int yNum = y / GRIDWIDTH - 1;
		int xRemainder = x % GRIDWIDTH;
		int yRemainder = y % GRIDWIDTH;
		if (xRemainder > GRIDWIDTH / 2) {
			xNum++;
		}
		if (yRemainder > GRIDWIDTH / 2) {
			yNum++;
		}

		if (xNum < NUM && yNum < NUM) {
			if (arr[yNum][xNum] == 0) {
				if (isBlack) {
					arr[yNum][xNum] = 1;
					isBlack = false;
				} else {
					arr[yNum][xNum] = 2;
					isBlack = true;
				}

				arrHistory[historyNum][0] = yNum;
				arrHistory[1][historyNum] = xNum;
				if (historyNum < 5) {
					historyNum++;
				}
				if (historyNum == 5) {
					for (int i = 0; i < 4; i++) {
						arrHistory[i][0] = arrHistory[i + 1][0];
						arrHistory[1][i] = arrHistory[1][i + 1];
						System.out.println(arrHistory[i][0]);
					}
					historyNum = 4;
				}
			}
		}

		// restart button
		if (event.getX() > 3.5 * GRIDWIDTH
				&& event.getY() > GRIDWIDTH * (NUM + 4)
				&& event.getX() < 6.5 * GRIDWIDTH
				&& event.getY() < GRIDWIDTH * (NUM + 5.5)) {
			for (int i = 0; i < NUM; i++) {
				for (int j = 0; j < NUM; j++) {
					arr[i][j] = 0;
				}
				win_loss="";
			}
		}

		// Undo
		if (event.getX() > 3.5 * GRIDWIDTH
				&& event.getY() > GRIDWIDTH * (NUM + 6.5)
				&& event.getX() < 6.5 * GRIDWIDTH
				&& event.getY() < GRIDWIDTH * (NUM + 8)) {
			if (historyNum > 0) {
				// historyNum--;
				yNum = arrHistory[historyNum][0];
				xNum = arrHistory[1][historyNum];
				arr[yNum][xNum] = 0;
				arrHistory[historyNum][0] = -1;
				arrHistory[1][historyNum] = -1;
				System.out.println(historyNum + "," + yNum);
				historyNum--;
			}
		}

		invalidate();

		isWin();

		return super.onTouchEvent(event);
	}

	public void isWin() {

		int color = 0;
		// 轮到黑棋下的时候检查白棋有没有连珠，轮到白棋下的时候检查黑棋有没有连珠
		if (isBlack) {
			color = 2;
		} else {
			color = 1;
		}

		for (int y = 0; y < NUM; y++) {
			for (int x = 0; x < NUM; x++) {
				// horizontal
				if ((x + 4) < NUM && arr[y][x] == color
						&& arr[y][x + 1] == color && arr[y][x + 2] == color
						&& arr[y][x + 3] == color && arr[y][x + 4] == color) {
					win_loss = "你赢了！";
					return;
				}
				// vertical
				if ((y + 4) < NUM && arr[y][x] == color
						&& arr[y + 1][x] == color && arr[y + 2][x] == color
						&& arr[y + 3][x] == color && arr[y + 4][x] == color) {
					win_loss = "你赢了！";
					return;
				}
				// diagonal \\\\\
				if ((y + 4) < NUM && (x + 4) < NUM && arr[y][x] == color
						&& arr[y + 1][x + 1] == color
						&& arr[y + 2][x + 2] == color
						&& arr[y + 3][x + 3] == color
						&& arr[y + 4][x + 4] == color) {
					win_loss = "你赢了！";
					return;
				}
				// diagonal /////
				if ((y + 4) < NUM && (x - 4) > -1 && arr[y][x] == color
						&& arr[y + 1][x - 1] == color
						&& arr[y + 2][x - 2] == color
						&& arr[y + 3][x - 3] == color
						&& arr[y + 4][x - 4] == color) {
					win_loss = "你赢了！";
					return;
				}
			}
		}

		// // horizontal
		// for (int y = 0; y < NUM; y++) {
		// renjuNum = 0;
		// for (int x = 0; x < NUM; x++) {
		// if (arr[y][x] == color) {
		// renjuNum++;
		// } else {
		// renjuNum = 0;
		// }
		// if (renjuNum == 5) {
		// System.out.println("Win");
		// win_loss = "你赢了！";
		// return;
		// }
		// }
		// }
		//
		// // vertical
		// for (int x = 0; x < NUM; x++) {
		// renjuNum = 0;
		// for (int y = 0; y < NUM; y++) {
		// if (arr[y][x] == color) {
		// renjuNum++;
		// } else {
		// renjuNum = 0;
		// }
		// if (renjuNum == 5) {
		// System.out.println("Win");
		// win_loss = "你赢了！";
		// return;
		// }
		// }
		// }
	}
}
