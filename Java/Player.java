package Java;
//This will have the player scripts to draw them
import java.awt.*;
import java.awt.event.*;

public class Player extends Rectangle{

	int player;
	int yVelocity,xVelocity;
	int speed = 10;

    //player colors
    final Color PLAYER1_COLOR = new Color(255,0,0);
    final Color PLAYER2_COLOR = new Color(0,0,255);
	
	Player(int xStart, int yStart,int player_size, int player){
		super(xStart,yStart,player_size,player_size);
		this.player=player;
	}
	

	public void move() {
		super.y= super.y + yVelocity;
        System.out.println(y);
	}
	public void draw(Graphics g) {
		System.out.println(y);
        g.setColor(Color.red);
		
        
        g.fillRect(x, y,width,height);
	}
}
