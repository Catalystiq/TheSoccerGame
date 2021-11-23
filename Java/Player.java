package Java;
//This will have the player scripts to draw them
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Player extends Rectangle{
    int GAME_WIDTH, GAME_HEIGHT;
    final int PLAYER_SIZE = 40;
    final Color player1 = new Color(255,0,0);
    final Color player2 = new Color(0,0,255);
    //int x, y;
    int xVelocity, yVelocity;
    int speed = 10;
    int id;

    Player(int x,int y, int id){
        super(x,y);
        this.id = id;
        this.x = x;
        this.y = y;
    }

    

    public void keyPressed(KeyEvent e){
        switch(id) {
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W){
                    System.out.println("test");
                    setYDirection(-speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setYDirection(speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    setXDirection(-speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    setXDirection(speed);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setYDirection(-speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setYDirection(speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    setXDirection(-speed);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    setXDirection(speed);
                    move();
                }
                break;
        }
    }
    public void keyReleased(KeyEvent e) {
        switch(id) {
            case 1:
                if(e.getKeyCode()==KeyEvent.VK_W){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_S){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_A){
                    setXDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_D){
                    setXDirection(0);
                    move();
                }
                break;
            case 2:
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_DOWN){
                    setYDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_LEFT){
                    setXDirection(0);
                    move();
                }
                if(e.getKeyCode()==KeyEvent.VK_RIGHT){
                    setXDirection(0);
                    move();
                }
                break;
        }
    }

    public void setYDirection(int yDirection){
        yVelocity = yDirection;
    }
    public void setXDirection(int xDirection){
        xVelocity = xDirection;
    }
    public void move(){
        y += yVelocity;
        x += xVelocity;
    }

    public void draw(Graphics g){
        switch(id){
            case 1:
                g.setColor(player1);
            break;
            case 2:
                g.setColor(player2);
            break;
        }


        //Drawing
        g.fillRect(x, y, PLAYER_SIZE,PLAYER_SIZE);
    }
}
