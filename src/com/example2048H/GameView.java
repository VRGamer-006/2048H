package com.example2048H;

import java.util.ArrayList;
import java.util.List;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Point;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.GridLayout;

public class GameView extends GridLayout {

	public GameView(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
		initGameView();
	}
	
	public GameView(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
		initGameView();
	}
	
	public GameView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		initGameView();
	}

	private void initGameView() {
		// TODO Auto-generated method stub
		
		setColumnCount(4);
		setBackgroundColor(0xffbbada0);
		
		setOnTouchListener(new View.OnTouchListener() {
			
			private float startX,startY,offsetX,offsetY;
			
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				// TODO Auto-generated method stub
				
				switch(event.getAction()){
				case MotionEvent.ACTION_DOWN:
					startX = event.getX();
					startY = event.getY();
					break;
				case MotionEvent.ACTION_UP:
					offsetX = event.getX() - startX;
					offsetY = event.getY() - startY;
					if(Math.abs(offsetX)>Math.abs(offsetY)){
						if(offsetX<-5){
							swipeLeft();
						}else if(offsetX>5){
							swipeRight();
						}
					}else if(Math.abs(offsetX)<Math.abs(offsetY)){
						if(offsetY<-5){
							swipeUp();
					}else if(offsetY>5){
						    swipeDown();
					}
					}else if(Math.abs(offsetX)==Math.abs(offsetY)){
						    stop();}
					break;
				}
				
				return true;
			}
		});
	}
	
	private void swipeUp(){
		
		boolean merge = false;
		
		for (int x = 0; x < 4; x++) {
			for (int y = 0; y < 4; y++) {
				for (int y1 = y+1; y1 < 4; y1++) {
					if (cardsMap[x][y1].getNum()>0) {
						if (cardsMap[x][y].getNum()<=0) {
							
							int yoy =y1 - y;
							ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0, 
									Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,-yoy);
							ta.setDuration(100);
							cardsMap[x][y1].startAnimation(ta);
							
							cardsMap[x][y].setNum(cardsMap[x][y1].getNum());
							cardsMap[x][y1].setNum(0);
							y--;
							merge = true;
							break;
						}else if (cardsMap[x][y].equals(cardsMap[x][y1])) {
							
							int yoy =y1 - y;
							ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0, 
									Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,-yoy);
							ta.setDuration(100);
							cardsMap[x][y1].startAnimation(ta);
							
							cardsMap[x][y].setNum(cardsMap[x][y1].getNum()*2);
							cardsMap[x][y1].setNum(0);
							MainActivity.getMainActivity().addScore(cardsMap[x][y].getNum());
							merge = true;
							break;
						}else {
							break;
						}
					}
				}
			}
		}
		
		if (merge) {		
			MainActivity.getMainActivity().addStep();
			addRandomNum();
			ChangesR();
			checkComplete1();
			checkComplete2();
			checkComplete3();
		}
		
	}
	
    private void swipeDown(){
    	
    	boolean merge = false;
    	
    	for (int x = 0; x < 4; x++) {
			for (int y = 3; y >= 0; y--) {
				for (int y1 = y-1; y1 >= 0; y1--) {
					if (cardsMap[x][y1].getNum()>0) {
						if (cardsMap[x][y].getNum()<=0) {
							
							int yoy =y1 - y;
							ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0, 
									Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,-yoy);
							ta.setDuration(100);
							cardsMap[x][y1].startAnimation(ta);
							
							cardsMap[x][y].setNum(cardsMap[x][y1].getNum());
							cardsMap[x][y1].setNum(0);
							y++;
							merge = true;
							break;
						}else if (cardsMap[x][y].equals(cardsMap[x][y1])) {
							
							int yoy =y1 - y;
							ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0, 
									Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,-yoy);
							ta.setDuration(100);
							cardsMap[x][y1].startAnimation(ta);
							
							cardsMap[x][y].setNum(cardsMap[x][y1].getNum()*2);
							cardsMap[x][y1].setNum(0);
							MainActivity.getMainActivity().addScore(cardsMap[x][y].getNum());
							merge = true;
							break;
						}else {
							break;
						}
					}
				}
			}
		}
    	
    	if (merge) {
    		MainActivity.getMainActivity().addStep();
			addRandomNum();
			ChangesR();
			checkComplete1();
			checkComplete2();
			checkComplete3();
		}
    	
	}

    private void swipeLeft(){
    	
    	boolean merge = false;
    	
    	for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				for (int x1 = x+1; x1 < 4; x1++) {
					if (cardsMap[x1][y].getNum()>0) {
						if (cardsMap[x][y].getNum()<=0) {
							
							int xox =x1 - x;
							ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,-xox, 
									Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0);
							ta.setDuration(100);
							cardsMap[x1][y].startAnimation(ta);
							
							cardsMap[x][y].setNum(cardsMap[x1][y].getNum());
							cardsMap[x1][y].setNum(0);
							x--;
							merge = true;
							break;
						}else if (cardsMap[x][y].equals(cardsMap[x1][y])) {
							
							int xox =x1 - x;
							ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,-xox, 
									Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0);
							ta.setDuration(100);
							cardsMap[x1][y].startAnimation(ta);
							
							cardsMap[x][y].setNum(cardsMap[x1][y].getNum()*2);
							cardsMap[x1][y].setNum(0);
							MainActivity.getMainActivity().addScore(cardsMap[x][y].getNum());
							merge = true;
							break;
						}else {
							break;
						}
					}
				}
			}
		}
    	
    	if (merge) {
    		MainActivity.getMainActivity().addStep();
			addRandomNum();
			ChangesR();
			checkComplete1();
			checkComplete2();
			checkComplete3();
		}
    	
    }

    private void swipeRight(){
    	
    	boolean merge = false;
    	
    	for (int y = 0; y < 4; y++) {
			for (int x = 3; x >= 0; x--) {
				for (int x1 = x-1; x1 >= 0; x1--) {
					if (cardsMap[x1][y].getNum()>0) {
						if (cardsMap[x][y].getNum()<=0) {
							
							int xox =x1 - x;
							ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,-xox, 
									Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0);
							ta.setDuration(100);
							cardsMap[x1][y].startAnimation(ta);
							
							cardsMap[x][y].setNum(cardsMap[x1][y].getNum());
							cardsMap[x1][y].setNum(0);
							x++;
							merge = true;
							break;
						}else if (cardsMap[x][y].equals(cardsMap[x1][y])) {
							
							int xox =x1 - x;
							ta = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,-xox, 
									Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,0);
							ta.setDuration(100);
							cardsMap[x1][y].startAnimation(ta);
							
							cardsMap[x][y].setNum(cardsMap[x1][y].getNum()*2);
							cardsMap[x1][y].setNum(0);
							MainActivity.getMainActivity().addScore(cardsMap[x][y].getNum());
							merge = true;
							break;
						}else {
							break;
						}
					}
				}
			}
		}
    	
    	if (merge) {
    		MainActivity.getMainActivity().addStep();
			addRandomNum();
			ChangesR();
			checkComplete1();
			checkComplete2();
			checkComplete3();
		}
    	
    }
    
    private void stop(){
    }
    
    private Card[][] cardsMap = new Card[4][4]; 
    private List<Point> emptyPoints = new ArrayList<Point>();
    private TranslateAnimation ta;
    private int oldRecord=0;
    private int newRecord=0;
    
    protected void onSizeChanged(int w,int h,int oldw,int oldh)
    {
    	super.onSizeChanged(w, h, oldw, oldh);
    	
    	int cardWidth = (Math.min(w,h)-10)/4;
    	
    	addCards(cardWidth,cardWidth);
    	
    	startGame();
    }
    
    private void addCards(int cardWidth,int cardHeight){
    	
    	Card c;
    	
    	for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				c = new Card(getContext());
				c.setNum(0);
				addView(c, cardWidth, cardHeight);
				cardsMap[x][y] = c;
			}
		}
    }
    
    private void addRandomNum(){
    	
    	emptyPoints.clear();
    	
    	for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				if (cardsMap[x][y].getNum()<=0) {
					emptyPoints.add(new Point(x,y));
				}
			}
		}
    	
    	Point p = emptyPoints.remove((int)(Math.random()*emptyPoints.size()));
    	cardsMap[p.x][p.y].setNum(Math.random()>0.1?2:4);
    	
    }
    
    private void startGame() {
    	
    	MainActivity.getMainActivity().clearScore();
    	MainActivity.getMainActivity().startStep();
    	MainActivity.getMainActivity().startTime();
    	
    	for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				cardsMap[x][y].setNum(0);
			}
		}
    	
    	addRandomNum();
    	addRandomNum();
    	
    	StartsR();
    	
	}
    
    private void checkComplete1() {
    	boolean complete = true;
    	ALL:
    	for (int y = 0; y < 4; y++) {
			for (int x = 0; x < 4; x++) {
				if ((cardsMap[x][y].getNum()<=0)
						||((newRecord>1024)&&(newRecord!=oldRecord))
						||(x>0&&cardsMap[x][y].equals(cardsMap[x-1][y]))
						||(x<3&&cardsMap[x][y].equals(cardsMap[x+1][y]))
						||(y>0&&cardsMap[x][y].equals(cardsMap[x][y-1]))
						||(y<3&&cardsMap[x][y].equals(cardsMap[x][y+1]))) {
				    complete = false;
					break ALL;
				}
			}
		}
    	
    	if (complete) {
			AlertDialog.Builder AB = new AlertDialog.Builder(getContext());
				AB.setTitle("Game Over!!!");
				AB.setMessage("Score : "+MainActivity.getMainActivity().getScore()+"\n"
						+"Step : "+MainActivity.getMainActivity().getStep()+"\n"
						+"Time : "+MainActivity.getMainActivity().getTime()+"\n"
						+"Record : "+MainActivity.getMainActivity().getRecord());
				AB.setPositiveButton("again",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						startGame();
					}
				});
				AB.setNegativeButton("exit",new DialogInterface.OnClickListener() {
					
					@Override
					public void onClick(DialogInterface dialog, int which) {
						// TODO Auto-generated method stub
						MainActivity.getMainActivity().finish();
					}
				});
				AB.show();
		}
    }
    	
    private void checkComplete2(){
    	boolean a1=true;
    	boolean b1=true;
    	
        	
    	if((newRecord==2048)&&(newRecord!=oldRecord)){
    	     a1 =false;
    	}
    								
    	A:
    		for (int y = 0; y < 4; y++) {
				for (int x = 0; x < 4; x++) {
					if((cardsMap[x][y].getNum()<=0)
							||(x>0&&cardsMap[x][y].equals(cardsMap[x-1][y]))
							||(x<3&&cardsMap[x][y].equals(cardsMap[x+1][y]))
							||(y>0&&cardsMap[x][y].equals(cardsMap[x][y-1]))
							||(y<3&&cardsMap[x][y].equals(cardsMap[x][y+1])))
					{
						b1 = false;
					    break A;
					}
				}	
			}	
        		
					if((!a1)&&(b1)){
						AlertDialog.Builder AB = new AlertDialog.Builder(getContext());
						AB.setTitle("Congratulations!!!");
						AB.setMessage("Score : "+MainActivity.getMainActivity().getScore()+"\n"
								+"Step : "+MainActivity.getMainActivity().getStep()+"\n"
								+"Time : "+MainActivity.getMainActivity().getTime()+"\n"
								+"Record : "+MainActivity.getMainActivity().getRecord());
						AB.setPositiveButton("again",new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								startGame();
							}
						});
						AB.setNegativeButton("exit",new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								MainActivity.getMainActivity().finish();
							}
						});
						AB.show();
				}	
					if((!a1)&&(!b1)){
					AlertDialog.Builder AB = new AlertDialog.Builder(getContext());
					AB.setTitle("Congratulations!!!");
					AB.setMessage("Score : "+MainActivity.getMainActivity().getScore()+"\n"
							+"Step : "+MainActivity.getMainActivity().getStep()+"\n"
							+"Time : "+MainActivity.getMainActivity().getTime()+"\n"
							+"Record : "+MainActivity.getMainActivity().getRecord());
					AB.setPositiveButton("continue",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
						}
					});
					AB.setNegativeButton("exit",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							MainActivity.getMainActivity().finish();
						}
					});
					AB.show();
				}
			}
    	
		
    private void checkComplete3(){
    	boolean a2=true;
    	boolean b2=true;
    	
        	
    	if((newRecord>2048)&&(newRecord!=oldRecord)){
    	     a2 =false;
    	}
    								
    	B:
    		for (int y = 0; y < 4; y++) {
				for (int x = 0; x < 4; x++) {
					if((cardsMap[x][y].getNum()<=0)
							||(x>0&&cardsMap[x][y].equals(cardsMap[x-1][y]))
							||(x<3&&cardsMap[x][y].equals(cardsMap[x+1][y]))
							||(y>0&&cardsMap[x][y].equals(cardsMap[x][y-1]))
							||(y<3&&cardsMap[x][y].equals(cardsMap[x][y+1])))
					{
						b2 = false;
					    break B;
					}
				}	
			}	
        		
					if((!a2)&&(b2)){
						AlertDialog.Builder AB = new AlertDialog.Builder(getContext());
						AB.setTitle("New Record : "+MainActivity.getMainActivity().getRecord());
						AB.setMessage("Score : "+MainActivity.getMainActivity().getScore()+"\n"
								+"Step : "+MainActivity.getMainActivity().getStep()+"\n"
								+"Time : "+MainActivity.getMainActivity().getTime()+"\n"
								+"Record : "+MainActivity.getMainActivity().getRecord());
						AB.setPositiveButton("again",new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								startGame();
							}
						});
						AB.setNegativeButton("exit",new DialogInterface.OnClickListener() {
							
							@Override
							public void onClick(DialogInterface dialog, int which) {
								// TODO Auto-generated method stub
								MainActivity.getMainActivity().finish();
							}
						});
						AB.show();
				}	
					if((!a2)&&(!b2)){
					AlertDialog.Builder AB = new AlertDialog.Builder(getContext());
					AB.setTitle("New Record : "+MainActivity.getMainActivity().getRecord());
					AB.setMessage("Score : "+MainActivity.getMainActivity().getScore()+"\n"
							+"Step : "+MainActivity.getMainActivity().getStep()+"\n"
							+"Time : "+MainActivity.getMainActivity().getTime()+"\n"
							+"Record : "+MainActivity.getMainActivity().getRecord());
					AB.setPositiveButton("continue",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
						}
					});
					AB.setNegativeButton("exit",new DialogInterface.OnClickListener() {
						
						@Override
						public void onClick(DialogInterface dialog, int which) {
							// TODO Auto-generated method stub
							MainActivity.getMainActivity().finish();
						}
					});
					AB.show();
				}
			}
    
    private void ChangesR(){
        newRecord = oldRecord = MainActivity.getMainActivity().getRecord();
	    for (int y = 0; y < 4; y++) {
		for (int x = 0; x < 4; x++) {
			if(cardsMap[x][y].getNum()>newRecord){
				newRecord=cardsMap[x][y].getNum();
				MainActivity.getMainActivity().setRecord(newRecord);
				return;
			}		
		}
	 }
   }
    
    private void StartsR(){
    	int max=0;
    	for (int y = 0; y < 4; y++) {
    		for (int x = 0; x < 4; x++) {
    			if(cardsMap[x][y].getNum()>max){
    				max=cardsMap[x][y].getNum();
    			}		
    		}
    	}
    	MainActivity.getMainActivity().setRecord(max);
    }
    
}
