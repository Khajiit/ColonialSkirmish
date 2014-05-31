package pl.edu.agh.colonialskirmish;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.colonialskirmish.game.BasicGameController;
import pl.edu.agh.colonialskirmish.game.GameController;
import pl.edu.agh.colonialskirmish.network.NetworkController;
import pl.edu.agh.colonialskirmish.rhino.RhinoContext;
import pl.edu.agh.colonialskirmish.util.GameLog;
import android.app.Activity;
import android.app.Application;

public class GameApplication extends Application {

	protected RhinoContext rhinoContext;

	protected GameLog gameLog = new GameLog();

	protected NetworkController networkController;

	protected Activity currentActivity;

	protected BasicGameController gameController;

	public GameApplication() {
		super();
		// Network controller
		networkController = new NetworkController(this, gameLog);

		// GameController
		gameController = new BasicGameController(this, gameLog);

		// Rhino context for js execution
		rhinoContext = new RhinoContext();
		Map<String, Object> variablesMap = new HashMap<String, Object>();
		variablesMap.put("gameController", gameController);
		variablesMap.put("gameLog", gameLog);
		rhinoContext.setVariablesMap(variablesMap);

		gameController.setRhinoContext(rhinoContext);
	}

	public RhinoContext getRhinoContext() {
		return rhinoContext;
	}

	public void setRhinoContext( RhinoContext rhinoContext ) {
		this.rhinoContext = rhinoContext;
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

	public GameController getGameController() {
		return gameController;
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
		gameController.getGameContext().onTerminate();
		super.onTerminate();
	}

}
