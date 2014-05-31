package pl.edu.agh.colonialskirmish.game;

import pl.edu.agh.colonialskirmish.network.NetworkController;
import pl.edu.agh.colonialskirmish.rhino.RhinoContext;
import pl.edu.agh.colonialskirmish.util.GameLog;
import android.content.Context;
import android.widget.Toast;

public class BasicGameController implements GameController {

	protected Context context;

	protected RhinoContext rhinoContext;

	protected GameContext gameContext;

	protected NetworkController networkController;

	protected GameLog gameLog;

	public BasicGameController( Context context, GameLog gameLog ) {
		this.context = context;
		this.gameLog = gameLog;
	}

	@Override
	public void executeCard( int cardInGameId ) {
		Toast.makeText(context, "Executing card " + cardInGameId, Toast.LENGTH_SHORT).show();
	}

}
