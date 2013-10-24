package pl.edu.agh.colonialskirmish.activity;

import pl.edu.agh.colonialskirmish.R;
import android.app.TabActivity;
import android.os.Bundle;
import android.view.Menu;

public class ShowSpaceAreaActivity extends TabActivity {

	@Override
	protected void onCreate( Bundle savedInstanceState ) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_show_space_area);

	}

	@Override
	public boolean onCreateOptionsMenu( Menu menu ) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.show_space_area, menu);
		return true;
	}

}
