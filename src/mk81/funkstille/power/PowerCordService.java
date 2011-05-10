package mk81.funkstille.power;

import android.app.IntentService;
import android.content.Intent;
import android.os.Handler;
import android.widget.Toast;

public class PowerCordService extends IntentService {

    private static final String ACTION_CONNECT = "CONNECT";
    private static final String ACTION_DISCONNECT = "DISCONNECT";

    private Handler handler;

    public PowerCordService() {
	super("PowerCordService");
    }

    @Override
    public void onCreate() {
	this.handler = new Handler();
	super.onCreate();
    }

    @Override
    protected void onHandleIntent(final Intent intent) {
	if (ACTION_CONNECT.equals(intent.getAction())) {
	    showBurnMessage("Activated Bleutooth");

	}
	if (ACTION_DISCONNECT.equals(intent.getAction())) {
	    showBurnMessage("Deactivated Bleutooth");
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
