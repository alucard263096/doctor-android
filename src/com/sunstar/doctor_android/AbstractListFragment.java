package com.sunstar.doctor_android;

import java.util.ArrayList;
import java.util.List;

import com.sunstar.doctor_android.Interfaces.ICommonListObj;
import com.sunstar.doctor_android.dao.EventDao;
import com.sunstar.doctor_android.objects.EventObj;
import common.UrlImageLoader;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView.ScaleType;

public abstract class AbstractListFragment extends Fragment {

	LinearLayout ListContainer;
	protected List<ICommonListObj> listObj=new ArrayList<ICommonListObj>();
	
	
	public AbstractListFragment(){
		
	}
	
	abstract void initCommonList();
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_common_list,
				container, false);

		initCommonList();
		findViews(rootView);
		init(rootView, container.getContext());
		eventBinding(rootView, container.getContext());
		
		return rootView;
	}
	
	private void findViews(View view) {
		ListContainer=(LinearLayout)view.findViewById(R.id.ListContainer);
	}

	private void init(View view,Context ctx) {
		
		int i=0;
		for(ICommonListObj obj:listObj){
			GridLayout eventGrid=new GridLayout(ctx);
			LayoutParams param=new LayoutParams();
			//param.width=LayoutParams.MATCH_PARENT;
			param.height=200;
			
			eventGrid.setColumnCount(2);
			eventGrid.setLayoutParams(param);
			if(i%2==1){
				eventGrid.setBackgroundColor(Color.parseColor("#eeeeee"));
			}else{
				eventGrid.setBackgroundColor(Color.parseColor("#ffffff"));
			}
			int screendWidth=this.getActivity().getWindowManager().getDefaultDisplay().getWidth();
			
			ImageView img=new ImageView(ctx);
			LayoutParams imageParam=new LayoutParams();
			imageParam.width=228;
			imageParam.height=171;
			imageParam.leftMargin=20;
			imageParam.columnSpec=GridLayout.spec(0);
			imageParam.rowSpec=GridLayout.spec(0, 2);
			imageParam.setGravity(Gravity.CENTER);
			img.setImageResource(R.drawable.test);
			//img.setBackgroundColor(Color.parseColor("#ee00ee"));
			img.setScaleType(ScaleType.CENTER_CROP);
			img.setLayoutParams(imageParam);
			eventGrid.addView(img);
			
			UrlImageLoader t=new UrlImageLoader(img,obj.getImageUrl());
			t.start();
			
			
			TextView txtTitle=new TextView(ctx);
			LayoutParams titleParam=new LayoutParams();
			//titleParam.width=screendWidth-480;
			titleParam.columnSpec=GridLayout.spec(1);
			titleParam.rowSpec=GridLayout.spec(0);
			titleParam.setGravity(Gravity.FILL);
			titleParam.leftMargin=20;
			titleParam.topMargin=10;
			txtTitle.setText(obj.getTitle());//.substring(0, 12)
			txtTitle.setTextSize(18);
			txtTitle.setLayoutParams(titleParam);
			eventGrid.addView(txtTitle);
			
			TextView txtAbstract=new TextView(ctx);
			LayoutParams abstractParam=new LayoutParams();
			abstractParam.width=screendWidth-280;
			abstractParam.columnSpec=GridLayout.spec(1);
			abstractParam.rowSpec=GridLayout.spec(1);
			abstractParam.setGravity(Gravity.FILL);
			abstractParam.leftMargin=20;
			abstractParam.topMargin=10;
			//abstractParam.setMargins(20, 10, 20, 0);
			txtAbstract.setTextColor(Color.parseColor("#888888"));
			txtAbstract.setText(obj.getSummary());
			txtAbstract.setTextSize(12);
			txtAbstract.setLayoutParams(abstractParam);
			eventGrid.addView(txtAbstract);
			eventGrid.setTag(R.id.Index,i);
			eventGrid.setTag(R.id.TagObject,obj);
			eventGrid.setOnTouchListener(onGridTouch);
			eventGrid.setOnClickListener(popupEvent);
			ListContainer.addView(eventGrid);
			i++;
		}
	}
	private Button.OnClickListener popupEvent = new Button.OnClickListener() {
		public void onClick(View v) {
			
			//int i=(Integer)v.getTag(R.id.Index);
			ICommonListObj obj=(ICommonListObj)v.getTag(R.id.TagObject);
			//Toast.makeText(getActivity().getApplicationContext(), String.valueOf(i),Toast.LENGTH_SHORT).show();
//			Intent intent = new Intent(AbstractListFragment.this.getActivity(), EventActivity.class);
//			intent.putExtra("Id", obj.getId());
//			startActivity(intent);  
			listOnClick(obj);
		}
	};
	
	abstract void listOnClick(ICommonListObj obj);
	

	private OnTouchListener onGridTouch = new OnTouchListener() {

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			Log.i("action", String.valueOf(event.getAction()));
			if (event.getAction() == MotionEvent.ACTION_DOWN) {
				v.setBackgroundColor(Color.parseColor("#cccccc"));
			}else if (event.getAction() == MotionEvent.ACTION_MOVE){
				//v.setBackgroundColor(Color.parseColor("#bbbbbb"));
			}else if (event.getAction() == MotionEvent.ACTION_UP||event.getAction() == MotionEvent.ACTION_CANCEL) {
				int i=(Integer)v.getTag(R.id.Index);
				if(i%2==1){
					v.setBackgroundColor(Color.parseColor("#eeeeee"));
				}else{
					v.setBackgroundColor(Color.parseColor("#ffffff"));
				}
			}
			return false;
		}
	};
	
	private void eventBinding(View view,Context ctx) {
		
	}
	
}
