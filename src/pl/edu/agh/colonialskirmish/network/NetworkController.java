package pl.edu.agh.colonialskirmish.network;

import pl.edu.agh.colonialskirmish.GameApplication;
import pl.edu.agh.colonialskirmish.network.NetworkService.NetworkServiceBinder;
import pl.edu.agh.colonialskirmish.util.GameLog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;

public class NetworkController {

	private GameApplication gameApplication;

	private NetworkService networkService;

	private boolean boundToService = false;

	private GameLog gameLog;

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

	public NetworkController( GameApplication gameApplication, GameLog gameLog ) {
		super();
		this.gameApplication = gameApplication;
		this.gameLog = gameLog;
	}

	public void connect() {
		Context context = gameApplication.getApplicationContext();
		Intent intent = new Intent(context, NetworkService.class);
		context.bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE);
		gameLog.append("Connecting...");
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
