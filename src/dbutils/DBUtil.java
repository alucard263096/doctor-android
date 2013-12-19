package dbutils;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public  class DBUtil {

	private static final String TAG = "DBUtil";
	private static final String DATABASE_NAME = "BASE.DB";
	private static final int DATABASE_VERSION = 1;
	private static  Context mCtx;
	private DatabaseHelper mDbHelper;
	private SQLiteDatabase mDb;

	private static class DatabaseHelper extends SQLiteOpenHelper {

		 DatabaseHelper(Context context) {
			 super(context, DATABASE_NAME,null, DATABASE_VERSION);
		}

		@Override
		public void onCreate(SQLiteDatabase db) {

			db.beginTransaction();
			try {
				StringBuffer sql = new StringBuffer();
				
				sql = new StringBuffer();
				sql.append("create table if not exists tb_event (eventId int ,title varchar ,summary varchar,content varchar,publishedDate varchar,imageUrl varchar)");
				db.execSQL(sql.toString());


				db.setTransactionSuccessful();
			} finally {
				db.endTransaction();
			}

		}


		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

		}
	}
	
	public DBUtil(Context ctx){
		this.mCtx=ctx;
	}
	
	
	public DBUtil open() throws SQLException{
		mDbHelper=new DatabaseHelper(mCtx);
		mDb=mDbHelper.getWritableDatabase();
		return this;
	}
	
	public void beginTransaction() throws SQLException{
		mDb.beginTransaction();
	}
	
	public void endTransaction() throws SQLException{
		mDb.endTransaction();
	}
	
	public void setTransactionSuccessful() throws SQLException{
		mDb.setTransactionSuccessful();
	}
	
	public void close(){
		mDbHelper.close();
	}
	
	public Cursor rawQuery(String sql, String[] selectionArgs) throws SQLException{
	  return mDb.rawQuery(sql, selectionArgs);
	}
	
	public void execSQL(String sql, Object[] bindArgs) throws SQLException{
		  mDb.execSQL(sql, bindArgs);
	}
}
