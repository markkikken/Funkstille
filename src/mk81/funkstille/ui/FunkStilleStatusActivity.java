package mk81.funkstille.ui;

import mk81.funkstille.R;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class FunkStilleStatusActivity extends Activity {
    private SystemStatusFacade systemFacade;

    /** Called when the activity is first created. */
    @Override
    public void onCreate(final Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	// systemFacade = new SystemStatusFacade(this);

	Log.d(getPackageCodePath(), "Creating activity");

	setContentView(R.layout.main);

    }
}