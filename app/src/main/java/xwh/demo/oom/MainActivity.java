package xwh.demo.oom;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.format.Formatter;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

	private TextView mTextView;
	private int count = 0;
	private List<byte[]> mList;
	private List<Bitmap> mBitmaps;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		mTextView = this.findViewById(R.id.text);
		mList = new ArrayList<>();
		mBitmaps =  new ArrayList<>();
	}

	public void requestMemory(View view) {
		int size = 1024 * 1024 * 10;     // 10M
		byte[] bytes = new byte[size];
		for(int i=0; i<size; i++) {
			bytes[i] = 1;
		}

		mList.add(bytes);
		printInfo();
	}

	public void requestBitmapMemory(View view) {
		Bitmap bitmap = Bitmap.createBitmap(1024, 1024, Bitmap.Config.ARGB_8888); // 该bitmap占用4Mb的空间 1K * 1K * 4bt
		mBitmaps.add(bitmap);

		printInfo();
	}

	private void printInfo() {
		count++;
		String maxMemory = getFormatSize(Runtime.getRuntime().maxMemory());
		String totalMemory = getFormatSize(Runtime.getRuntime().totalMemory());
		String freeMemory = getFormatSize(Runtime.getRuntime().freeMemory());
		String log  = count + " 当前应用---> 最大可分配内存=" + maxMemory + ", 当前已分配=" + totalMemory + ", 剩余=" + freeMemory + "\n";
		mTextView.append(log);
	}

	private String getFormatSize(long size) {
		return Formatter.formatFileSize(this, size);
	}

}
