package pl.edu.agh.colonialskirmish.game;

public interface GameController {

	void executeCard( int cardInGameId, String chosenAction );

	GameContext getGameContext();

}
