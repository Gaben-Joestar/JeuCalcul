package BaseDeDonnees;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MaBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "mydatabase.db";
    private static final int DATABASE_VERSION = 1;

    public MaBase (Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableQuery = "CREATE TABLE mytable (id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, score INTEGER)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion < 2) {
            // Add a new column to the table
            String addColumnQuery = "ALTER TABLE mytable ADD COLUMN age INTEGER";
            db.execSQL(addColumnQuery);
        }
    }

    public void insertData(String name, int score) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("score", score);
        db.insert("mytable", null, values);
    }

    public Cursor getData() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {"id", "name", "score"};
        String sortOrder = "score DESC";
        Cursor cursor = db.query("mytable", projection, null, null, null, null, sortOrder);
        return cursor;
    }

}
