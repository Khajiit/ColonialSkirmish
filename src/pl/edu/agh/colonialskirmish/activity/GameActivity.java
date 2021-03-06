package pl.edu.agh.colonialskirmish.activity;

import java.util.ArrayList;

import pl.edu.agh.colonialskirmish.GameApplication;
import pl.edu.agh.colonialskirmish.R;
import pl.edu.agh.colonialskirmish.db.DatabaseContext;
import pl.edu.agh.colonialskirmish.game.GameCard;
import pl.edu.agh.colonialskirmish.game.GameContext;
import pl.edu.agh.colonialskirmish.game.GameController;
import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class GameActivity extends BaseGameActivity {

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		// Show the Up button in the action bar.
		setupActionBar();
	}

	@Override
	protected void onStart() {
		super.onStart();
		// Send initial messages
		GameApplication app = (GameApplication) getApplication();
		app.getNetworkController().connect();
	}

	@Override
	protected void onStop() {
		GameApplication app = (GameApplication) getApplication();
		app.getNetworkController().disconnect();
		super.onStop();
	}

	@Override
	protected void onResume() {
		refreshView();
		super.onResume();
	}

	private void refreshView() {
		TextView gameLogView = (TextView) this.findViewById(R.id.gameLog);
		GameApplication app = (GameApplication) this.getApplication();
		gameLogView.setText(app.getGameLog().toString());
	}

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi ( Build.VERSION_CODES.HONEYCOMB )
	private void setupActionBar() {
		if ( Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB ) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu ) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.game, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected( MenuItem item ) {
		switch ( item.getItemId() ) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		case R.id.action_show_hand:
			showCard();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	protected void onActivityResult( int requestCode, int resultCode, Intent data ) {
		if ( requestCode == SelectCardActivity.SELECT_CARD_REQUEST ) {
			Log.d("onActivityResult", "Received select card activity result with code "
					+ requestCode);
			if ( resultCode == RESULT_OK ) {
				int cardInGameId = data.getIntExtra(SelectCardActivity.EXTRA_CARD_ID, -1);
				String chosenAction = data.getStringExtra(SelectCardActivity.EXTRA_EXECUTED_ACTION);
				GameApplication app = (GameApplication) getApplication();
				GameController gameController = app.getGameController();
				gameController.executeCard(cardInGameId, chosenAction);
			}
		}
	}

	public void showCard() {
		Intent intent = new Intent(this, SelectCardActivity.class);
		DatabaseContext dbContext = new DatabaseContext(this);
		ArrayList<GameCard> cards = (ArrayList<GameCard>) dbContext.loadCards();
		// FIXME: temporary adding cards to GameCOntext here - this should be
		// removed in the future
		GameApplication app = (GameApplication) getApplication();
		GameContext gameContext = app.getGameController().getGameContext();
		for ( GameCard card : cards ) {
			gameContext.getAllCardsCacheMap().put(card.getInGameId(), card);
		}
		intent.putExtra(SelectCardActivity.EXTRA_CARDS, cards);
		startActivityForResult(intent, SelectCardActivity.SELECT_CARD_REQUEST);
	}

	public void showPlanets( View view ) {
		Intent intent = new Intent(this, SelectPlanetActivity.class);
		startActivity(intent);
	}

	public void showShips( View view ) {
		Intent intent = new Intent(this, ShowSpaceAreaActivity.class);
		startActivity(intent);
	}

}
