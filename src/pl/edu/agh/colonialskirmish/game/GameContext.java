package pl.edu.agh.colonialskirmish.game;

import java.util.List;
import java.util.Map;
import java.util.Queue;

public class GameContext {

	/* List of player contexts */
	protected List<PlayerContext> players;

	/*
	 * Every planet card may have other cards assigned with it (upgrades, units
	 * etc.)
	 */
	protected Map<Card, List<Card>> planetCards;

	protected int turnNumber;

	/* After completing turn active player is added to the end of the queue */
	protected Queue<PlayerContext> turnQueue;

	public List<PlayerContext> getPlayers() {
		return players;
	}

	public void setPlayers( List<PlayerContext> players ) {
		this.players = players;
	}

	public Map<Card, List<Card>> getPlanetCards() {
		return planetCards;
	}

	public void setPlanetCards( Map<Card, List<Card>> planetCards ) {
		this.planetCards = planetCards;
	}

	public int getTurnNumber() {
		return turnNumber;
	}

	public void setTurnNumber( int turnNumber ) {
		this.turnNumber = turnNumber;
	}

	public Queue<PlayerContext> getTurnQueue() {
		return turnQueue;
	}

	public void setTurnQueue( Queue<PlayerContext> turnQueue ) {
		this.turnQueue = turnQueue;
	}

	public void onTerminate() {

	}

}
