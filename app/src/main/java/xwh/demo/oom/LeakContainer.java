package xwh.demo.oom;

import android.content.Context;

import java.util.ArrayList;

/**
 * Created by xwh on 2019/4/11.
 */
public class LeakContainer {
	public static  ArrayList<Context> mLeaks = new ArrayList<>();

	public static void add(Context context) {
		mLeaks.add(context);
	}

	public static void remove(Context context) {
		mLeaks.remove(context);
	}
}
