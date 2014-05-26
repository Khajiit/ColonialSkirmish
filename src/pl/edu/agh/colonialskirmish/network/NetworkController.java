package pl.edu.agh.colonialskirmish.network;

import pl.edu.agh.colonialskirmish.GameApplication;
import pl.edu.agh.colonialskirmish.network.NetworkService.NetworkServiceBinder;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public class NetworkController {

	GameApplication gameApplication;

	NetworkService networkService;

	boolean boundToService = false;

	ServiceConnection serviceConnection = new ServiceConnection() {

		@Override
		public void onServiceDisconnected( ComponentName name ) {
			boundToService = false;
		}

		@Override
		public void onServiceConnected( ComponentName name, IBinder service ) {
			NetworkServiceBinder binder = (NetworkServiceBinder) service;
			networkService = binder.getService();
			boundToService = true;
			networkService.setNetworkController(NetworkController.this);
		}
	};

	public NetworkController( GameApplication gameApplication ) {
		super();
		this.gameApplication = gameApplication;
	}

	public void connect() {
		Context context = gameApplication.getApplicationContext();
		Intent intent = new Intent(context, NetworkService.class);
		context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
		gameApplication.appendGameLog("Connecting...");
	}

	public void disconnect() {
		if ( boundToService ) {
			Context context = gameApplication.getApplicationContext();
			context.unbindService(serviceConnection);
			boundToService = false;
		}
	}

	public void onTerminate() {
		gameApplication = null;
	}

}
