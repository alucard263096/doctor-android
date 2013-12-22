package com.sunstar.doctor_android.dao;

import com.sunstar.doctor_android.objects.EventObj;

import android.content.Context;
import android.database.Cursor;
import android.util.Log;

public class ParamsDao extends AbstractDao {

	public ParamsDao(Context ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}
	
	public String getParam(String fieldname,String defaultvalue) {
		// TODO Auto-generated method stub
		
		EventObj event=null;
		Cursor cursor = null;
		try {
			util.open();
			cursor = util
					.rawQuery(
							"select "+fieldname+"  from tb_param ",new String[] { });
			while (cursor.moveToNext()) {
				return cursor.getString(cursor.getColumnIndex(fieldname));
			}
			

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cursor != null) {
				cursor.close();
			}
			util.close();
		}
		return defaultvalue;
	}

	public void updatefield(String fieldname, String updatevalue) {
		// TODO Auto-generated method stub
		
        StringBuffer sql_insert = new StringBuffer();
        sql_insert.append("UPDATE  tb_param set "+fieldname+"=?");
        Object[] bindArgs = {updatevalue};
        util.execSQL(sql_insert.toString(),bindArgs);
	}

}
