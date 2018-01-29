package com.devstepbcn.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;


/**
 * A BroadcastReceiver that notifies of important Wi-Fi p2p events.
 */
public class AndroidWifiConnectivityReceiver extends BroadcastReceiver {

    private static final String TAG = "BroadcastReceiver";

    private WifiManager mManager;
    private Channel mChannel;
    private ReactApplicationContext mActivity;
    private AndroidWifiEventListener listener;


    public AndroidWifiConnectivityReceiver(WifiManager manager, Channel channel,
                                       ReactApplicationContext activity, MyEventListener listener) {
        super();
        this.mManager = manager;
        this.mChannel = channel;
        this.mActivity = activity;
        this.listener = listener;
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        String action = intent.getAction();
        if (WifiManager.WIFI_STATE_CHANGED_ACTION.equals(action)) {
            // Check to see if Wi-Fi is enabled and notify appropriate activity

        }
    }
}