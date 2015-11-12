package wordsforgre.allwords;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class AllWordsDbCRUD extends SQLiteOpenHelper {
	
	public static final String TABLE_WORDS = "allwords";
	public static final String COLUMN_ID = "_id";
	public static final String COLUMN_WORD = "word";
	public static final String COLUMN_MEANING = "meaning";
	private static final String DATABASE_NAME = "allwords.db";
	private static final int DATABASE_VERSION = 1;
	
	// Database creation sql statement
	private static final String DATABASE_CREATE = "create table " + TABLE_WORDS
			+ " (" + COLUMN_ID + " integer primary key autoincrement, "
			+ COLUMN_WORD + " text not null unique, " + COLUMN_MEANING
			+ " text not null);";

	public AllWordsDbCRUD(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}

	@Override
	public void onCreate(SQLiteDatabase database) {
		database.execSQL(DATABASE_CREATE);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		Log.w(AllWordsDbCRUD.class.getName(),
				"Upgrading database from version " + oldVersion + " to "
						+ newVersion + ", which will destroy all old data");
		db.execSQL("DROP TABLE IF EXISTS " + TABLE_WORDS);
		onCreate(db);
	}
}
