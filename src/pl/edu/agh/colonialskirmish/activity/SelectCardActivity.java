package pl.edu.agh.colonialskirmish.activity;

import pl.edu.agh.colonialskirmish.R;
import android.app.Activity;
import android.os.Bundle;

public class SelectCardActivity extends Activity {

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);
		getActionBar().hide();
		setContentView(R.layout.activity_show_card);
	}
}
