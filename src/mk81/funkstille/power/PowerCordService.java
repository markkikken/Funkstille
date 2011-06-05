package mk81.funkstille.power;

import mk81.funkstille.FunkStilleIntentService;
import android.content.Intent;

public class PowerCordService extends FunkStilleIntentService {

    protected static final String ACTION_CONNECT = "CONNECT";
    protected static final String ACTION_DISCONNECT = "DISCONNECT";

    public PowerCordService() {
	super("PowerCordService");
    }

    @Override
    protected void onHandleIntent(final Intent intent) {
	if (ACTION_CONNECT.equals(intent.getAction())) {
	    showBurnMessage("Activating Bleutooth because powercord has been plugged in");
	    getSystemInteractionFacade().enableBluetooth();
	}
	if (ACTION_DISCONNECT.equals(intent.getAction())) {
	    showBurnMessage("Deactivating Bleutooth because powercord has been unplugged");
	    getSystemInteractionFacade().disableBluetooth();
	}
    }

}
