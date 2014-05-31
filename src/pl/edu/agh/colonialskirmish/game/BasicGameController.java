package pl.edu.agh.colonialskirmish.game;

import java.util.HashMap;
import java.util.Map;

import pl.edu.agh.colonialskirmish.network.NetworkController;
import pl.edu.agh.colonialskirmish.rhino.RhinoContext;
import pl.edu.agh.colonialskirmish.util.GameLog;
import android.content.Context;

public class BasicGameController implements GameController {

	protected Context context;

	protected RhinoContext rhinoContext;

	protected GameContext gameContext = new GameContext();

	protected NetworkController networkController;

	protected GameLog gameLog;

	public BasicGameController( Context context, GameLog gameLog ) {
		this.context = context;
		this.gameLog = gameLog;
	}

	/**
	 * Execute apropriate action of the card and bind this card under name
	 * "thisCard" in Rhino context
	 */
	@Override
	public void executeCard( int cardInGameId, String chosenAction ) {
		GameCard card = (GameCard) gameContext.getCard(cardInGameId);
		String script = "";
		String scriptId = card.getName() + " #" + card.getId();
		if ( CardAction.USE_ACTION.equals(chosenAction) ) {
			if ( CardLocation.HAND.equals(card.getCardLocation()) ) {
				script = card.getOnPlayAction();
			} else {
				script = card.getOnActivateAction();
			}
		} else {
			script = card.getOnActionUsedAction();
		}

		Map<String, Object> additionalVariables = new HashMap<String, Object>();
		additionalVariables.put("thisCard", card);

		rhinoContext.execute(script, scriptId, additionalVariables);
	}

	@Override
	public GameContext getGameContext() {
		return gameContext;
	}

	public void setRhinoContext( RhinoContext rhinoContext ) {
		this.rhinoContext = rhinoContext;
	}

}
