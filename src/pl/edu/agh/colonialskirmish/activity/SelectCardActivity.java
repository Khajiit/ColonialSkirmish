package pl.edu.agh.colonialskirmish.activity;

import java.util.List;

import pl.edu.agh.colonialskirmish.GameApplication;
import pl.edu.agh.colonialskirmish.R;
import pl.edu.agh.colonialskirmish.adapter.CardPagerAdapter;
import pl.edu.agh.colonialskirmish.db.DatabaseContext;
import pl.edu.agh.colonialskirmish.game.GameCard;
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
		DatabaseContext dbContext = new DatabaseContext(this);
		List<GameCard> cards = dbContext.loadCards();
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
}
