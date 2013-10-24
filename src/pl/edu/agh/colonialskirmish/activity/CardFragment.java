package pl.edu.agh.colonialskirmish.activity;

import pl.edu.agh.colonialskirmish.R;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class CardFragment extends Fragment {

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState ) {

		return inflater.inflate(R.layout.fragment_card, container, false);
	}
}
