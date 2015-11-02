package self.core;

import self.core.util.LogUtils;
import android.content.Context;
import android.os.PowerManager;
import android.util.Log;

public class LightedGreenRoom {
	private int clientCount;
    private int count;
    private Context ctx;
    private static LightedGreenRoom s_self;
    PowerManager.WakeLock wl;

    static  {
        LightedGreenRoom.s_self = null;
    }

    private LightedGreenRoom(Context arg2) {
        super();
        this.ctx = null;
        this.wl = null;
        this.clientCount = 0;
        this.ctx = arg2;
        this.wl = this.createWakeLock(arg2);
    }

    private static void assertSetup() {
        if(LightedGreenRoom.s_self == null) {
            LogUtils.w("BaseLib", "You need to call setup first");
            throw new RuntimeException("You need to setup GreenRoom first");
        }
    }

    private PowerManager.WakeLock createWakeLock(Context arg4) {
        return ((PowerManager) arg4.getSystemService("power")).newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "BaseLib");
    }

    public static void ds_emptyTheRoom() {
        LightedGreenRoom.assertSetup();
        LightedGreenRoom.s_self.emptyTheRoom();
    }

	private void emptyTheRoom() {
		synchronized (this) {

			LogUtils.d("BaseLib", "Call to empty the room");
			this.count = 0;
			this.turnOffLights();

		}
	}

	private int enter() {
		int v0_1;

		synchronized (this) {

			++this.count;
			LogUtils.d("BaseLib", "A new visitor: count:" + this.count);
			v0_1 = this.count;

		}
		return v0_1;
	}

	private int getCount() {
		int v0_1;
		synchronized (this) {

			v0_1 = this.count;

		}

		return v0_1;
	}

    public static boolean isSetup() {
        boolean v0;
        if(LightedGreenRoom.s_self != null) {
            v0 = true;
        }
        else {
            v0 = false;
        }

        return v0;
    }

	private int leave() {
		int v0_1;

		synchronized (this) {

			Log.d("BaseLib", "Leaving room:count at the call:" + this.count);
			if (this.count == 0) {
				LogUtils.w("BaseLib", "Count is zero.");
				v0_1 = this.count;
			} else {
				--this.count;
				if (this.count == 0) {
					this.turnOffLights();
				}

				v0_1 = this.count;
			}

		}

		return v0_1;
	}

    private int registerClient() {
        ++this.clientCount;
        LogUtils.d("BaseLib", "registering a new client:count:" + this.clientCount);
        return this.clientCount;
    }

    public static int s_enter() {
        LightedGreenRoom.assertSetup();
        return LightedGreenRoom.s_self.enter();
    }

    public static int s_leave() {
        LightedGreenRoom.assertSetup();
        return LightedGreenRoom.s_self.leave();
    }

    public static void s_registerClient() {
        LightedGreenRoom.assertSetup();
        LightedGreenRoom.s_self.registerClient();
    }

    public static void s_unRegisterClient() {
        LightedGreenRoom.assertSetup();
        LightedGreenRoom.s_self.unRegisterClient();
    }

    public static void setup(Context arg2) {
        if(LightedGreenRoom.s_self == null) {
            LogUtils.d("BaseLib", "Creating green room and lighting it");
            LightedGreenRoom v0 = new LightedGreenRoom(arg2);
            LightedGreenRoom.s_self = v0;
            v0.turnOnLights();
        }
    }

    private void turnOffLights() {
        if(this.wl.isHeld()) {
            LogUtils.d("BaseLib", "Releasing wake lock. No more visitors");
            this.wl.release();
        }
    }

    private void turnOnLights() {
        LogUtils.d("BaseLib", "Turning on lights. Count:" + this.count);
        this.wl.acquire();
    }

    private int unRegisterClient() {
        int v0;
        LogUtils.d("BaseLib", "un registering a new client:count:" + this.clientCount);
        if(this.clientCount == 0) {
            LogUtils.w("BaseLib", "There are no clients to unregister.");
            v0 = 0;
        }
        else {
            --this.clientCount;
            if(this.clientCount == 0) {
                this.emptyTheRoom();
            }

            v0 = this.clientCount;
        }

        return v0;
    }
}
