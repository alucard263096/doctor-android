package com.sunstar.doctor_android;

import com.sunstar.doctor_android.dao.DoctorDao;
import com.sunstar.doctor_android.dao.EventDao;
import com.sunstar.doctor_android.objects.DoctorObj;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;

public class DoctorActivity extends Activity {

	DoctorObj doctor=null;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_doctor);
		initEvent();
		showContent();
	}

	private void showContent() {
		// TODO Auto-generated method stub
		int screendWidth=getWindowManager().getDefaultDisplay().getWidth();
		((ImageView)this.findViewById(R.id.EventImage)).getLayoutParams().width=screendWidth-screendWidth/20;
		((ImageView)this.findViewById(R.id.EventImage)).getLayoutParams().height=((ImageView)this.findViewById(R.id.EventImage)).getLayoutParams().width*3/4;
		((TextView)this.findViewById(R.id.Name)).setText(doctor.getTitle());
		((TextView)this.findViewById(R.id.Content)).setText(doctor.getDescription());
		//((TextView)this.findViewById(R.id.Title)).setText(event.getTitle());
	}

	private void initEvent() {
		// TODO Auto-generated method stub
		Intent intent = getIntent();
		int doctorId = intent.getIntExtra("Id", 0);
		DoctorDao dao=new DoctorDao(this);
		doctor=dao.getDoctor(doctorId);
	}


}
