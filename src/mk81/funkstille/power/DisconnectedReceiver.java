package mk81.funkstille.power;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class DisconnectedReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
	Intent serviceIntent = new Intent(context.getApplicationContext(), PowerCordService.class);
	serviceIntent.setAction("disconnected");
	context.startService(serviceIntent);
    }
}