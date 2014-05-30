package pl.edu.agh.colonialskirmish;

import java.text.SimpleDateFormat;
import java.util.Date;

import pl.edu.agh.colonialskirmish.game.GameContext;
import pl.edu.agh.colonialskirmish.network.NetworkController;
import pl.edu.agh.colonialskirmish.rhino.RhinoContext;
import pl.edu.agh.colonialskirmish.util.GameLog;
import android.app.Activity;
import android.app.Application;

public class GameApplication extends Application {

	protected RhinoContext rhinoContext = new RhinoContext();

	protected GameContext gameContext = new GameContext();

	protected GameLog gameLog = new GameLog();

	protected NetworkController networkController;

	protected Activity currentActivity;

	public GameApplication() {
		super();
		networkController = new NetworkController(this, gameLog);
	}

	public RhinoContext getRhinoContext() {
		return rhinoContext;
	}

	public void setRhinoContext( RhinoContext rhinoContext ) {
		this.rhinoContext = rhinoContext;
	}

	public GameContext getGameContext() {
		return gameContext;
	}

	public void setGameContext( GameContext gameContext ) {
		this.gameContext = gameContext;
	}

	public NetworkController getNetworkController() {
		return networkController;
	}

	public void setNetworkController( NetworkController networkController ) {
		this.networkController = networkController;
	}

	public Activity getCurrentActivity() {
		return currentActivity;
	}

	public void setCurrentActivity( Activity currentActivity ) {
		this.currentActivity = currentActivity;
	}

	public GameLog getGameLog() {
		return gameLog;
	}

	public void appendGameLog( String newLogMsg ) {
		Date date = new Date();
		SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
		this.gameLog.append("[");
		this.gameLog.append(dateFormat.format(date));
		this.gameLog.append("] ");
		this.gameLog.append(newLogMsg);
		this.gameLog.append("\n");
	}

	// FIXME: this won't be called on real device!
	@Override
	public void onTerminate() {
		rhinoContext.onTerminate();
		networkController.onTerminate();
		gameContext.onTerminate();
		super.onTerminate();
	}

}
