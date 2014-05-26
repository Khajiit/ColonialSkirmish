package pl.edu.agh.colonialskirmish.activity;

import java.util.List;
import java.util.Map;

import pl.edu.agh.colonialskirmish.GameApplication;
import pl.edu.agh.colonialskirmish.R;
import pl.edu.agh.colonialskirmish.adapter.ShipArrayAdapter;
import pl.edu.agh.colonialskirmish.game.Card;
import pl.edu.agh.colonialskirmish.test.util.CardMockUtil;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

public class SelectShipActivity extends Fragment {

	public static final String PARAM_SHIPS_TO_SHOW_KEY = "key.selectShipActivity.ships.to.show";

	// @Override
	// public void onCreate( Bundle savedInstanceState ) {
	// super.onCreate(savedInstanceState);
	// setContentView(R.layout.activity_select_ship);
	//
	// GridView gridView = (GridView) findViewById(R.id.shipGridview);
	// Map<Card, List<Card>> cardMap = CardMockUtil.getShipCards();
	// ShipArrayAdapter shipArrayAdapter = new ShipArrayAdapter(
	// getApplicationContext(), cardMap);
	// gridView.setAdapter(shipArrayAdapter);
	// }

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState ) {
		View rootView = inflater.inflate(R.layout.activity_select_ship, container, false);

		int shipTypeToShow = getArguments().getInt(PARAM_SHIPS_TO_SHOW_KEY);

		GridView gridView = (GridView) rootView.findViewById(R.id.shipGridview);
		GameApplication app = (GameApplication) getActivity().getApplication();
		Map<Card, List<Card>> cardMap = app.getGameContext().getPlayers().get(0)
				.getSpaceAreaCards();
		if ( shipTypeToShow == 0 ) {
			cardMap = CardMockUtil.getShipCards();
		} else {
			cardMap = CardMockUtil.getShipCards2();
		}
		ShipArrayAdapter shipArrayAdapter = new ShipArrayAdapter(getActivity(), cardMap);
		gridView.setAdapter(shipArrayAdapter);

		return rootView;
	}

	public Map<Card, List<Card>> getShipCards() {
		return null;
	}

}
