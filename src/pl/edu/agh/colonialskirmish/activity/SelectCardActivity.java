package pl.edu.agh.colonialskirmish.activity;

import java.util.List;

import pl.edu.agh.colonialskirmish.R;
import pl.edu.agh.colonialskirmish.adapter.CardPagerAdapter;
import pl.edu.agh.colonialskirmish.game.GameCard;
import pl.edu.agh.colonialskirmish.test.util.CardMockUtil;
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

		// Bitmap bitmap = BitmapFactory.decodeResource(getResources(),
		// R.drawable.spaceship);
		// String filePath = getExternalFilesDir(null).getAbsolutePath();
		//
		// File file = new File(filePath, "spaceship.jpg");
		// if ( !file.exists() ) {
		// FileOutputStream fileOutputStream = null;
		// try {
		// fileOutputStream = new FileOutputStream(file);
		// bitmap.compress(Bitmap.CompressFormat.JPEG, 100,
		// fileOutputStream);
		// fileOutputStream.flush();
		// } catch ( Exception e ) {
		// e.printStackTrace();
		// } finally {
		// try {
		// if ( fileOutputStream != null ) {
		// fileOutputStream.close();
		// }
		// } catch ( IOException e ) {
		// e.printStackTrace();
		// }
		// }
		// }

		viewPager = (ViewPager) findViewById(R.id.cardPager);
		List<GameCard> cards = CardMockUtil.getPlayerCards();
		pagerAdapter = new CardPagerAdapter(getSupportFragmentManager(), cards);
		viewPager.setAdapter(pagerAdapter);
	}
}
