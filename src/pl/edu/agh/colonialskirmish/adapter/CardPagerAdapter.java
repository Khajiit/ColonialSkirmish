package pl.edu.agh.colonialskirmish.adapter;

import java.util.List;

import pl.edu.agh.colonialskirmish.activity.CardFragment;
import pl.edu.agh.colonialskirmish.game.GameCard;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class CardPagerAdapter extends FragmentStatePagerAdapter {

	List<GameCard> cards; // TODO initialize this

	public CardPagerAdapter( FragmentManager fm, List<GameCard> cards ) {
		super(fm);
		this.cards = cards;
	}

	@Override
	public Fragment getItem( int position ) {
		CardFragment cardFragment = new CardFragment();
		cardFragment.setCard(cards.get(position));
		return cardFragment;
	}

	@Override
	public int getCount() {
		return cards.size();
	}

	public List<GameCard> getCards() {
		return cards;
	}

}
