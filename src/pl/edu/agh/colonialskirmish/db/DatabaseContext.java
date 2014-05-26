package pl.edu.agh.colonialskirmish.db;

import java.util.ArrayList;
import java.util.List;

import pl.edu.agh.colonialskirmish.game.CardAction;
import pl.edu.agh.colonialskirmish.game.CardType;
import pl.edu.agh.colonialskirmish.game.GameCard;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class DatabaseContext {

	GameSQLiteHelper dbHelper;

	Context context;

	public DatabaseContext( Context context ) {
		dbHelper = new GameSQLiteHelper(context);
		this.context = context;
	}

	public List<GameCard> loadCards() {
		Log.i("DatabaseContex", "loading cards...");
		List<GameCard> cards = new ArrayList<GameCard>();

		SQLiteDatabase db = dbHelper.getWritableDatabase();
		Cursor cursor = db.query(dbHelper.DECK_TABLE_NAME, null, null, null, null, null, null);
		if ( cursor.moveToFirst() ) {
			do {
				GameCard card = loadCard(cursor);
				cards.add(card);
			} while ( cursor.moveToNext() );
		}
		db.close();

		return cards;
	}

	private GameCard loadCard( Cursor cursor ) {
		GameCard card = new GameCard();

		card.setName(cursor.getString(cursor.getColumnIndex(dbHelper.COLUMN_CARD_NAME)));
		card.setDescription(cursor.getString(cursor
				.getColumnIndex(dbHelper.COLUMN_CARD_DESCRIPTION)));
		card.setCost(cursor.getInt(cursor.getColumnIndex(dbHelper.COLUMN_CARD_COST)));

		int intValue = cursor.getInt(cursor.getColumnIndex(dbHelper.COLUMN_CARD_KINETIC_ATT));
		card.setBasicKineticAtt(intValue);
		card.setKineticAtt(intValue);

		intValue = cursor.getInt(cursor.getColumnIndex(dbHelper.COLUMN_CARD_KINETIC_DEF));
		card.setBasicKineticDef(intValue);
		card.setKineticDef(intValue);

		intValue = cursor.getInt(cursor.getColumnIndex(dbHelper.COLUMN_CARD_ENERGY_ATT));
		card.setBasicEnergyAtt(intValue);
		card.setEnergyAtt(intValue);

		intValue = cursor.getInt(cursor.getColumnIndex(dbHelper.COLUMN_CARD_ENERGY_DEF));
		card.setBasicEnergyDef(intValue);
		card.setEnergyDef(intValue);

		intValue = cursor.getInt(cursor.getColumnIndex(dbHelper.COLUMN_CARD_MISSLE_ATT));
		card.setBasicMissleAtt(intValue);
		card.setMissleAtt(intValue);

		intValue = cursor.getInt(cursor.getColumnIndex(dbHelper.COLUMN_CARD_MISSLE_DEF));
		card.setBasicMissleDef(intValue);
		card.setMissleDef(intValue);

		intValue = cursor.getInt(cursor.getColumnIndex(dbHelper.COLUMN_CARD_HEALTH));
		card.setBasicHealth(intValue);
		card.setHealth(intValue);

		String strValue = cursor.getString(cursor.getColumnIndex(dbHelper.COLUMN_CARD_MAIN_TYPE));
		card.setMainType(CardType.valueOf(strValue));

		strValue = cursor.getString(cursor.getColumnIndex(dbHelper.COLUMN_CARD_SECONDARY_TYPE));
		card.setSecondaryType(CardType.valueOf(strValue));

		strValue = cursor.getString(cursor.getColumnIndex(dbHelper.COLUMN_CARD_IMAGE_PATH));
		card.setImagePath(strValue);

		intValue = cursor.getInt(cursor.getColumnIndex(dbHelper.COLUMN_ID));
		card.setId(intValue);

		intValue = cursor.getInt(cursor.getColumnIndex(dbHelper.COLUMN_VERSION));
		card.setVersion(intValue);

		String cardActions = cursor.getString(cursor
				.getColumnIndex(dbHelper.COLUMN_CARD_ACTION_LIST));
		String cardActionsDsc = cursor.getString(cursor
				.getColumnIndex(dbHelper.COLUMN_CARD_ACTION_DESC_LIST));
		card.setCardActionList(loadCardActionList(cardActions, cardActionsDsc));

		return card;
	}

	/**
	 * Create list of card actions from two strings
	 * 
	 * @param cardActions
	 *            card actions separated by dbHelper.ACTION_SEPARATOR
	 * @param cardActionsDsc
	 *            card action descriptions separated by
	 *            dbHelper.ACTION_SEPARATOR
	 * @return
	 */
	private List<CardAction> loadCardActionList( String cardActions, String cardActionsDsc ) {
		List<CardAction> cardActionList = new ArrayList<CardAction>();

		if ( cardActions != null && cardActionsDsc != null ) {
			String[] actionNames = cardActions.split(dbHelper.ACTION_SEPARATOR);
			String[] actionDsc = cardActionsDsc.split(dbHelper.ACTION_SEPARATOR);

			if ( actionNames.length != actionDsc.length ) {
				Log.e("loadCardActionList", "Number of actions " + actionNames.length
						+ " is different than number of descriptions! " + actionDsc.length);
			}

			for ( int i = 0; i < actionNames.length; i++ ) {
				cardActionList.add(new CardAction(actionNames[i], actionDsc[i]));
			}
		}

		return cardActionList;
	}

	public void addCard( GameCard card ) {
		SQLiteDatabase db = dbHelper.getWritableDatabase();

		ContentValues values = new ContentValues();
		values.put(dbHelper.COLUMN_ID, card.getId());
		values.put(dbHelper.COLUMN_CARD_COST, card.getCost());
		values.put(dbHelper.COLUMN_CARD_DESCRIPTION, card.getDescription());
		values.put(dbHelper.COLUMN_CARD_ENERGY_ATT, card.getEnergyAtt());
		values.put(dbHelper.COLUMN_CARD_ENERGY_DEF, card.getEnergyDef());
		values.put(dbHelper.COLUMN_CARD_HEALTH, card.getHealth());
		values.put(dbHelper.COLUMN_CARD_IMAGE_PATH, card.getImagePath());
		values.put(dbHelper.COLUMN_CARD_KINETIC_ATT, card.getKineticAtt());
		values.put(dbHelper.COLUMN_CARD_KINETIC_DEF, card.getKineticDef());
		values.put(dbHelper.COLUMN_CARD_MAIN_TYPE, card.getMainType().name());
		values.put(dbHelper.COLUMN_CARD_SECONDARY_TYPE, card.getSecondaryType().name());
		values.put(dbHelper.COLUMN_CARD_MISSLE_ATT, card.getMissleAtt());
		values.put(dbHelper.COLUMN_CARD_MISSLE_DEF, card.getMissleDef());
		values.put(dbHelper.COLUMN_CARD_NAME, card.getName());
		values.put(dbHelper.COLUMN_VERSION, card.getVersion());
		serializeCardActions(values, card);

		db.insert(dbHelper.DECK_TABLE_NAME, null, values);
		db.close();
	}

	private void serializeCardActions( ContentValues values, GameCard card ) {
		List<CardAction> cardActions = card.getCardActionList();
		StringBuilder actionNames = new StringBuilder();
		StringBuilder actionDescriptions = new StringBuilder();
		boolean firstActionAdded = false;

		for ( CardAction action : cardActions ) {
			if ( firstActionAdded ) {
				actionNames.append(dbHelper.ACTION_SEPARATOR);
				actionDescriptions.append(dbHelper.ACTION_SEPARATOR);
			}
			actionNames.append(action.getActionName());
			actionDescriptions.append(action.getActionDescription());
		}

		values.put(dbHelper.COLUMN_CARD_ACTION_LIST, actionNames.toString());
		values.put(dbHelper.COLUMN_CARD_ACTION_DESC_LIST, actionDescriptions.toString());
	}

	public void dropTable() {
		SQLiteDatabase db = dbHelper.getWritableDatabase();
		// db.delete(dbHelper.DECK_TABLE_NAME, null, null);
		// db.execSQL("DROP TABLE " + dbHelper.DECK_TABLE_NAME);
		dbHelper.onCreate(db);
	}

}
