package mk81.funkstille.ui;

import mk81.funkstille.R;
import mk81.funkstille.SystemStatusFacade;
import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ToggleButton;

public class FunkStilleStatusActivity extends Activity {
    private final class PowerCordBroadcastReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(final Context context, final Intent intent) {
	    ((ToggleButton) findViewById(R.id.powerToggleButton)).setChecked(systemFacade.isPowerCordPlugged());
	}
    }

    private final class RoamingBroadcastReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(final Context context, final Intent intent) {
	    ((ToggleButton) findViewById(R.id.roamingToggleButton)).setChecked(systemFacade.isRoaming());
	}
    }

    private final class BluetoothBroadcastReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(final Context context, final Intent intent) {
	    ((ToggleButton) findViewById(R.id.bluetoothToggleButton)).setChecked(systemFacade.isBluetoothEnabled());
	}
    }

    private final class WifiBroadcastReceiver extends BroadcastReceiver {
	@Override
	public void onReceive(final Context context, final Intent intent) {
	    ((ToggleButton) findViewById(R.id.wifiToggleButton)).setChecked(systemFacade.isWifiEnabled());
	}
    }

    private SystemStatusFacade systemFacade;
    private PowerCordBroadcastReceiver powerCordBroadcastReceiver;
    private WifiBroadcastReceiver wifiBroadcastReceiver;
    private BluetoothBroadcastReceiver bluetoothBroadcastReceiver;
    private RoamingBroadcastReceiver roamingBroadcastReceiver;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	systemFacade = new SystemStatusFacade(this);

	Log.d(getPackageCodePath(), "Creating activity");

	setContentView(R.layout.status);

	initializeView();
	registerViewsBroadcastReceivers();

    }

    private void initializeView() {
	((ToggleButton) findViewById(R.id.wifiToggleButton)).setChecked(systemFacade.isWifiEnabled());
	((ToggleButton) findViewById(R.id.bluetoothToggleButton)).setChecked(systemFacade.isBluetoothEnabled());
	((ToggleButton) findViewById(R.id.powerToggleButton)).setChecked(systemFacade.isPowerCordPlugged());
	((ToggleButton) findViewById(R.id.roamingToggleButton)).setChecked(systemFacade.isRoaming());
    }

    private void registerViewsBroadcastReceivers() {
	powerCordBroadcastReceiver = new PowerCordBroadcastReceiver();
	registerReceiver(powerCordBroadcastReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));

	roamingBroadcastReceiver = new RoamingBroadcastReceiver();
	registerReceiver(roamingBroadcastReceiver, new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION));

	bluetoothBroadcastReceiver = new BluetoothBroadcastReceiver();
	registerReceiver(bluetoothBroadcastReceiver, new IntentFilter(BluetoothAdapter.ACTION_STATE_CHANGED));

	wifiBroadcastReceiver = new WifiBroadcastReceiver();
	registerReceiver(wifiBroadcastReceiver, new IntentFilter(WifiManager.WIFI_STATE_CHANGED_ACTION));
    }

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
	getMenuInflater().inflate(R.menu.options, menu);
	return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
	if (item.getItemId() == R.id.settings_menuitem) {
	    startActivity(new Intent(this, FunkStilleSettingsActivity.class));
	}
	return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onDestroy() {
	unregisterReceiver(powerCordBroadcastReceiver);
	unregisterReceiver(bluetoothBroadcastReceiver);
	unregisterReceiver(roamingBroadcastReceiver);
	unregisterReceiver(wifiBroadcastReceiver);

	super.onDestroy();
    }
}