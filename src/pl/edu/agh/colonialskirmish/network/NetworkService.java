package pl.edu.agh.colonialskirmish.network;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;

/**
 * It uses application main thread by default, so it is important to do all work
 * in separate Thread
 * 
 * @author Khajiit
 * 
 */
public class NetworkService extends Service {

	private final IBinder binder = new NetworkServiceBinder();

	private NetworkController networkController;

	@Override
	public IBinder onBind( Intent arg0 ) {
		return binder;
	}

	public void setNetworkController( NetworkController networkController ) {
		this.networkController = networkController;
	}

	public class NetworkServiceBinder extends Binder {

		NetworkService getService() {
			return NetworkService.this;
		}
	}

	public interface NetworkServiceCallback {

		public void test();

	}

}
