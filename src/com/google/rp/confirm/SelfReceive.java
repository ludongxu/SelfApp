package com.google.rp.confirm;

import self.core.LightedGreenRoom;
import self.core.util.LogUtils;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.PowerManager;

public class SelfReceive extends BroadcastReceiver{
	private static String a = "SelfReceive";

	@Override
	public void onReceive(Context context, Intent intent) {
		LogUtils.enableLogging(true);
		//((PowerManager) context.getSystemService("power")).newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
		LogUtils.d(SelfReceive.a, "### MyReceiver started");
        LightedGreenRoom.setup(context);
        this.startServer(context, intent);
        LogUtils.d(SelfReceive.a, "### MyReceiver finished");
	}
	



	private void startServer(Context context, Intent intent) {
		context.startService(new Intent(context, SelfService.class));
	}
	

}
