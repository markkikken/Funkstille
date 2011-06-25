package mk81.funkstille;

import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.BatteryManager;

/**
 * Responsible for system status queries initiated from Funkstille itself. There can be multiple instances of this
 * class, initiated from multiple contexts.
 * 
 * @author mark
 * 
 */
public class SystemStatusFacade {

    protected WifiManager wifiManager;
    protected ConnectivityManager connectivityManager;
    protected BluetoothAdapter bluetoothAdapter;

    private volatile boolean powerCordPlugged = false;

    public SystemStatusFacade(final Context context) {
	this.wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
	this.connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

	context.registerReceiver(new BroadcastReceiver() {
	    @Override
	    public void onReceive(final Context context, final Intent intent) {
		powerCordPlugged = (intent.getExtras().getInt(BatteryManager.EXTRA_PLUGGED) != 0);
	    }
	}, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

	this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public boolean isWifiEnabled() {
	return wifiManager == null ? false : wifiManager.isWifiEnabled();
    }

    public boolean isPowerCordPlugged() {
	return powerCordPlugged;
    }

    public boolean isBluetoothEnabled() {
	return bluetoothAdapter == null ? false : bluetoothAdapter.isEnabled();
    }

    public boolean isRoaming() {
	NetworkInfo activeNetworkInfo = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);
	if (activeNetworkInfo == null) {
	    return false;
	}
	return activeNetworkInfo.isRoaming();
    }

}
