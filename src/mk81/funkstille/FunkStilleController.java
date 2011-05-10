package mk81.funkstille;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.widget.ToggleButton;

public class FunkStilleController {

	private Activity mainActivity;
	private WifiManager wifiManager;
	private ConnectivityManager connectivityManager;
	private BluetoothAdapter bluetoothAdapter;
	
	public FunkStilleController(Activity mainActivity) {
		this.mainActivity = mainActivity;
	
		this.wifiManager = (WifiManager) mainActivity.getSystemService(Activity.WIFI_SERVICE);
		this.connectivityManager = (ConnectivityManager) mainActivity.getSystemService(Activity.CONNECTIVITY_SERVICE);
	
		this.bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
	}

	
	public void updateWifiStatus() {
		ToggleButton toggle = (ToggleButton) mainActivity.findViewById(R.id.wifiToggleButton);
		toggle.setChecked(wifiManager.isWifiEnabled());
	}
	
	public void updatePowerStatus() {
		ToggleButton toggle = (ToggleButton) mainActivity.findViewById(R.id.powerToggleButton);
		
		
	}

	public void updateBluetoothStatus() {
		ToggleButton toggle = (ToggleButton) mainActivity.findViewById(R.id.bluetoothToggleButton);
		toggle.setChecked(bluetoothAdapter.isEnabled());		
	}

	
	public void updateRoamingStatus() {
		ToggleButton toggle = (ToggleButton) mainActivity.findViewById(R.id.roamingToggleButton);
		toggle.setChecked(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).isRoaming());
	}
	
	
}
