package io.left.core;

import android.app.Application;
import android.content.Context;

import com.crashlytics.android.Crashlytics;

import io.fabric.sdk.android.Fabric;
import io.left.core.util.BuildConfig;
import timber.log.Timber;




public class MyApplication extends Application  {


    @Override
    public void onCreate() {
        super.onCreate();

        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Fabric.with(this, new Crashlytics());
        }
    }

    public static MyApplication get(Context context) {
        return (MyApplication) context.getApplicationContext();
    }

}
