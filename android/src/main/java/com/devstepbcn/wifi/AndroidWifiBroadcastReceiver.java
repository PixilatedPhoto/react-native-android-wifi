package com.devstepbcn.wifi;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.SupplicantState;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.util.Log;

import com.facebook.react.bridge.ReactApplicationContext;


/**
 * A BroadcastReceiver that notifies of important Wi-Fi p2p events.
 */
public class AndroidWifiConnectivityReceiver extends BroadcastReceiver {

    private static final String TAG = "ConnectivityReceiver";

    private WifiManager mManager;
    private ReactApplicationContext mActivity;
    private AndroidWifiEventListener listener;


    public AndroidWifiConnectivityReceiver(WifiManager manager,
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
        WifiInfo wifiInfo = mManager.getConnectionInfo();
//        int mState = mManager.getWifiState();
        SupplicantState ss = wifiInfo.getSupplicantState();
        NetworkInfo.DetailedState ds = wifiInfo.getDetailedStateOf(ss);
//        NetworkInfo netInfo = NetworkInfo.State.
//        NetworkInfo.DetailedState networkState = netInfo.getDetailedState();

//        String networkType = netInfo.getTypeName();
//        String networkName = netInfo.getExtraInfo();
//        if (!networkState.equals("Disconnected")){
//            Log.e(TAG, networkState);
//        }
       if (listener != null) {
               listener.onConnectivityChange(ds.toString());
       }

        // Log.e(TAG, ss.toString());
        // Log.e(TAG, ds.toString());
        Log.e(TAG, "HELLO");

    }
}