package mk81.funkstille.bluetoothcontrol;

import android.app.IntentService;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;

public class BluetoothService extends IntentService {

    private BluetoothAdapter bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();

    public BluetoothService() {
	super("BluetoothService");
    }

    @Override
    protected void onHandleIntent(final Intent intent) {
	// TODO Auto-generated method stub

    }

}
