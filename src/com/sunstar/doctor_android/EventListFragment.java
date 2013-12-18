package com.sunstar.doctor_android;

import java.util.List;

import android.content.Intent;

import com.sunstar.doctor_android.Interfaces.ICommonListObj;
import com.sunstar.doctor_android.dao.EventDao;
import com.sunstar.doctor_android.objects.EventObj;



public class EventListFragment extends AbstractListFragment {
	
	public EventListFragment() {
		
	}

	

	@Override
	void listOnClick(ICommonListObj obj) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(EventListFragment.this.getActivity(), EventActivity.class);
		intent.putExtra("Id", obj.getId());
		startActivity(intent);  
	}

	@Override
	void initCommonList() {
		// TODO Auto-generated method stub
		EventDao dao=new EventDao(this.getActivity());
		
		List<EventObj> list=dao.getEventList();
		
		for(EventObj obj:list){
			this.listObj.add(obj);
		}
	}


	
	

	
}
