
package com.android.mcafee.apphub;

import android.app.Application;
import android.os.Looper;

import com.android.mcafee.apphub.loader.PhotoManager;

public class AppHubApplication extends Application {

    private PhotoManager mPhotoManager;

    public AppHubApplication() {
        // TODO Auto-generated constructor stub
    }

    @Override
    public Object getSystemService(String name) {
        if (PhotoManager.PHOTO_SERVICE.equals(name)) {
            if (mPhotoManager == null) {
                mPhotoManager = PhotoManager.createPhotoManager(this);
                registerComponentCallbacks(mPhotoManager);
            }
            return mPhotoManager;
        }

        return super.getSystemService(name);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        new Thread(new Runnable() {

            @Override
            public void run() {
                Looper.prepare();
                PhotoManager manager = (PhotoManager)getApplicationContext().getSystemService(
                        PhotoManager.PHOTO_SERVICE);
                Looper.loop();
            }
        }).start();;
    }
}
