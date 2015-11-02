package self.core;

import android.app.ActivityManager;
import android.app.Application;
import android.content.res.AssetManager;

public class AppContext extends Application {
	private ActivityManager activityManager;
	private AssetManager assetManager;

	public ActivityManager getActivityManager() {
		if (this.activityManager == null) {
			this.activityManager = (ActivityManager) this
					.getApplicationContext().getSystemService("activity");
		}

		return this.activityManager;
	}
	
	  public AssetManager getAssetManager() {
	        if(this.assetManager == null) {
	            this.assetManager = this.getApplicationContext().getAssets();
	        }

	        return this.assetManager;
	    }
}
