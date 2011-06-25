package mk81.funkstille.roaming;

import mk81.funkstille.FunkStilleIntentService;
import mk81.funkstille.R;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class RoamingService extends FunkStilleIntentService {

    private static final String PREVIOUS_ROAMING_ACTION = "PREVIOUS_ROAMING_ACTION";
    protected static final String ACTION_START_ROAMING = "START_ROAMING";
    protected static final String ACTION_STOP_ROAMING = "STOP_ROAMING";

    private SharedPreferences settings;

    public RoamingService() {
	super("RoamingService");
    }

    @Override
    public void onCreate() {
	settings = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
	super.onCreate();
    }

    @Override
    protected void onHandleIntent(final Intent intent) {
	if (noChangePrecoditionCheck(intent)) {
	    return;
	}
	storePreviousAction(intent);

	if (ACTION_START_ROAMING.equals(intent.getAction())) {
	    if (settings.getBoolean("SETTING_ENABLE_WIFI_ON_ROAMING", true)) {
		showToastMessage(getString(R.string.enableWifiMessage));
		getSystemInteractionFacade().enableWifi();
	    }
	} else if (ACTION_STOP_ROAMING.equals(intent.getAction())) {
	    if (settings.getBoolean("SETTING_DISABLE_WIFI_AFTER_ROAMING", true)) {
		showToastMessage(getString(R.string.disableWifiMessage));
		getSystemInteractionFacade().disableWifi();
	    }
	} else {
	    throw new IllegalArgumentException("Unknown intent action!");
	}
    }

    private void storePreviousAction(final Intent intent) {
	settings.edit().putString(PREVIOUS_ROAMING_ACTION, intent.getAction()).commit();
    }

    private boolean noChangePrecoditionCheck(final Intent intent) {
	return settings.getString(PREVIOUS_ROAMING_ACTION, "none").equals(intent.getAction());
    }

}
