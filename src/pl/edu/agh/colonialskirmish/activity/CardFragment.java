package pl.edu.agh.colonialskirmish.activity;

import pl.edu.agh.colonialskirmish.R;
import pl.edu.agh.colonialskirmish.game.Card;
import pl.edu.agh.colonialskirmish.game.CardType;
import pl.edu.agh.colonialskirmish.game.GameCard;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CardFragment extends Fragment {
	
	private GameCard card;

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState ) {

		View rootView = inflater.inflate(R.layout.fragment_card, container, false);
		TextView cardTitle = (TextView) rootView.findViewById(R.id.cardTitleLabel);
		TextView cardCost = (TextView) rootView.findViewById(R.id.cardCostLabel);
		TextView cardDescription = (TextView) rootView.findViewById(R.id.cardDescriptionText);
		TextView cardType = (TextView) rootView.findViewById(R.id.cardTypeLabel);
		
		cardTitle.setText(card.getName());
		cardCost.setText(String.valueOf(card.getCost()));
		cardDescription.setText(card.getDescription());
		cardType.setText( getTypeString(card) );
		
		return rootView;
	}

	public GameCard getCard() {
		return card;
	}

	public void setCard(GameCard card) {
		this.card = card;
	}

	private String getTypeString(GameCard card) {
		StringBuilder str = new StringBuilder("");
		
		CardType cardType = card.getMainType();
		if(cardType != null) {
			str.append(cardType.name());
			cardType = card.getSecondaryType();
			if(cardType != null) {
				str.append(" - ");
				str.append(cardType.name());
			}
		}
		
		return str.toString();
	}
	
}
