package com.devstepbcn.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;


/**
 * A BroadcastReceiver that notifies of important Wi-Fi p2p events.
 */
public class AndroidWifiConnectivityReceiver extends BroadcastReceiver {

    private static final String TAG = "ConnectivityReceiver";

    private ConnectivityManager mManager;
    private ReactApplicationContext mActivity;
    private AndroidWifiEventListener listener;


    public AndroidWifiConnectivityReceiver(ConnectivityManager manager,
                                       ReactApplicationContext activity, AndroidWifiEventListener listener) {
        super();
        Log.e(TAG, "AAAAAAA");

        this.mManager = manager;
        this.mActivity = activity;
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.e(TAG, "Received Intent");
        String action = intent.getAction();
        NetworkInfo activeNetwork = mManager.getActiveNetworkInfo();
        Log.e(TAG, action);

    }
}