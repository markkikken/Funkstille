package mk81.funkstille;

import android.content.Context;

/**
 * Responsible for all system interactions initiated from Funkstille itself. There can be multiple instances of this
 * class, initiated from multiple contexts.
 * 
 * @author mark
 * 
 */
public class SystemInteractionFacade extends SystemStatusFacade {

    public SystemInteractionFacade(final Context context) {
	super(context);
    }

    public void enableBluetooth() {
	if (bluetoothAdapter != null) {
	    bluetoothAdapter.enable();
	}
    }

    public void disableBluetooth() {
	if (bluetoothAdapter != null) {
	    bluetoothAdapter.disable();
	}
    }

    public void enableWifi() {
	if (wifiManager != null) {
	    wifiManager.setWifiEnabled(true);
	}
    }

    public void disableWifi() {
	if (wifiManager != null) {
	    wifiManager.setWifiEnabled(false);
	}
    }

}
