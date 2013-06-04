package com.linving.bitmap;

import android.os.Bundle;
import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.view.Menu;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private ImageView img;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		img = (ImageView) this.findViewById(R.id.img);
		Resources res = getResources();
		Drawable drawable = res.getDrawable(R.drawable.ic_launcher);
		Bitmap bitmap = drawableToBitmap(drawable);
		// img.setImageBitmap(bitmap);
		BitmapDrawable bd = new BitmapDrawable(res, bitmap);
		img.setImageDrawable(bd);
	}

	public static Bitmap drawableToBitmap(Drawable drawable) {
		// ȡ drawable �ĳ���
		int w = drawable.getIntrinsicWidth();
		int h = drawable.getIntrinsicHeight();

		// ȡ drawable ����ɫ��ʽ
		Bitmap.Config config = drawable.getOpacity() != PixelFormat.OPAQUE ? Bitmap.Config.ARGB_8888
				: Bitmap.Config.RGB_565;
		// ������Ӧ bitmap
		Bitmap bitmap = Bitmap.createBitmap(w, h, config);
		// ������Ӧ bitmap �Ļ���
		Paint paint = new Paint();
		paint.setColor(Color.BLACK);
		paint.setTextSize(25);
		Canvas canvas = new Canvas(bitmap);
		canvas.drawText("���", 10, 10, paint);
		drawable.setBounds(0, 0, w, h);
		// �� drawable ���ݻ���������
		drawable.draw(canvas);

		return bitmap;
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);

		return true;
	}

}
