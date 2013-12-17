package com.sunstar.doctor_android.dao;

import java.util.ArrayList;
import java.util.List;

import com.sunstar.doctor_android.objects.EventObj;

public class EventDao {
	
	public List<EventObj> getEventList(){
		List<EventObj> eventList=new ArrayList<EventObj>();
		
		for(int i=0;i<7;i++){
			EventObj event=new EventObj(i,"测试方法，标题"+String.valueOf(i),"测试方法，简介"+String.valueOf(i),"2012-3-18 15:28:00");
			
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
