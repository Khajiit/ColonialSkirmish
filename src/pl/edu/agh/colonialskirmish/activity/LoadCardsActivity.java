package pl.edu.agh.colonialskirmish.activity;

import java.util.List;

import pl.edu.agh.colonialskirmish.R;
import pl.edu.agh.colonialskirmish.db.DatabaseContext;
import pl.edu.agh.colonialskirmish.game.GameCard;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.Menu;
import android.widget.ProgressBar;

public class LoadCardsActivity extends Activity {

	public final static String EXTRA_CARDS = "newCards";

	private ProgressBar progressBar;

	private Handler handler = new Handler();

	private volatile int progressStatus = 0;

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);
		getActionBar().hide();
		setContentView(R.layout.activity_load_cards);

		progressBar = (ProgressBar) findViewById(R.id.loadCardsProgressBar);

		new Thread(new Runnable() {

			@Override
			public void run() {
				loadCards(getIntent());
			}
		}).start();
	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu ) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.load_cards, menu);
		return false;
	}

	private void loadCards( Intent intent ) {
		Log.i("LoadCardsActivity", "Loading cards...");
		List<GameCard> cards = (List<GameCard>) intent.getSerializableExtra(EXTRA_CARDS);
		DatabaseContext dbContext = new DatabaseContext(this);
		int progressUpdateValue = 100 / cards.size();
		for ( GameCard card : cards ) {
			Log.i("LoadCardsActivity", "Loading card " + card);
			dbContext.addCard(card);
			postProgress(progressStatus + progressUpdateValue);
		}
		postProgress(100);
	}

	private void postProgress( final int newProgress ) {
		handler.post(new Runnable() {

			@Override
			public void run() {
				progressBar.setProgress(newProgress);
			}
		});
	}

}
