package pl.edu.agh.colonialskirmish.activity;

import java.util.List;

import pl.edu.agh.colonialskirmish.GameApplication;
import pl.edu.agh.colonialskirmish.R;
import pl.edu.agh.colonialskirmish.adapter.CardPagerAdapter;
import pl.edu.agh.colonialskirmish.db.DatabaseContext;
import pl.edu.agh.colonialskirmish.game.GameCard;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Toast;

public class SelectCardActivity extends FragmentActivity {

	public static final int SELECT_CARD_REQUEST = 0;

	public static final String EXTRA_CARD_ID = "cardIndexKey";

	public static final String EXTRA_EXECUTED_ACTION = "cardExecutedActionKey";

	public static final String EXTRA_CARDS = "cards";

	private ViewPager viewPager;

	private PagerAdapter pagerAdapter;

	private List<GameCard> cards;

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);
		getActionBar().hide();
		setContentView(R.layout.activity_select_card);

		viewPager = (ViewPager) findViewById(R.id.cardPager);
		DatabaseContext dbContext = new DatabaseContext(this);
		Intent intent = getIntent();
		cards = (List<GameCard>) intent.getSerializableExtra(EXTRA_CARDS);
		// dbContext.loadCards(); // TODO: load this from game context
		pagerAdapter = new CardPagerAdapter(getSupportFragmentManager(), cards);
		viewPager.setAdapter(pagerAdapter);
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

	public void cardSelected( View view ) {
		Intent intent = new Intent();
		int index = viewPager.getCurrentItem();
		GameCard card = cards.get(index);
		intent.putExtra(EXTRA_CARD_ID, card.getInGameId());
		setResult(RESULT_OK, intent);
		finish();
	}

	public void showActionDialog( View view ) {
		int currentCardIndex = viewPager.getCurrentItem();
		GameCard currentCard = cards.get(currentCardIndex);
		Toast.makeText(this, "Clicked! " + viewPager.getCurrentItem(), Toast.LENGTH_SHORT).show();
	}
}
