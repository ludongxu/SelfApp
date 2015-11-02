package self.core.db;

import java.util.Map;

import self.core.util.LogUtils;
import android.content.Context;
import android.content.SharedPreferences;

public class PreferenceUtils {
	private SharedPreferences.Editor mEditor;
    private final SharedPreferences mSP;

    public PreferenceUtils(Context arg2, String arg3, int arg4) {
        super();
        this.mSP = arg2.getSharedPreferences(arg3, arg4);
        this.mEditor = this.mSP.edit();
    }

    public PreferenceUtils clear() {
        this.mEditor.clear();
        return this;
    }

    public boolean commit(String arg2, Object arg3) {
        return this.put(arg2, arg3).commit();
    }

    public boolean commit() {
        boolean v0 = this.mEditor.commit();
        this.mEditor = this.mSP.edit();
        return v0;
    }

    public boolean contains(String arg2) {
        return this.mSP.contains(arg2);
    }

    public Map getAll() {
        return this.mSP.getAll();
    }

    public boolean getBoolean(String arg2, boolean arg3) {
        return this.mSP.getBoolean(arg2, arg3);
    }

    public float getFloat(String arg2, float arg3) {
        return this.mSP.getFloat(arg2, arg3);
    }

    public int getInt(String arg2, int arg3) {
        return this.mSP.getInt(arg2, arg3);
    }

    public long getLong(String arg3, long arg4) {
        return this.mSP.getLong(arg3, arg4);
    }

    public String getString(String arg2, String arg3) {
        return this.mSP.getString(arg2, arg3);
    }

    public PreferenceUtils put(String arg5, Object arg6) {
        if(arg6 == null) {
            this.mEditor.putString(arg5, null);
        }
        else if((arg6 instanceof Boolean)) {
            this.mEditor.putBoolean(arg5, ((Boolean)arg6).booleanValue());
        }
        else {
            if(!(arg6 instanceof Integer) && !(arg6 instanceof Byte)) {
                if((arg6 instanceof Long)) {
                    this.mEditor.putLong(arg5, ((Long)arg6).longValue());
                    return this;
                }
                else if((arg6 instanceof Float)) {
                    this.mEditor.putFloat(arg5, ((Float)arg6).floatValue());
                    return this;
                }
                else if((arg6 instanceof String)) {
                    this.mEditor.putString(arg5, ((String)arg6));
                    return this;
                }
                else {
                    LogUtils.w(PreferenceUtils.class, "值不是Boolean, Integer, Byte, Long, Float, String的类型之一，将调用它的toString()进行保存"
                            );
                    this.mEditor.putString(arg5, arg6.toString());
                    return this;
                }
            }

            this.mEditor.putInt(arg5, ((Integer)arg6).intValue());
        }

        return this;
    }

    public PreferenceUtils remove(String arg2) {
        this.mEditor.remove(arg2);
        return this;
    }
}
