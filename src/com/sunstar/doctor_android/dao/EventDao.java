package com.sunstar.doctor_android.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;

import com.sunstar.doctor_android.objects.EventObj;

public class EventDao extends AbstractDao {
	
	public EventDao(Context ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	public List<EventObj> getEventList(){
		List<EventObj> eventList=new ArrayList<EventObj>();
		
		Cursor cursor = null;
		try {
			cursor = util
					.rawQuery(
							"select  eventId,title,summary,publishedDate,imageUrl from tb_event order by publishedDate desc Limit 30",new String[] {  });
			while (cursor.moveToNext()) {
				int eventId=cursor.getInt(cursor.getColumnIndex("eventId"));
				String title=cursor.getString(cursor.getColumnIndex("title"));
				String summary=cursor.getString(cursor.getColumnIndex("summary"));
				String publishedDate=cursor.getString(cursor.getColumnIndex("publishedDate"));
				String imageUrl=cursor.getString(cursor.getColumnIndex("imageUrl"));
				
				EventObj event=new EventObj(eventId,title,summary,publishedDate);
				event.setImageUrl(imageUrl);
				eventList.add(event);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
		return eventList;
	}

	public EventObj getEvent(int eventId) {
		// TODO Auto-generated method stub
		EventObj event=null;
		Cursor cursor = null;
		try {
			cursor = util
					.rawQuery(
							"select top 30 eventId,title,summary,publishedDate,imageUrl,content from tb_event where eventId=? order by publishedDate desc ",new String[] {String.valueOf(eventId)  });
			while (cursor.moveToNext()) {
				String title=cursor.getString(cursor.getColumnIndex("title"));
				String summary=cursor.getString(cursor.getColumnIndex("summary"));
				String publishedDate=cursor.getString(cursor.getColumnIndex("publishedDate"));
				String imageUrl=cursor.getString(cursor.getColumnIndex("imageUrl"));
				String content=cursor.getString(cursor.getColumnIndex("content"));
				
				event=new EventObj(eventId,title,summary,publishedDate);
				event.setImageUrl(imageUrl);
				event.setContent(content);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (cursor != null) {
				cursor.close();
			}
		}
		return event;
	}
	
}
