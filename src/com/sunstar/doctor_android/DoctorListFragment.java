package com.sunstar.doctor_android;

import java.util.List;

import android.content.Intent;

import com.sunstar.doctor_android.Interfaces.ICommonListObj;
import com.sunstar.doctor_android.dao.DoctorDao;
import com.sunstar.doctor_android.dao.EventDao;
import com.sunstar.doctor_android.objects.DoctorObj;
import com.sunstar.doctor_android.objects.EventObj;

public class DoctorListFragment extends AbstractListFragment {

	@Override
	void initCommonList() {
		// TODO Auto-generated method stub

		this.listObj.clear();
		
		DoctorDao dao=new DoctorDao(this.getActivity());
		
		List<DoctorObj> list=dao.getDoctorList();
		
		for(DoctorObj obj:list){
			this.listObj.add(obj);
		}
	}

	@Override
	void listOnClick(ICommonListObj obj) {
		// TODO Auto-generated method stub
		Intent intent = new Intent(DoctorListFragment.this.getActivity(), DoctorActivity.class);
		intent.putExtra("Id", obj.getId());
		startActivity(intent);  
	}

	@Override
	void afterLoaded() {
		// TODO Auto-generated method stub
		
	}

}
