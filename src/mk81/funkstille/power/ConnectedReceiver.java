package mk81.funkstille.power;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class ConnectedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
	Toast.makeText(context, intent.getAction(), Toast.LENGTH_LONG).show();
    }
}