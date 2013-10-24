package pl.edu.agh.colonialskirmish.game;

import java.util.List;
import java.util.Map;

public class PlayerContext {

	protected int number;

	protected String name;

	/* Cards in players hand */
	protected List<Card> cards;

	/* Cards discarded (removed) from the game */
	protected List<Card> discardedCards;

	/*
	 * Every spaceship card may have other cards assigned with it (upgrades,
	 * units etc.)
	 */
	protected Map<Card, List<Card>> spaceAreaCards;

	public int getNumber() {
		return number;
	}

	public void setNumber( int number ) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName( String name ) {
		this.name = name;
	}

	public List<Card> getCards() {
		return cards;
	}

	public void setCards( List<Card> cards ) {
		this.cards = cards;
	}

	public List<Card> getDiscardedCards() {
		return discardedCards;
	}

	public void setDiscardedCards( List<Card> discardedCards ) {
		this.discardedCards = discardedCards;
	}

	public Map<Card, List<Card>> getSpaceAreaCards() {
		return spaceAreaCards;
	}

	public void setSpaceAreaCards( Map<Card, List<Card>> spaceAreaCards ) {
		this.spaceAreaCards = spaceAreaCards;
	}

}
