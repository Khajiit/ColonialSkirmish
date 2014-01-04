package pl.edu.agh.colonialskirmish.adapter;

import java.util.List;
import java.util.Map;

import pl.edu.agh.colonialskirmish.R;
import pl.edu.agh.colonialskirmish.game.Card;
import pl.edu.agh.colonialskirmish.game.GameCard;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ShipArrayAdapter extends BaseAdapter {

	private final Context context;
	private final Map<Card, List<Card>> cardMap;
	private final Card[] cards;

	public ShipArrayAdapter( Context context, Map<Card, List<Card>> cardMap ) {
		this.context = context;
		this.cardMap = cardMap;

		cards = new Card[cardMap.size()];
		int i = 0;
		for ( Card card : cardMap.keySet() ) {
			cards[i] = card;
			i++;
		}
	}

	@Override
	public int getCount() {
		return cardMap.size();
	}

	@Override
	public Object getItem( int i ) {
		return cards[i];
	}

	@Override
	public long getItemId( int arg0 ) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public View getView( int position, View arg1, ViewGroup viewGroup ) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View shipView = inflater.inflate(R.layout.fragment_ship_grid_item,
				viewGroup, false);

		ImageView image = (ImageView) shipView.findViewById(R.id.shipGridItemImage);
		image.setBackgroundResource(R.drawable.spaceship);
		
		TextView nameTextView = (TextView) shipView.findViewById(R.id.shipGridItemName);
		TextView kineticTextView = (TextView) shipView.findViewById(R.id.shipGridItemKinetic);
		TextView energyTextView = (TextView) shipView.findViewById(R.id.shipGridItemEnergy);
		TextView missleTextView = (TextView) shipView.findViewById(R.id.shipGridItemMissle);
		
		Card card = cards[position];
		try {
			GameCard gameCard = (GameCard) card;
			nameTextView.setText(gameCard.getName());
			kineticTextView.setText(gameCard.getKineticAtt() + "/" + gameCard.getKineticDef());
			energyTextView.setText(gameCard.getEnergyAtt() + "/" + gameCard.getEnergyDef());
			missleTextView.setText(gameCard.getMissleAtt() + "/" + gameCard.getMissleDef());
		} catch(ClassCastException e) {
			//TODO add logger
			e.printStackTrace();
		}
		

		return shipView;
	}

}
