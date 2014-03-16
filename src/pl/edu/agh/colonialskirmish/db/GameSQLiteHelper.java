package pl.edu.agh.colonialskirmish.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class GameSQLiteHelper extends SQLiteOpenHelper {

	public static final int DB_VER = 1;

	public static final String DB_NAME = "carddeck.db";

	public static final String DECK_TABLE_NAME = "deck";

	public static final String COLUMN_ID = "id";

	public static final String COLUMN_VERSION = "ver";

	public static final String COLUMN_CARD_NAME = "name";

	public static final String COLUMN_CARD_MAIN_TYPE = "mainType";

	public static final String COLUMN_CARD_SECONDARY_TYPE = "secondaryType";

	public static final String COLUMN_CARD_COST = "cost";

	public static final String COLUMN_CARD_HEALTH = "health";

	public static final String COLUMN_CARD_KINETIC_ATT = "kineticAtt";

	public static final String COLUMN_CARD_KINETIC_DEF = "kineticDef";

	public static final String COLUMN_CARD_ENERGY_ATT = "energyAtt";

	public static final String COLUMN_CARD_ENERGY_DEF = "energyDef";

	public static final String COLUMN_CARD_MISSLE_ATT = "missleAtt";

	public static final String COLUMN_CARD_MISSLE_DEF = "missleDef";

	public static final String COLUMN_CARD_DESCRIPTION = "description";

	public static final String COLUMN_CARD_IMAGE_PATH = "imagePath";

	public static final String TEXT_TYPE = " TEXT";

	public static final String BLOB_TYPE = " BLOB";

	public static final String INT_TYPE = " INTEGER";

	private static final String QUERY_CREATE_DECK_TABLE = "CREATE TABLE " + DECK_TABLE_NAME + " ("
			+ COLUMN_ID + " INTEGER PRIMARY KEY," + COLUMN_CARD_NAME + TEXT_TYPE + ","
			+ COLUMN_CARD_COST + INT_TYPE + "," + COLUMN_CARD_DESCRIPTION + TEXT_TYPE + ","
			+ COLUMN_CARD_KINETIC_ATT + INT_TYPE + "," + COLUMN_CARD_KINETIC_DEF + INT_TYPE + ","
			+ COLUMN_CARD_ENERGY_ATT + INT_TYPE + "," + COLUMN_CARD_ENERGY_DEF + INT_TYPE + ","
			+ COLUMN_CARD_MISSLE_ATT + INT_TYPE + "," + COLUMN_CARD_MISSLE_DEF + INT_TYPE + ","
			+ COLUMN_CARD_HEALTH + INT_TYPE + "," + COLUMN_CARD_MAIN_TYPE + TEXT_TYPE + ","
			+ COLUMN_CARD_SECONDARY_TYPE + TEXT_TYPE + "," + COLUMN_CARD_IMAGE_PATH + TEXT_TYPE
			+ "," + COLUMN_VERSION + INT_TYPE + ")";

	private static final String QUERY_DROP_DECK_TABLE = "DROP TABLE IF EXISTS " + DECK_TABLE_NAME;

	public GameSQLiteHelper( Context context ) {
		super(context, DB_NAME, null, DB_VER);
	}

	@Override
	public void onCreate( SQLiteDatabase db ) {
		db.execSQL(QUERY_CREATE_DECK_TABLE);
	}

	@Override
	public void onUpgrade( SQLiteDatabase db, int oldVersion, int newVersion ) {
		db.execSQL(QUERY_DROP_DECK_TABLE);
		onCreate(db);
	}

}
