package mk81.funkstille.ui;

import mk81.funkstille.R;
import mk81.funkstille.SystemStatusFacade;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

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

    @Override
    public boolean onCreateOptionsMenu(final Menu menu) {
	getMenuInflater().inflate(R.menu.options, menu);
	return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(final MenuItem item) {
	if (item.getItemId() == R.id.settings) {
	    startActivity(new Intent(this, FunkstilleSettingsActivity.class));
	}
	return super.onOptionsItemSelected(item);
    }
}