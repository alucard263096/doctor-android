package com.sunstar.doctor_android.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.sunstar.doctor_android.objects.EventObj;

public class EventDao extends AbstractDao {
	
	public EventDao(Context ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	public List<EventObj> getEventList(){
		List<EventObj> eventList=new ArrayList<EventObj>();
		
		for(int i=0;i<7;i++){
			EventObj event=new EventObj(i,"测试方法，标题"+String.valueOf(i),"测试方法，简介"+String.valueOf(i),"2012-3-18 15:28:00");
			event.setImageUrl("http://h.hiphotos.baidu.com/baike/c0%3Dbaike52%2C5%2C5%2C52%2C17/sign=be0277024fc2d562e605d8bf8678fb8a/024f78f0f736afc37e0be607b319ebc4b64543a982263a70.jpg");
			eventList.add(event);
		}
		
		return eventList;
	}

	public EventObj getEvent(int eventId) {
		// TODO Auto-generated method stub
		EventObj event=new EventObj(eventId,"测试方法，标题"+String.valueOf(eventId),"测试方法，简介"+String.valueOf(eventId),"2012-3-18 15:28:00");
		event.setContent("以下都是正文\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<br/><br/><br/><br/><br/><br/><br/><br/><br/><strong>fuck</string>\r\n");
		return event;
	}
	
}
