package com.sunstar.doctor_android.objects;

import com.sunstar.doctor_android.Interfaces.ICommonListObj;

public class DoctorObj implements ICommonListObj {
	
	public int doctorId;
	public String name;
	public String title;
	public String summary;
	public String description;
	public String imageUrl;
	
	public DoctorObj(int _doctorId,String _name,String _title,String _summary){
		this.doctorId=_doctorId;
		this.name=_name;
		this.title=_title;
		this.summary=_summary;
	}
	
	public int getDoctorId(){
		return this.doctorId;
	}
	
	public String getName(){
		return this.name;
	}

	public String getDoctorTitle(){
		return this.title;
	}
	
	public String getTitle(){
		return getName();
	}
	
	public String getSummary(){
		return this.summary;
	}
	
	public void setDescription(String _description){
		this.description=_description;
	}
	
	public String getDescription(){
		return this.description;
	}

	@Override
	public int getId() {
		// TODO Auto-generated method stub
		return getDoctorId();
	}

	public void setImageUrl(String _imageUrl){
		this.imageUrl=_imageUrl;
	}

	@Override
	public String getImageUrl(){
		return this.imageUrl;
	}
}
