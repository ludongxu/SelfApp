package self.core;

import android.content.Context;
import android.content.pm.PackageManager;

public class SingletonAppContext extends AppContext {
	private Context context;
    private static SingletonAppContext instance;

    private SingletonAppContext() {
        super();
    }

    public Context getApplicationContext() {
        return this.context.getApplicationContext();
    }

    public Context getContext() {
        return this.context;
    }

    public static SingletonAppContext getInstance() {
        if(SingletonAppContext.instance == null) {
            SingletonAppContext.instance = new SingletonAppContext();
        }

        return SingletonAppContext.instance;
    }

    public PackageManager getPackageManager() {
        return this.context.getPackageManager();
    }

    public String getPackageName() {
        return this.context.getPackageName();
    }

    public void init(Context arg1) {
        this.context = arg1;
    }
}
