package pl.edu.agh.colonialskirmish.activity;

import java.io.File;

import pl.edu.agh.colonialskirmish.R;
import pl.edu.agh.colonialskirmish.game.CardType;
import pl.edu.agh.colonialskirmish.game.GameCard;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

public class CardFragment extends Fragment {

	private GameCard card;

	@Override
	public View onCreateView( LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState ) {

		View rootView = inflater.inflate(R.layout.fragment_card, container, false);
		TextView cardTitle = (TextView) rootView.findViewById(R.id.cardTitleLabel);
		TextView cardCost = (TextView) rootView.findViewById(R.id.cardCostLabel);
		TextView cardDescription = (TextView) rootView.findViewById(R.id.cardDescriptionText);
		TextView cardType = (TextView) rootView.findViewById(R.id.cardTypeLabel);
		GridLayout gridLayout = (GridLayout) rootView.findViewById(R.id.cardBackgroundGridLayout);

		cardTitle.setText(card.getName());
		cardCost.setText(String.valueOf(card.getCost()));
		// cardDescription.setText(card.getDescription());
		cardType.setText(getTypeString(card));

		// get file from storage
		String filePath = getActivity().getExternalFilesDir(null).getAbsolutePath();
		filePath += File.separator + card.getImagePath();
		Log.i("CardFragment", "FilePath for this card is " + filePath);
		BitmapFactory.Options options = new BitmapFactory.Options();
		options.inPreferredConfig = Bitmap.Config.ARGB_8888;
		Bitmap bitmap = BitmapFactory.decodeFile(filePath, options);

		// Convert it to drawable
		BitmapDrawable drawable = new BitmapDrawable(getActivity().getResources(), bitmap);
		gridLayout.setBackground(drawable);

		// create actions of this card
		LinearLayout linearLayout = (LinearLayout) rootView
				.findViewById(R.id.cardActionsLinearLayout);
		Button executeBtn = new Button(getActivity());
		executeBtn.setText("U¿yj karty");
		executeBtn.setLayoutParams(new LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
				ViewGroup.LayoutParams.WRAP_CONTENT));
		executeBtn.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick( View v ) {
				((SelectCardActivity) getActivity()).cardSelected(v);
			}
		});
		linearLayout.addView(executeBtn);

		return rootView;
	}

	public GameCard getCard() {
		return card;
	}

	public void setCard( GameCard card ) {
		this.card = card;
	}

	private String getTypeString( GameCard card ) {
		StringBuilder str = new StringBuilder("");

		CardType cardType = card.getMainType();
		if ( cardType != null ) {
			str.append(cardType.name());
			cardType = card.getSecondaryType();
			if ( cardType != null ) {
				str.append(" - ");
				str.append(cardType.name());
			}
		}

		return str.toString();
	}

}
