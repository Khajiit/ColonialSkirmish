package pl.edu.agh.colonialskirmish.activity;

import java.util.List;
import java.util.Map;

import pl.edu.agh.colonialskirmish.R;
import pl.edu.agh.colonialskirmish.adapter.ShipArrayAdapter;
import pl.edu.agh.colonialskirmish.game.Card;
import pl.edu.agh.colonialskirmish.test.util.CardMockUtil;
import android.app.Activity;
import android.os.Bundle;
import android.widget.GridView;

public class SelectShipActivity extends Activity {

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_select_ship);

		GridView gridView = (GridView) findViewById(R.id.shipGridview);
		Map<Card, List<Card>> cardMap = CardMockUtil.getShipCards();
		ShipArrayAdapter shipArrayAdapter = new ShipArrayAdapter(
				getApplicationContext(), cardMap);
		gridView.setAdapter(shipArrayAdapter);
	}

}
