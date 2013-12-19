package com.sunstar.doctor_android.dao;

import dbutils.DBUtil;
import android.content.Context;
import android.util.Log;

public abstract class AbstractDao {
	protected DBUtil util;
	public AbstractDao(Context ctx){
		util=new DBUtil(ctx);
		util.open();
	}
	
	 protected void finalize(){
		 util.close();
		 Log.i("a", "run close");
	 }
}
