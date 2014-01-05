package pl.edu.agh.colonialskirmish.game;

import android.content.Context;
import pl.edu.agh.colonialskirmish.db.DatabaseContext;
import pl.edu.agh.colonialskirmish.rhino.RhinoContext;

public class BasicGameController implements GameController {

	protected Context context;
	
	protected RhinoContext rhinoContext;
	
	protected GameContext gameContext;
	
	protected DatabaseContext databaseContext;
	
	public BasicGameController(Context context) {
		this.context = context;
	}
	
}
