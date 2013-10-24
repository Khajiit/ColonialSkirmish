package pl.edu.agh.colonialskirmish.test.util;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pl.edu.agh.colonialskirmish.game.Card;
import pl.edu.agh.colonialskirmish.game.CardType;
import pl.edu.agh.colonialskirmish.game.GameCard;

public class CardMockUtil {

	public static Map<Card, List<Card>> getPlanetCards() {
		Map<Card, List<Card>> planetCards = new HashMap<Card, List<Card>>();
		Card card1 = mockPlanetCard("Earth");
		Card card2 = mockPlanetCard("Mars");

		planetCards.put(card1, Collections.<Card> emptyList());
		planetCards.put(card2, Collections.<Card> emptyList());

		return planetCards;
	}

	public static Card mockPlanetCard( String name ) {
		GameCard card = new GameCard();
		card.setName(name);
		card.setMainType(CardType.PLANET);

		return card;
	}

	public static Card mockShipCard( String name ) {
		GameCard card = new GameCard();
		card.setName(name);
		card.setMainType(CardType.SHIP);

		return card;
	}

	public static Map<Card, List<Card>> getShipCards() {
		Map<Card, List<Card>> shipCards = new HashMap<Card, List<Card>>();
		Card card1 = mockShipCard("Enterprise");
		Card card2 = mockShipCard("Voyager");

		shipCards.put(card1, Collections.<Card> emptyList());
		shipCards.put(card2, Collections.<Card> emptyList());

		return shipCards;
	}
}
