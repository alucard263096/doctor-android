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
		
		doctorList.add(new DoctorObj(1,"赵荣燕 教授","教授","教授"));
		doctorList.add(new DoctorObj(2,"陈紫铭","教授","教授"));
		doctorList.add(new DoctorObj(3,"赵会军 教授","教授","教授"));
		doctorList.add(new DoctorObj(4,"许永熏","教授","教授"));
		doctorList.add(new DoctorObj(5,"许秉娴 教授","教授","教授"));
		doctorList.add(new DoctorObj(6,"罗怀安","教授","教授"));
		doctorList.add(new DoctorObj(7,"欧阳心浩","教授","教授"));
		doctorList.add(new DoctorObj(8,"张丽萍","教授","教授"));
		doctorList.add(new DoctorObj(9,"张文博","教授","教授"));
		doctorList.add(new DoctorObj(10,"张一明","教授","教授"));
		doctorList.add(new DoctorObj(11,"孙洋","教授","教授"));
		doctorList.add(new DoctorObj(12,"吴晏惠","教授","教授"));
		doctorList.add(new DoctorObj(13,"吴思彤","教授","教授"));
		doctorList.add(new DoctorObj(14,"叶子","教授","教授"));
		doctorList.add(new DoctorObj(15,"华青 医学博士","教授","教授"));
		
		
		return doctorList;
	}

	public DoctorObj getDoctor(int doctorId) {
		// TODO Auto-generated method stub
		DoctorObj doctor=new DoctorObj(doctorId,"医生名称","职位","简介");
		doctor.setDescription("医生的详细介绍");
		//event.setContent("以下都是正文\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n\r\n<br/><br/><br/><br/><br/><br/><br/><br/><br/><strong>fuck</string>\r\n");
		return doctor;
	}
	
}
