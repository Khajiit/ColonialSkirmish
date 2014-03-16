package pl.edu.agh.colonialskirmish.activity;

import java.util.ArrayList;

import pl.edu.agh.colonialskirmish.R;
import pl.edu.agh.colonialskirmish.game.GameCard;
import pl.edu.agh.colonialskirmish.test.util.CardMockUtil;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);
		getActionBar().hide();
		setContentView(R.layout.activity_main);
	}

	public void newGame( View view ) {
		Intent intent = new Intent(this, GameActivity.class);
		startActivity(intent);
	}

	public void addCards( View view ) {
		Intent intent = new Intent(this, LoadCardsActivity.class);

		intent.putExtra(LoadCardsActivity.EXTRA_CARDS,
				(ArrayList<GameCard>) CardMockUtil.getPlayerCards());

		startActivity(intent);
	}

}
