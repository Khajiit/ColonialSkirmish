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
	public void getInitAction();

	/**
	 * Called when the card is being played
	 */
	public void getOnPlayAction();

	/**
	 * Called when the card is activated
	 */
	public void getOnActivateAction();

	/**
	 * Called when the card is being discarded from player's hand
	 */
	public void getOnDiscardAction();

	/**
	 * Called when card is played and is being removed from game
	 */
	public void getOnRemoveAction();

	/*********************************************************************************************/
	/************* Additional listeners - called when card registers itself for them *************/
	/*********************************************************************************************/

	public void getOnPlayerDrawsCardsAction();

	public void getOnEnemyDrawsCardsAction();

	public void getOnReceiveDamageAction();

	public void getOnNewTurnAction();

	/**
	 * Called when player discards some cards
	 */
	public void getOnCardDiscardedAction();

	/**
	 * Called when some cards are being removed from game area
	 */
	public void getOnCardRemovedAction();

	public void getOnEnemyUnitDestroyedAction();

	public void getOnFriendlyUnitDestroyedAction();

}
