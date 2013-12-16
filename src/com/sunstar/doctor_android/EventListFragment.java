package com.sunstar.doctor_android;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridLayout;
import android.widget.GridLayout.LayoutParams;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.TextView;

public class EventListFragment extends Fragment {
	/**
	 * The fragment argument representing the section number for this
	 * fragment.
	 */
	
	LinearLayout ListContainer;
	
	public static final String ARG_SECTION_NUMBER = "section_number";

	public EventListFragment() {
		
		
	}
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_event_list,
				container, false);

		
		findViews(rootView);
		init(rootView, container.getContext());
		eventBinding(rootView, container.getContext());
		
		return rootView;
	}
	

	private void findViews(View view) {
		ListContainer=(LinearLayout)view.findViewById(R.id.ListContainer);
	}

	private void init(View view,Context ctx) {
		
		for(int i=0;i<20;i++){
			GridLayout eventGrid=new GridLayout(ctx);
			LayoutParams param=new LayoutParams();
			//param.width=LayoutParams.MATCH_PARENT;
			param.height=200;
			
			eventGrid.setColumnCount(2);
			eventGrid.setLayoutParams(param);
			if(i%2==1){
				eventGrid.setBackgroundColor(Color.parseColor("#eeeeee"));
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
			img.setScaleType(ScaleType.CENTER);
			img.setLayoutParams(imageParam);
			eventGrid.addView(img);
			
			
			TextView txtTitle=new TextView(ctx);
			LayoutParams titleParam=new LayoutParams();
			//titleParam.width=screendWidth-480;
			titleParam.columnSpec=GridLayout.spec(1);
			titleParam.rowSpec=GridLayout.spec(0);
			titleParam.setGravity(Gravity.FILL);
			titleParam.leftMargin=20;
			titleParam.topMargin=10;
			txtTitle.setText("这是一个十二字活动的标题");//.substring(0, 12)
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
			txtAbstract.setText("一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零一二三四五六七八九零");
			txtAbstract.setTextSize(12);
			txtAbstract.setLayoutParams(abstractParam);
			eventGrid.addView(txtAbstract);
			
			
			ListContainer.addView(eventGrid);
		}
	}
	
	private void eventBinding(View view,Context ctx) {
		
	}
}
