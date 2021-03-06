package com.sunstar.doctor_android;

import com.sunstar.doctor_android.dao.EventDao;
import com.sunstar.doctor_android.objects.EventObj;
import common.UrlImageLoader;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.TextView;
import android.widget.ImageView;

public class EventActivity extends Activity {

	EventObj event=null;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event);
		
		initEvent();
		showContent();
	}

	private void showContent() {
		// TODO Auto-generated method stub
		int screendWidth=getWindowManager().getDefaultDisplay().getWidth();
		ImageView image=((ImageView)this.findViewById(R.id.EventImage));
		image.getLayoutParams().width=screendWidth-screendWidth/20;
		image.getLayoutParams().height=((ImageView)this.findViewById(R.id.EventImage)).getLayoutParams().width*3/4;
		UrlImageLoader t=new UrlImageLoader(image,event.getImageUrl());
		t.start();
		((TextView)this.findViewById(R.id.Title)).setText(event.getTitle());
		((TextView)this.findViewById(R.id.PublishedDate)).setText("�������ڣ�"+event.getPublishedDate());
		((TextView)this.findViewById(R.id.Content)).setText(event.getContent()+"\r\n\r\n");
		//((TextView)this.findViewById(R.id.Title)).setText(event.getTitle());
	}

	private void initEvent() {
		// TODO Auto-generated method stub
		Intent intent = getIntent();
		int eventId = intent.getIntExtra("Id", 0);
		EventDao dao=new EventDao(this);
		event=dao.getEvent(eventId);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		//getMenuInflater().inflate(R.menu.event, menu);
		return true;
	}

}
