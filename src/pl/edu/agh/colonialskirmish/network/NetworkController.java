package pl.edu.agh.colonialskirmish.network;

import pl.edu.agh.colonialskirmish.GameApplication;

public class NetworkController {

	GameApplication gameApplication;

	public NetworkController( GameApplication gameApplication ) {
		super();
		this.gameApplication = gameApplication;
	}

	public void connect() {
		gameApplication.appendGameLog("Connecting...");
	}

	public void onTerminate() {
		gameApplication = null;
	}

}
