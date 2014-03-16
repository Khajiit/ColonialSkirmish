package pl.edu.agh.colonialskirmish.test.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import pl.edu.agh.colonialskirmish.game.Card;
import pl.edu.agh.colonialskirmish.game.CardType;
import pl.edu.agh.colonialskirmish.game.GameCard;

public class CardMockUtil {

	static Random random = new Random();

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
		card.setSecondaryType(CardType.NONE);

		return card;
	}

	public static Card mockShipCard( String name ) {
		GameCard card = new GameCard();
		card.setName(name);
		card.setMainType(CardType.SHIP);
		card.setSecondaryType(CardType.SHIP_BATTLE_SHIP);
		card.setKineticAtt(random.nextInt(8));
		card.setKineticDef(random.nextInt(8));

		card.setEnergyAtt(random.nextInt(8));
		card.setEnergyDef(random.nextInt(8));

		card.setMissleAtt(random.nextInt(8));
		card.setMissleDef(random.nextInt(8));

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

	public static Map<Card, List<Card>> getShipCards2() {
		Map<Card, List<Card>> shipCards = new HashMap<Card, List<Card>>();
		Card card1 = mockShipCard("Enterprise");
		Card card2 = mockShipCard("Voyager");
		Card card3 = mockShipCard("Millenium Falcon");

		shipCards.put(card1, Collections.<Card> emptyList());
		shipCards.put(card2, Collections.<Card> emptyList());
		shipCards.put(card3, Collections.<Card> emptyList());

		return shipCards;
	}

	public static List<GameCard> getPlayerCards() {
		List<GameCard> cards = new ArrayList<GameCard>();

		GameCard card1 = (GameCard) mockShipCard("Enterprise");
		card1.setId(1);
		GameCard card2 = (GameCard) mockShipCard("Voyager");
		card2.setId(2);
		GameCard card3 = (GameCard) mockShipCard("Millenium Falcon");
		card3.setId(3);
		GameCard card4 = (GameCard) mockPlanetCard("Earth");
		card4.setId(4);

		cards.add((GameCard) card1);
		cards.add((GameCard) card2);
		cards.add((GameCard) card3);
		cards.add((GameCard) card4);

		return cards;
	}
}
