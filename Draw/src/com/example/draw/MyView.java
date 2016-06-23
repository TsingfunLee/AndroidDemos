package com.example.draw;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.View;

public class MyView extends View {

	public MyView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onDraw(Canvas canvas) {
		// TODO Auto-generated method stub
		super.onDraw(canvas);
		Paint paint = new Paint();
		int windowWidth = canvas.getWidth();
		int windowHeight = canvas.getHeight();

		// TaiChi
		paint.setColor(Color.BLACK);
		float radius = windowWidth / 2 * 0.8f;
		canvas.drawCircle(windowWidth / 2, windowHeight / 4, radius, paint);

		RectF oval = new RectF();
		oval.top = windowHeight / 4 - radius;
		oval.bottom = oval.top + radius * 2;
		oval.left = windowWidth / 2 - radius;
		oval.right = windowWidth / 2 + radius;
		paint.setColor(Color.WHITE);
		canvas.drawArc(oval, 0, -180, true, paint);

		paint.setColor(Color.BLACK);
		canvas.drawCircle(windowWidth / 2 - radius / 2, windowHeight / 4,
				radius / 2, paint);

		paint.setColor(Color.WHITE);
		canvas.drawCircle(windowWidth / 2 + radius / 2, windowHeight / 4,
				radius / 2, paint);

		canvas.drawCircle(windowWidth / 2 - radius / 2, windowHeight / 4,
				radius / 4, paint);

		paint.setColor(Color.BLACK);
		canvas.drawCircle(windowWidth / 2 + radius / 2, windowHeight / 4,
				radius / 4, paint);

		// Unicom
		paint.setColor(Color.RED);
		paint.setStyle(Paint.Style.STROKE);
		paint.setStrokeWidth(3);
		float centerX = windowWidth / 2;
		float centerY = windowHeight / 2 + windowHeight / 4;
		float cellWidth = (float) (radius / 2.5);
		float lineLength = 3 * cellWidth;
		float offset = (float) (cellWidth * 1.5 / Math.sqrt(2));
		float startX = centerX - offset;
		float startY = centerY + offset;
		float offsetL = lineLength / (float) Math.sqrt(2); // 画直线时x、y的偏移量

		canvas.drawLine(startX, startY, startX + offsetL, startY - offsetL,
				paint);
		// arc
		offset = cellWidth / 2 / (float) Math.sqrt(2);
		RectF oval1 = new RectF();
		oval1.top = startY - offsetL - offset - cellWidth / 2;
		oval1.bottom = oval1.top + cellWidth;
		oval1.left = startX + offsetL - offset - cellWidth / 2;
		oval1.right = oval1.left + cellWidth;
		canvas.drawArc(oval1, 45, -180, false, paint);

		RectF oval2 = new RectF();
		oval2.top = startY + offset - cellWidth / 2;
		oval2.bottom = oval2.top + cellWidth;
		oval2.left = startX + offset - cellWidth / 2;
		oval2.right = oval2.left + cellWidth;
		canvas.drawArc(oval2, 45, 180, false, paint);
		// arc

		offset = (float) (cellWidth / Math.sqrt(2));

		float endX = startX - offset + offsetL;
		float endY = startY - offset - offsetL;
		canvas.drawLine(startX - offset, startY - offset, endX, endY, paint);

		endX = startX + offset + offsetL;
		endY = startY + offset - offsetL;
		canvas.drawLine(startX + offset, startY + offset, endX, endY, paint);

		// arc
		offset = (float) (cellWidth * 0.5 / Math.sqrt(2));
		RectF oval5 = new RectF();
		oval5.top = endY + offset - cellWidth / 2;
		oval5.bottom = oval5.top + cellWidth;
		oval5.left = endX + offset - cellWidth / 2;
		oval5.right = oval5.left + cellWidth;
		canvas.drawArc(oval5, -135, 270, false, paint);
		// arc

		//
		offset = (float) (cellWidth * 1.5 / Math.sqrt(2));
		startX = centerX + offset;
		startY = centerY + offset;

		canvas.drawLine(startX, startY, startX - offsetL, startY - offsetL,
				paint);

		// arc
		offset = cellWidth / 2 / (float) Math.sqrt(2);
		RectF oval3 = new RectF();
		oval3.top = startY - offsetL - offset - cellWidth / 2;
		oval3.bottom = oval3.top + cellWidth;
		oval3.left = startX - offsetL + offset - cellWidth / 2;
		oval3.right = oval3.left + cellWidth;
		canvas.drawArc(oval3, -45, -180, false, paint);

		RectF oval4 = new RectF();
		oval4.top = startY + offset - cellWidth / 2;
		oval4.bottom = oval4.top + cellWidth;
		oval4.left = startX - offset - cellWidth / 2;
		oval4.right = oval4.left + cellWidth;
		canvas.drawArc(oval4, -45, 180, false, paint);
		// arc

		offset = (float) (cellWidth / Math.sqrt(2));
		endX = startX + offset - offsetL;
		endY = startY - offset - offsetL;

		canvas.drawLine(startX + offset, startY - offset, endX, endY, paint);

		endX = startX - offset - offsetL;
		endY = startY + offset - offsetL;
		canvas.drawLine(startX - offset, startY + offset, endX, endY, paint);

		// arc
		offset = (float) (cellWidth * 0.5 / Math.sqrt(2));
		RectF oval6 = new RectF();
		oval6.top = endY + offset - cellWidth / 2;
		oval6.bottom = oval6.top + cellWidth;
		oval6.left = endX - offset - cellWidth / 2;
		oval6.right = oval6.left + cellWidth;
		canvas.drawArc(oval6, -45, -270, false, paint);
	}
}
