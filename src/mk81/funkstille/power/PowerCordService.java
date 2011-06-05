package mk81.funkstille.power;

import mk81.funkstille.SystemInteractionFacade;
import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

public class PowerCordService extends IntentService {

    protected static final String ACTION_CONNECT = "CONNECT";
    protected static final String ACTION_DISCONNECT = "DISCONNECT";

    private SystemInteractionFacade systemInteractionFacade;

    private Handler handler;

    public PowerCordService() {
	super("PowerCordService");
    }

    @Override
    public void onCreate() {
	this.systemInteractionFacade = new SystemInteractionFacade(this);
	this.handler = new Handler();
	super.onCreate();
    }

    @Override
    protected void onHandleIntent(final Intent intent) {
	if (ACTION_CONNECT.equals(intent.getAction())) {
	    showBurnMessage("Activating Bleutooth");
	    systemInteractionFacade.enableBluetooth();
	}
	if (ACTION_DISCONNECT.equals(intent.getAction())) {
	    showBurnMessage("Deactivating Bleutooth");
	    systemInteractionFacade.disableBluetooth();
	}
    }

    private void showBurnMessage(final String message) {
	handler.post(new Runnable() {
	    @Override
	    public void run() {
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
	    }
	});
    }

}
