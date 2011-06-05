package mk81.funkstille;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.net.wifi.WifiManager;

/**
 * Responsible for all system interactions initiated from Funkstille itself. There can be multiple instances of this
 * class, initiated from multiple contexts.
 * 
 * @author mark
 * 
 */
public class SystemInteractionFacade {

    private WifiManager wifiManager;
    private BluetoothAdapter bluetoothAdapter;

    public SystemInteractionFacade(final Context context) {
	this.wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

	this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
    }

    public void enableBluetooth() {
	bluetoothAdapter.enable();
    }

    public void disableBluetooth() {
	bluetoothAdapter.disable();
    }

    public void enableWifi() {
	wifiManager.setWifiEnabled(true);
    }

    public void disableWifi() {
	wifiManager.setWifiEnabled(false);
    }

}
