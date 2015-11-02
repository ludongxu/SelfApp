package self.core.util;

import android.util.Log;

public class LogUtils {
	private static boolean isShowLog;
    private static int level;
    private static String tag;

    static  {
        LogUtils.isShowLog = false;
        LogUtils.level = 3;
        LogUtils.tag = "BaseLib";
    }

    public LogUtils() {
        super();
    }

    public static void d(String arg2, String arg3) {
        if((LogUtils.isShowLog) && 3 >= LogUtils.level) {
            Log.d(arg2, arg3);
        }
    }

    public static void d(Class arg2, String arg3) {
        LogUtils.d("[" + arg2.getSimpleName() + "]" + arg3);
    }

    public static void d(String arg2) {
        if((LogUtils.isShowLog) && 3 >= LogUtils.level) {
            Log.d(LogUtils.tag, arg2);
        }
    }

    public static void d(Class arg2, String arg3, Throwable arg4) {
        LogUtils.d("[" + arg2.getSimpleName() + "]" + arg3, arg4);
    }

    public static void d(String arg2, Throwable arg3) {
        if((LogUtils.isShowLog) && 3 >= LogUtils.level) {
            Log.d(LogUtils.tag, arg2, arg3);
        }
    }

    public static void d(String arg2, Class arg3, String arg4) {
        LogUtils.d(arg2, "[" + arg3.getSimpleName() + "]" + arg4);
    }

    public static void d(String arg2, Class arg3, String arg4, Throwable arg5) {
        LogUtils.d(arg2, "[" + arg3.getSimpleName() + "]" + arg4, arg5);
    }

    public static void d(String arg2, String arg3, Throwable arg4) {
        if((LogUtils.isShowLog) && 3 >= LogUtils.level) {
            Log.d(arg2, arg3, arg4);
        }
    }

    public static void e(String arg2, String arg3, Throwable arg4) {
        if((LogUtils.isShowLog) && 6 >= LogUtils.level) {
            Log.e(arg2, arg3, arg4);
        }
    }

    public static void e(String arg2, String arg3) {
        if((LogUtils.isShowLog) && 6 >= LogUtils.level) {
            Log.e(arg2, arg3);
        }
    }

    public static void e(String arg2, Throwable arg3) {
        if((LogUtils.isShowLog) && 6 >= LogUtils.level) {
            Log.e(LogUtils.tag, arg2, arg3);
        }
    }

    public static void e(Class arg2, String arg3, Throwable arg4) {
        LogUtils.e("[" + arg2.getSimpleName() + "]" + arg3, arg4);
    }

    public static void e(Class arg2, String arg3) {
        LogUtils.e("[" + arg2.getSimpleName() + "]" + arg3);
    }

    public static void e(String arg2) {
        if((LogUtils.isShowLog) && 6 >= LogUtils.level) {
            Log.e(LogUtils.tag, arg2);
        }
    }

    public static void e(String arg2, Class arg3, String arg4) {
        LogUtils.e(arg2, "[" + arg3.getSimpleName() + "]" + arg4);
    }

    public static void e(String arg2, Class arg3, String arg4, Throwable arg5) {
        LogUtils.e(arg2, "[" + arg3.getSimpleName() + "]" + arg4, arg5);
    }

    public static void enableLogging(boolean arg0) {
        LogUtils.isShowLog = arg0;
    }

    public static int getLevel() {
        return LogUtils.level;
    }

    public static void i(String arg2, String arg3) {
        if((LogUtils.isShowLog) && 4 >= LogUtils.level) {
            Log.i(arg2, arg3);
        }
    }

    public static void i(Class arg2, String arg3) {
        LogUtils.i("[" + arg2.getSimpleName() + "]" + arg3);
    }

    public static void i(String arg2) {
        if((LogUtils.isShowLog) && 4 >= LogUtils.level) {
            Log.i(LogUtils.tag, arg2);
        }
    }

