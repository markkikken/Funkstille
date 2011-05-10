package mk81.funkstille;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class FunkStilleActivity extends Activity {
    private FunkStilleController controller;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	controller = new FunkStilleController(this);

	Log.d(getPackageCodePath(), "Creating activity");

	setContentView(R.layout.main);
	controller.updateWifiStatus();
	controller.updateRoamingStatus();
	controller.updatePowerStatus();
	// controller.updateBluetoothStatus();

    }
}