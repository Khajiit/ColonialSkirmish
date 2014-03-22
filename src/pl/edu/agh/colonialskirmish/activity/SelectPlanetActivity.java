package pl.edu.agh.colonialskirmish.activity;

import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import pl.edu.agh.colonialskirmish.GameApplication;
import pl.edu.agh.colonialskirmish.R;
import pl.edu.agh.colonialskirmish.adapter.PlanetArrayAdapter;
import pl.edu.agh.colonialskirmish.game.Card;
import pl.edu.agh.colonialskirmish.test.util.CardMockUtil;
import android.app.Activity;
import android.app.ListActivity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ArrayAdapter;

public class SelectPlanetActivity extends ListActivity {

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);

		Map<Card, List<Card>> cards = CardMockUtil.getPlanetCards();
		// Magic everywhere.. just to obtain array of entries associating planet
		// cards with cards related to them
		Set<Entry<Card, List<Card>>> entries = cards.entrySet();
		Entry<Card, List<Card>>[] cardEntries = (Entry<Card, List<Card>>[]) new Entry[entries
				.size()];
		entries.toArray(cardEntries);

		// finally instantiate adapter fo ListView
		ArrayAdapter<Entry<Card, List<Card>>> adapter = new PlanetArrayAdapter(
				getApplicationContext(), cardEntries);
		setListAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu ) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.select_planet, menu);
		return true;
	}

	@Override
	protected void onDestroy() {
		clearReferences();
		super.onDestroy();
	}

	@Override
	protected void onPause() {
		clearReferences();
		super.onPause();
	}

	@Override
	protected void onResume() {
		super.onResume();
		GameApplication app = (GameApplication) getApplication();
		app.setCurrentActivity(this);
	}

	protected void clearReferences() {
		GameApplication app = (GameApplication) getApplication();
		Activity activity = app.getCurrentActivity();
		if ( this.equals(activity) ) {
			app.setCurrentActivity(null);
		}
	}

}
