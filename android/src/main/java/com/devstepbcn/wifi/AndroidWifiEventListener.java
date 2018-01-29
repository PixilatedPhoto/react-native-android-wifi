package com.pixilated.wallpixi.wifidirectmanager;

import android.net.wifi.p2p.WifiP2pDeviceList;

public interface AndroidWifiEventListener {
    void onWifiStateChange (String wifiStateInfo);
}