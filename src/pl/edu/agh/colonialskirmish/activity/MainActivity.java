package pl.edu.agh.colonialskirmish.activity;

import pl.edu.agh.colonialskirmish.R;
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

}
