package Java;
//This is the ball and all of its moving stuff
import java.awt.*;

public class Ball {
    int GAME_WIDTH,GAME_HEIGHT;
    int x,y, xVelocity, yVelocity;
    double loss = .05;
    final int BALL_SIZE = 20;

    Ball(int width, int height){
        this.GAME_WIDTH = width;
        this.GAME_HEIGHT = height;

        x = (GAME_WIDTH/2)-(BALL_SIZE/2);
        y = (GAME_HEIGHT/2)-(BALL_SIZE/2);
        
        xVelocity = 10;
        yVelocity = -10;
    }

    public void move(){//Setting the location of the ball
        
        if(xVelocity>1){
            xVelocity-=loss;
        }else if(xVelocity<=1 && xVelocity >=-1){
            xVelocity=0; 
        }else{
            xVelocity += loss;
        }
        
        if(yVelocity>1){
            yVelocity-=loss;
        }else if(yVelocity<=1 && yVelocity >=-1){
            yVelocity=0; 
        }else{
            yVelocity += loss;
        }
        
        
        
        //Setting the x and y
        x += xVelocity;
        y +=yVelocity;
    }

    public void draw(Graphics g){
        g.setColor(Color.white);
        g.fillOval(x, y,BALL_SIZE,BALL_SIZE);
    }
}
