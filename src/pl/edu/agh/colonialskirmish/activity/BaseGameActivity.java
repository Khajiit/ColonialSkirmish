package pl.edu.agh.colonialskirmish.activity;

import pl.edu.agh.colonialskirmish.GameApplication;
import android.app.Activity;
import android.os.Bundle;

public class BaseGameActivity extends Activity {

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);
		GameApplication app = (GameApplication) getApplication();
		app.setCurrentActivity(this);
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
