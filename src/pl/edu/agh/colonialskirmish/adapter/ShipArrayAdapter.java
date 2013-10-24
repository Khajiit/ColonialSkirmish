package pl.edu.agh.colonialskirmish.adapter;

import java.util.List;
import java.util.Map;

import pl.edu.agh.colonialskirmish.R;
import pl.edu.agh.colonialskirmish.game.Card;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

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

		shipView.setBackgroundResource(R.drawable.spaceship);

		return shipView;
	}

}
