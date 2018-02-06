package com.example2048H;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.Window;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	public static final String key1 = "SDK20160929091216p7fi0dioxnc5c24";
	public static final String key2 = "SDK20161629040641z7snyxkrbndasty";//SDK20161629040641z7snyxkrbndasty
	public static final String key3 = "SDK20141005101101zvhnqr5vyanz6uy";
	public static final String keySet[] = new String[] { key1, key2, key3 };
	
	public MainActivity() {
		// TODO Auto-generated constructor stub
		this.mainActivity = this;
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		setContentView(R.layout.activity_main);
		tvScore = (TextView)findViewById(R.id.tvScore);
		tvStep = (TextView)findViewById(R.id.tvStep);
		tvTime = (TextView)findViewById(R.id.tvTime);
		tvRecord = (TextView)findViewById(R.id.tvRecord);
		handler.postDelayed(runnable,1000);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public static MainActivity getMainActivity(){
		return mainActivity;
	}
	
	Handler handler = new Handler();
	Runnable runnable = new Runnable() {
		public void run() {
			addTime();
			handler.postDelayed(this,1000);
		}
	};
	
	private TextView tvScore;
	private TextView tvStep;
	private TextView tvTime;
	private TextView tvRecord;
	private static MainActivity mainActivity = null;
	
	public void clearScore(){
		score = 0;
		showScore();
	}
	
	public void addScore(int s){
		score+=s;
		showScore();
	}
	
	public void showScore(){
		tvScore.setText(score + "");
	}
	
	public int getScore(){
		return score;
	}
	
	public void startStep(){
		step = 0;
		showStep();
	}
	
	public void addStep(){
		step+=1;
		showStep();
	}
	
	public void showStep(){
		tvStep.setText(step + "");
	}
	
	public int getStep(){
		return step;
	}
	
	public void startTime(){
		time = 0;
		showTime();
	}
	
	public void addTime(){
		time+=1;
		showTime();
	}
	
	public void showTime(){
		tvTime.setText(time + "");
	}
	
	public int getTime(){
		return time;
	}
	
	public void setRecord(int record){
		this.record = record;
		tvRecord.setText(record + "");
	}
	
	public int getRecord(){
		return record;
	}
	
	private int score = 0;
	private int step = 0;
	private int time = 0;
	private int record = 0;
	
}
