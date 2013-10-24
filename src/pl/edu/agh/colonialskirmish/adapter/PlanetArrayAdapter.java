package pl.edu.agh.colonialskirmish.adapter;

import java.util.List;
import java.util.Map.Entry;

import pl.edu.agh.colonialskirmish.R;
import pl.edu.agh.colonialskirmish.game.Card;
import pl.edu.agh.colonialskirmish.game.GameCard;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * This is an adapter for ListView of planet cards. There is an Entry object
 * associated with each planet. Key (Card) is a card planet, value (List<Card>)
 * is list with cards related to the planet cards (upgrades, units etc.). This
 * list is used to compute planet summary info.
 * 
 * @author Khajiit
 * 
 */
public class PlanetArrayAdapter extends ArrayAdapter<Entry<Card, List<Card>>> {

	private final Context context;
	private final Entry<Card, List<Card>>[] cardEntries;

	public PlanetArrayAdapter( Context context,
			Entry<Card, List<Card>>[] cardEntries ) {
		super(context, R.layout.fragment_planet_list_item, cardEntries);
		this.context = context;
		this.cardEntries = cardEntries;
	}

	@Override
	public View getView( int position, View convertView, ViewGroup parent ) {
		LayoutInflater inflater = (LayoutInflater) context
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		View rowView = inflater.inflate(R.layout.fragment_planet_list_item,
				parent, false);

		TextView nameView = (TextView) rowView.findViewById(R.id.planetName);
		TextView descriptionView = (TextView) rowView
				.findViewById(R.id.planetDescription);

		Card card = cardEntries[position].getKey();
		nameView.setText(((GameCard) card).getName());
		descriptionView.setText("0/0/0");

		return rowView;
	}
}
