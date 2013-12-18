package com.sunstar.doctor_android.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;

import com.sunstar.doctor_android.objects.DoctorObj;

public class DoctorDao extends AbstractDao{
	
	public DoctorDao(Context ctx) {
		super(ctx);
		// TODO Auto-generated constructor stub
	}

	public List<DoctorObj> getDoctorList(){
		List<DoctorObj> doctorList=new ArrayList<DoctorObj>();
		
		doctorList.add(new DoctorObj(1,"������ ����","����","����"));
		doctorList.add(new DoctorObj(2,"������","����","����"));
		doctorList.add(new DoctorObj(3,"�Ի�� ����","����","����"));
		doctorList.add(new DoctorObj(4,"����Ѭ","����","����"));
		doctorList.add(new DoctorObj(5,"���� ����","����","����"));
		doctorList.add(new DoctorObj(6,"�޻���","����","����"));
		doctorList.add(new DoctorObj(7,"ŷ���ĺ�","����","����"));
		doctorList.add(new DoctorObj(8,"����Ƽ","����","����"));
		doctorList.add(new DoctorObj(9,"���Ĳ�","����","����"));
		doctorList.add(new DoctorObj(10,"��һ��","����","����"));
		doctorList.add(new DoctorObj(11,"����","����","����"));
		doctorList.add(new DoctorObj(12,"���̻�","����","����"));
		doctorList.add(new DoctorObj(13,"��˼ͮ","����","����"));
		doctorList.add(new DoctorObj(14,"Ҷ��","����","����"));
		doctorList.add(new DoctorObj(15,"���� ҽѧ��ʿ","����","����"));
		
		
		return doctorList;
	}

	public DoctorObj getDoctor(int doctorId) {
		// TODO Auto-generated method stub
		DoctorObj doctor=new DoctorObj(doctorId,"ҽ������","ְλ","���");
		doctor.setDescription("ҽ������ϸ����");
		//event.setContent("���¶�������\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<br/><br/><br/><br/><br/><br/><br/><br/><br/><strong>fuck</string>\r\n");
		return doctor;
	}
	
}
