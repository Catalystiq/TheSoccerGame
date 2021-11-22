package Java;
//This is the ball and all of its moving stuff
import java.awt.*;

public class Ball {
    int GAME_WIDTH,GAME_HEIGHT;
    int x,y;
    final int BALL_SIZE = 20;

    Ball(int width, int height){
        this.GAME_WIDTH = width;
        this.GAME_HEIGHT = height;

        x = (GAME_WIDTH/2)-(BALL_SIZE/2);
        y = (GAME_HEIGHT/2)-(BALL_SIZE/2);
    }

    public void setDirection(int xVelocity, int yVelocity){//Setting the location of the ball
        x += xVelocity;
        y +=yVelocity;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x, y,BALL_SIZE,BALL_SIZE);
    }
}
