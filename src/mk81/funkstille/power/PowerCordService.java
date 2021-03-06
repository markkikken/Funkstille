package mk81.funkstille.power;

import mk81.funkstille.FunkStilleIntentService;
import mk81.funkstille.R;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class PowerCordService extends FunkStilleIntentService {

    protected static final String ACTION_CONNECT = "CONNECT";
    protected static final String ACTION_DISCONNECT = "DISCONNECT";
    private SharedPreferences settings;

    @Override
    public void onCreate() {
	settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
	super.onCreate();
    }

    public PowerCordService() {
	super("PowerCordService");
    }

    @Override
    protected void onHandleIntent(final Intent intent) {
	if (ACTION_CONNECT.equals(intent.getAction())) {
	    if (settings.getBoolean("SETTING_ENABLE_BT_ON_POWER_CONNECT", true)) {
		showToastMessage(getString(R.string.activateBleutoothMessage));
		getSystemInteractionFacade().enableBluetooth();
	    }
	}
	if (ACTION_DISCONNECT.equals(intent.getAction())) {
	    if (settings.getBoolean("SETTING_DISABLE_BT_ON_POWER_DISCONNECT", true)) {
		showToastMessage(getString(R.string.deactivateBleutoothMessage));
		getSystemInteractionFacade().disableBluetooth();
	    }
	}
    }
}
