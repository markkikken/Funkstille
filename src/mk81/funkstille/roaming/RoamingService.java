package mk81.funkstille.roaming;

import mk81.funkstille.FunkStilleIntentService;
import android.content.Intent;

public class RoamingService extends FunkStilleIntentService {

    protected static final String ACTION_START_ROAMING = "START_ROAMING";
    protected static final String ACTION_STOP_ROAMING = "STOP_ROAMING";

    public RoamingService() {
	super("RoamingService");
    }

    @Override
    protected void onHandleIntent(final Intent intent) {
	if (ACTION_START_ROAMING.equals(intent.getAction())) {
	    showBurnMessage("Activating WiFi because we started roaming");
	    getSystemInteractionFacade().enableWifi();
	}
	if (ACTION_STOP_ROAMING.equals(intent.getAction())) {
	    showBurnMessage("Deactivating WiFi because we are no longer roaming");
	    getSystemInteractionFacade().disableWifi();
	}
    }

}
