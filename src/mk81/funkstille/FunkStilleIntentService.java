package mk81.funkstille;

import android.app.IntentService;
import android.os.Handler;
import android.widget.Toast;

public abstract class FunkStilleIntentService extends IntentService {

    private SystemInteractionFacade systemInteractionFacade;
    private Handler handler;

    public FunkStilleIntentService(final String name) {
	super(name);
    }

    @Override
    public void onCreate() {
	this.systemInteractionFacade = new SystemInteractionFacade(this);
	this.handler = new Handler();
	super.onCreate();
    }

    /**
     * Does a trick with handlers to allow us to show a toast message from the intentservice.
     * 
     * @param message
     */
    protected void showToastMessage(final String message) {
	handler.post(new Runnable() {
	    @Override
	    public void run() {
		Toast.makeText(getApplicationContext(), message, Toast.LENGTH_LONG).show();
	    }
	});
    }

    protected SystemInteractionFacade getSystemInteractionFacade() {
	return systemInteractionFacade;
    }

    @Override
    public void onDestroy() {
	systemInteractionFacade.cleanUp();
	super.onDestroy();
    }
}