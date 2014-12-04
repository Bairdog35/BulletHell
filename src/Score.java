import java.awt.Color;

import greenfoot.Actor;
import greenfoot.GreenfootImage;


public class Score extends Actor {

	private static int score = 0;


	public void act(){

		this.setImage(new GreenfootImage("Score : " + score, 24, Color.WHITE,new Color(0,0,0,0)));


	}
	public static void addScore(){
		score++;
	}

	public static int getScore(){
		return score;
	}





}
