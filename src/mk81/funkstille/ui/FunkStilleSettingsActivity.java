package mk81.funkstille.ui;

import mk81.funkstille.R;
import android.os.Bundle;
import android.preference.PreferenceActivity;

public class FunkStilleSettingsActivity extends PreferenceActivity {

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	addPreferencesFromResource(R.xml.settings);
    }
}
