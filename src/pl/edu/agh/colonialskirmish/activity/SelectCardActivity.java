package pl.edu.agh.colonialskirmish.activity;

import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.colonialskirmish.R;
import pl.edu.agh.colonialskirmish.adapter.CardPagerAdapter;
import pl.edu.agh.colonialskirmish.game.Card;
import pl.edu.agh.colonialskirmish.game.GameCard;
import pl.edu.agh.colonialskirmish.test.util.CardMockUtil;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;

public class SelectCardActivity extends FragmentActivity {

	private ViewPager viewPager;
	
	private PagerAdapter pagerAdapter;
	
	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);
		getActionBar().hide();
		setContentView(R.layout.activity_select_card);
		
		viewPager = (ViewPager) findViewById(R.id.cardPager);
		List<GameCard> cards = CardMockUtil.getPlayerCards();
		pagerAdapter = new CardPagerAdapter(getSupportFragmentManager(), cards);
		viewPager.setAdapter(pagerAdapter);
	}
}
