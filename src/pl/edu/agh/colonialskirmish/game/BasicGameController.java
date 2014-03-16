package pl.edu.agh.colonialskirmish.game;

import pl.edu.agh.colonialskirmish.rhino.RhinoContext;
import android.content.Context;

public class BasicGameController implements GameController {

	protected Context context;

	protected RhinoContext rhinoContext;

	protected GameContext gameContext;

	public BasicGameController( Context context ) {
		this.context = context;
	}

}
