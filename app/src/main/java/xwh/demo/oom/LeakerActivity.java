package xwh.demo.oom;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

/**
 * 测试内存泄漏
 */
public class LeakerActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_leaker);

		LeakContainer.add(this);    // 被静态变量持有，退出后LeakerActivity无法被释放
	}
}
