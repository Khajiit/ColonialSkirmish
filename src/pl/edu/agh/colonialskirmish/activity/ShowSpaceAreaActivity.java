package pl.edu.agh.colonialskirmish.activity;

import pl.edu.agh.colonialskirmish.GameApplication;
import pl.edu.agh.colonialskirmish.R;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.view.Menu;

public class ShowSpaceAreaActivity extends FragmentActivity {

	private FragmentTabHost tabHost;

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_space_area);

		setupTabs();
	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu ) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_space_area, menu);
		return true;
	}

	private void setupTabs() {
		Bundle bundleMyTab = new Bundle();
		bundleMyTab.putInt(SelectShipActivity.PARAM_SHIPS_TO_SHOW_KEY, 0);

		Bundle bundleEnemyTab = new Bundle();
		bundleEnemyTab.putInt(SelectShipActivity.PARAM_SHIPS_TO_SHOW_KEY, 1);

		tabHost = (FragmentTabHost) findViewById(R.id.shipTabHost);
		tabHost.setup(this, getSupportFragmentManager(), R.id.shipTabContent);
		tabHost.addTab(tabHost.newTabSpec("Moje").setIndicator("Moje"), SelectShipActivity.class,
				bundleMyTab);
		tabHost.addTab(tabHost.newTabSpec("Przeciwnika").setIndicator("Przeciwnika"),
				SelectShipActivity.class, bundleEnemyTab);
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
