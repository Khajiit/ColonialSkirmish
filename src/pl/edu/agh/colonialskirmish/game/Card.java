package pl.edu.agh.colonialskirmish.game;

/**
 * Card listener used by game engine to get string with action script that
 * should be invoked on this particular event.
 * 
 * @author Khajiit
 * 
 */
public interface Card {

	/*********************************************************************************************/
	/************* Main listeners - always called ************************************************/
	/*********************************************************************************************/

	/**
	 * Called when the card is drawn from the deck
	 */
	public String getInitAction();

	/**
	 * Called when the card is being played
	 */
	public String getOnPlayAction();

	/**
	 * Called when the card is activated
	 */
	public String getOnActivateAction();

	/**
	 * Called when the card is being discarded from player's hand
	 */
	public String getOnDiscardAction();

	/**
	 * Called when card is played and is being removed from game
	 */
	public String getOnRemoveAction();

	/*********************************************************************************************/
	/************* Additional listeners - called when card registers itself for them *************/
	/*********************************************************************************************/

	public String getOnPlayerDrawsCardsAction();

	public String getOnEnemyDrawsCardsAction();

	public String getOnReceiveDamageAction();

	public String getOnNewTurnAction();

	/**
	 * Called when player discards some cards
	 */
	public String getOnCardDiscardedAction();

	/**
	 * Called when some cards are being removed from game area
	 */
	public String getOnCardRemovedAction();

	public String getOnEnemyUnitDestroyedAction();

	public String getOnFriendlyUnitDestroyedAction();

}
