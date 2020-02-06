package com.example.imusictask.utils;

import android.util.Log;

public final class LogUtils {

    public static final String TAG = "SAM_TAG";
    private static final boolean IS_DEBUG = true;

    public static void d(String value) {
        if (IS_DEBUG)
            Log.d(TAG, value);
    }
}
