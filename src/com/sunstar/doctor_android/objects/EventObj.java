package com.sunstar.doctor_android.objects;

public class EventObj {
	
	int eventId;
	String title;
	String summary;
	String content;
	String publishedDate;
	String imageUrl;
	
	public EventObj(int _eventId,String _title,String _summary,String _publishedDate){
		this.eventId=_eventId;
		this.title=_title;
		this.summary=_summary;
		this.publishedDate=_publishedDate;
	}
	
	public int getEventId(){
		return this.eventId;
	}
	
	public String getSummary(){
		return this.summary;
	}
	public void setContent(String _content){
		this.content=_content;
	}
	public String getContent(){
		return this.content;
	}
	
	public String getPublishedDate(){
		return this.publishedDate;
	}
	
	public String getTitle(){
		return this.title;
	}
	
	public void setImageUrl(String _imageUrl){
		this.imageUrl=_imageUrl;
	}
	
	public String getImageUrl(){
		return this.imageUrl;
	}
}