package com.sunstar.doctor_android.dao;

import java.util.ArrayList;
import java.util.List;

import com.sunstar.doctor_android.objects.EventObj;

public class EventDao {
	
	public List<EventObj> getEventList(){
		List<EventObj> eventList=new ArrayList<EventObj>();
		
		for(int i=0;i<7;i++){
			EventObj event=new EventObj(i,"���Է���������"+String.valueOf(i),"���Է��������"+String.valueOf(i),"2012-3-18 15:28:00");
			
			eventList.add(event);
		}
		
		return eventList;
	}

	public EventObj getEvent(int eventId) {
		// TODO Auto-generated method stub
		EventObj event=new EventObj(eventId,"���Է���������"+String.valueOf(eventId),"���Է��������"+String.valueOf(eventId),"2012-3-18 15:28:00");
		event.setContent("���¶�������\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<br/><br/><br/><br/><br/><br/><br/><br/><br/><strong>fuck</string>\r\n");
		return event;
	}
	
}
