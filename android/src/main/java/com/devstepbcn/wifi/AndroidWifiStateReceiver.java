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
public class AndroidWifiStateReceiver extends BroadcastReceiver {

	private static final String TAG = "AndroidWifiStateReceiver";

	private WifiManager mManager;
	private ReactApplicationContext mActivity;
	private AndroidWifiEventListener listener;

	public AndroidWifiStateReceiver(WifiManager manager,
									   ReactApplicationContext activity, AndroidWifiEventListener listener) {
		super();
		this.mManager = manager;
		this.mActivity = activity;
		this.listener = listener;
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		WifiInfo wifiInfo = mManager.getConnectionInfo();
		SupplicantState ss = wifiInfo.getSupplicantState();
		NetworkInfo.DetailedState ds = wifiInfo.getDetailedStateOf(ss);

		if (listener != null) {
				listener.onConnectivityChange(ds.toString());
		}
	}
}