    public static void i(Class arg2, String arg3, Throwable arg4) {
        LogUtils.i("[" + arg2.getSimpleName() + "]" + arg3, arg4);
    }

    public static void i(String arg2, Throwable arg3) {
        if((LogUtils.isShowLog) && 4 >= LogUtils.level) {
            Log.i(LogUtils.tag, arg2, arg3);
        }
    }

    public static void i(String arg2, Class arg3, String arg4) {
        LogUtils.i(arg2, "[" + arg3.getSimpleName() + "]" + arg4);
    }

    public static void i(String arg2, Class arg3, String arg4, Throwable arg5) {
        LogUtils.i(arg2, "[" + arg3.getSimpleName() + "]" + arg4, arg5);
    }

    public static void i(String arg2, String arg3, Throwable arg4) {
        if((LogUtils.isShowLog) && 4 >= LogUtils.level) {
            Log.i(arg2, arg3, arg4);
        }
    }

    public static boolean isLogEnabled() {
        return LogUtils.isShowLog;
    }

    public static void setLevel(int arg0) {
        LogUtils.level = arg0;
    }

    public static void setTag(String arg0) {
        LogUtils.tag = arg0;
    }

    public static void v(Class arg2, String arg3) {
        LogUtils.v("[" + arg2.getSimpleName() + "]" + arg3);
    }

    public static void v(String arg2) {
        if((LogUtils.isShowLog) && 2 >= LogUtils.level) {
            Log.v(LogUtils.tag, arg2);
        }
    }

    public static void v(Class arg2, String arg3, Throwable arg4) {
        LogUtils.v("[" + arg2.getSimpleName() + "]" + arg3, arg4);
    }

    public static void v(String arg2, Throwable arg3) {
        if((LogUtils.isShowLog) && 2 >= LogUtils.level) {
            Log.v(LogUtils.tag, arg2, arg3);
        }
    }

    public static void v(String arg2, Class arg3, String arg4) {
        LogUtils.v(arg2, "[" + arg3.getSimpleName() + "]" + arg4);
    }

    public static void v(String arg2, String arg3) {
        if((LogUtils.isShowLog) && 2 >= LogUtils.level) {
            Log.v(arg2, arg3);
        }
    }

    public static void v(String arg2, Class arg3, String arg4, Throwable arg5) {
        LogUtils.v(arg2, "[" + arg3.getSimpleName() + "]" + arg4, arg5);
    }

    public static void v(String arg2, String arg3, Throwable arg4) {
        if((LogUtils.isShowLog) && 2 >= LogUtils.level) {
            Log.v(arg2, arg3, arg4);
        }
    }

    public static void w(Class arg2, String arg3) {
        LogUtils.w("[" + arg2.getSimpleName() + "]" + arg3);
    }

    public static void w(String arg2) {
        if((LogUtils.isShowLog) && 5 >= LogUtils.level) {
            Log.w(LogUtils.tag, arg2);
        }
    }

    public static void w(Class arg2, String arg3, Throwable arg4) {
        LogUtils.w("[" + arg2.getSimpleName() + "]" + arg3, arg4);
    }

    public static void w(String arg2, Throwable arg3) {
        if((LogUtils.isShowLog) && 5 >= LogUtils.level) {
            Log.w(LogUtils.tag, arg2, arg3);
        }
    }

    public static void w(String arg2, Class arg3, String arg4) {
        LogUtils.w(arg2, "[" + arg3.getSimpleName() + "]" + arg4);
    }

    public static void w(String arg2, String arg3) {
        if((LogUtils.isShowLog) && 5 >= LogUtils.level) {
            Log.w(arg2, arg3);
        }
    }

    public static void w(String arg2, Class arg3, String arg4, Throwable arg5) {
        LogUtils.w(arg2, "[" + arg3.getSimpleName() + "]" + arg4, arg5);
    }

    public static void w(String arg2, String arg3, Throwable arg4) {
        if((LogUtils.isShowLog) && 5 >= LogUtils.level) {
            Log.w(arg2, arg3, arg4);
        }
    }
}
