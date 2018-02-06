package com.example2048H;

import android.content.Context;
import android.graphics.Color;
import android.text.TextPaint;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.TextView;

public class Card extends FrameLayout{

	public Card(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		label = new TextView(getContext());
		label.setTextSize(16);
		label.setGravity(Gravity.CENTER);
		label.setSingleLine();
		TextPaint tp = label.getPaint(); 
		tp.setFakeBoldText(true);
		LayoutParams lp = new LayoutParams(-1,-1);
		lp.setMargins(10,10,0,0);
		addView(label,lp);
		setNum(0);
	}
	
	private int num = 0;
	
	public int getNum(){
		return num;
	}
	
	public void setNum(int num){
		this.num = num;
		if(num<=0){
    		label.setText("");
    		label.setBackgroundColor(0x33ffffff);
    		return;
		}
    		switch(checkNum(num)){
    		case 1:
    			label.setText(num+"");
        		label.setTextColor(Color.parseColor("#000000"));
        		label.setBackgroundColor(Color.parseColor("#FFFF99"));
        		break;
    		case 2:
    			label.setText(num+"");
        		label.setTextColor(Color.parseColor("#404040"));
        		label.setBackgroundColor(Color.parseColor("#FF99CC"));
        		break;
    		case 3:
    			label.setText(num+"");
        		label.setTextColor(Color.parseColor("#003399"));
        		label.setBackgroundColor(Color.parseColor("#99CC33"));
        		break;
    		case 4:
    			label.setText(num+"");
        		label.setTextColor(Color.parseColor("#FF6600"));
        		label.setBackgroundColor(Color.parseColor("#6699FF"));
        		break;
    		case 5:
    			label.setText(num+"");
        		label.setTextColor(Color.parseColor("#CC0000"));
        		label.setBackgroundColor(Color.parseColor("#FFCC00"));
        		break;
    		case 6:
    			label.setText(num+"");
        		label.setTextColor(Color.parseColor("#FFFFFF"));
        		label.setBackgroundColor(Color.parseColor("#000000"));
        		break;
    	}
    		switch(checkNum(num)%7){
    		case 0:
    			label.setText(num+"");
        		label.setTextColor(Color.parseColor("#000000"));
        		label.setBackgroundColor(Color.parseColor("#FFFFFF"));
        		break;
    		case 1:
    			label.setText(num+"");
        		label.setTextColor(Color.parseColor("#000000"));
        		label.setBackgroundColor(Color.parseColor("#FFFF99"));
        		break;
    		case 2:
    			label.setText(num+"");
        		label.setTextColor(Color.parseColor("#404040"));
        		label.setBackgroundColor(Color.parseColor("#FF99CC"));
        		break;
    		case 3:
    			label.setText(num+"");
        		label.setTextColor(Color.parseColor("#003399"));
        		label.setBackgroundColor(Color.parseColor("#99CC33"));
        		break;
    		case 4:
    			label.setText(num+"");
        		label.setTextColor(Color.parseColor("#FF6600"));
        		label.setBackgroundColor(Color.parseColor("#6699FF"));
        		break;
    		case 5:
    			label.setText(num+"");
        		label.setTextColor(Color.parseColor("#CC0000"));
        		label.setBackgroundColor(Color.parseColor("#FFCC00"));
        		break;
    		case 6:
    			label.setText(num+"");
        		label.setTextColor(Color.parseColor("#FFFFFF"));
        		label.setBackgroundColor(Color.parseColor("#000000"));
        		break;
    		}
    }
	
	public boolean equals(Card o){
		return getNum()==o.getNum();
	}
	
	private TextView label;
	
	public int checkNum(int n){
			int u=0;
			while(true){
			if(n!=1){
				n=n/2;
				u++;
			}else{
				return u;
			}
		  }
	}

}
