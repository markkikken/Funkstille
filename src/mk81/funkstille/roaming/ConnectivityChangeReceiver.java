package mk81.funkstille.roaming;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectivityChangeReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(final Context context, final Intent intent) {
	NetworkInfo newNetworkInfo = getNewNetworkInfo(intent);

	if (!concernsMobileNetwork(newNetworkInfo)) {
	    return;
	}
	if (!connectedToNetwork(newNetworkInfo)) {
	    return;
	}

	// TODO how to handle change if roaming state is not affected?
	if (newNetworkInfo.isRoaming()) {
	    sendActionToService(context, RoamingService.ACTION_START_ROAMING);
	} else {
	    sendActionToService(context, RoamingService.ACTION_STOP_ROAMING);
	}
    }

    private void sendActionToService(final Context context, final String action) {
	Intent serviceIntent = new Intent(context.getApplicationContext(), RoamingService.class);
	serviceIntent.setAction(action);
	context.startService(serviceIntent);
    }

    private NetworkInfo getNewNetworkInfo(final Intent intent) {
	return intent.getParcelableExtra(ConnectivityManager.EXTRA_NETWORK_INFO);
    }

    private boolean concernsMobileNetwork(final NetworkInfo newNetworkInfo) {
	return ConnectivityManager.TYPE_MOBILE == newNetworkInfo.getType();
    }

    private boolean connectedToNetwork(final NetworkInfo newNetworkInfo) {
	return newNetworkInfo.isConnected();
    }
}
