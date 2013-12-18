package DBUtils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SQLiteHelper extends SQLiteOpenHelper {

	
	    private final static String DATABASE_NAME = "db_name";
	    private final static int DATABASE_VERSION = 1;
	    private final static String TABLE_NAME = "mytable";
	    private final static String FIELD_ID = "ID";
	    private final static String FIELD_NAME = "NAME";

	    public SQLiteHelper(Context context) {
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	    }

	    @Override
	    public void onCreate(SQLiteDatabase db) {
	        String sql = "Create table %s (%s integer primary key autoincrement,%s text);";
	        sql = String.format(sql, TABLE_NAME, FIELD_ID, FIELD_NAME);
	        db.execSQL(sql);
	    }

	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	        String sql = "DROP TABLE IF EXISTS " + TABLE_NAME;
	        db.execSQL(sql);
	        onCreate(db);
	    }

	    public Cursor select() {
	        SQLiteDatabase db = this.getReadableDatabase();
	        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null,
	                FIELD_ID);
	        return cursor;

	    }

	    public long insert(String name) {
	        SQLiteDatabase db = this.getWritableDatabase();
	        ContentValues cv = new ContentValues();
	        cv.put(FIELD_NAME, name);
	        long row = db.insert(TABLE_NAME, null, cv);
	        return row;
	    }

	    public void delete(int id){
	        SQLiteDatabase db = this.getWritableDatabase();
	        String where  = FIELD_ID + "= ?";
	        String[] wherevalue = {Integer.toString(id)};
	        db.delete(TABLE_NAME, where, wherevalue);
	    }
	    
	    public void update(int id,String name)
	    {
	        SQLiteDatabase db = this.getWritableDatabase();
	        String where  = FIELD_ID + "= ?";
	        String[] wherevalue = {Integer.toString(id)};
	        ContentValues cv = new ContentValues();
	        cv.put(FIELD_NAME, name);
	        db.update(TABLE_NAME, cv, where, wherevalue);
	    }    
}
