package io.monteirodev.retroimgur;

import android.app.Application;

import io.monteirodev.retroimgur.api.OAuthUtil;


public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // ensure the shared pref is initialized with the Global Context
        OAuthUtil.initSharedPref(this);
    }
}
