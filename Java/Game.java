package Java;
//This file runs all the main scripts needed to run the game

/*Imports*/
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Game extends JPanel implements Runnable, KeyListener{
    //Basic Panel Info for future needs
    static final int GAME_HEIGHT = 550;
    static final int GAME_WIDTH = 1000;
    
    //player values
    static final int PLAYER_SIZE = 50;
    static final Color PLAYER1_COLOR = new Color(255,0,0);
    static final Color PLAYER2_COLOR = new Color(0,0,255);
    static final int speed = 10;
    
    //Player location data
    static int player1X,player1Y,player1XVelocity,player1YVelocity;
    static int player2X,player2Y,player2XVelocity,player2YVelocity;

    //Planning for instances(Note this is for the buidling process just to keep track so no one is confused :)
    Thread gameThread;//This is for runnable it makes a cool little thread for something
    
    
    public Game(){
        newComponents();

        
        gameThread = new Thread(this);//Making a thread
        gameThread.start();
    }
    
    /*Creating new objects*/
    public void newComponents(){
        //Setting the initial position
        player1X = 200;
        player1Y = (GAME_HEIGHT/2)-(PLAYER_SIZE/2);
        
        player2X = 800-PLAYER_SIZE;
        player2Y = (GAME_HEIGHT/2)-(PLAYER_SIZE/2);
    }
    //Updating/Drawing objects onto the panel
    public void paint(Graphics g){
        
        //Drawing player 1
        g.setColor(PLAYER1_COLOR);
        g.fillRect(player1X,player1Y,PLAYER_SIZE,PLAYER_SIZE);
        
        //Drawing player 2
        g.setColor(PLAYER2_COLOR);
        g.fillRect(player2X,player2Y,PLAYER_SIZE,PLAYER_SIZE);
    }

    public void updatePanel(){
        checkInteractions();
        move();
        repaint();
    }

    public void checkInteractions(){
      
      //This is for the wall for the players so they dont go past
      if(player1X <= 0){//Player 1
         player1XVelocity = 1;
      }
      if((player1X+PLAYER_SIZE) >= GAME_WIDTH){
         player1XVelocity = -1;
      }
      if(player1Y <= 0){
         player1YVelocity = 1;
      }
      if((player1Y+PLAYER_SIZE) >= GAME_HEIGHT){
         player1YVelocity = -1;
      }
      
      if(player2X <= 0){//Player 2
         player2XVelocity = 1;
      }
      if((player2X+PLAYER_SIZE) >= GAME_WIDTH){
         player2XVelocity = -1;
      }
      if(player2Y <= 0){
         player2YVelocity = 1;
      }
      if((player2Y+PLAYER_SIZE) >= GAME_HEIGHT){
         player2YVelocity = -1;
      }
      
      //Checking if the player is touching eachother
    }
    public void move(){
        player1Y += player1YVelocity;
        player1X += player1XVelocity;
        
        player2Y += player2YVelocity;
        player2X += player2XVelocity;
    }
    

    public void run() {
        while(true){
            try {//This should allow it to run 60 times a second
                Thread.sleep(17);
            } catch (Exception e) {
                System.out.println("UM your in some deep crap buddy"+e);
            }

            updatePanel();
        }
    }
    
    //Key listener
        public void keyTyped(KeyEvent e){
            
        }

        public void keyPressed(KeyEvent e) {
            if(e.getKeyCode()==KeyEvent.VK_W){
               player1YVelocity = -speed;
            }
            if(e.getKeyCode()==KeyEvent.VK_S){
               player1YVelocity = speed;
            }
            if(e.getKeyCode()==KeyEvent.VK_A){
               player1XVelocity = -speed;
            }
            if(e.getKeyCode()==KeyEvent.VK_D){
               player1XVelocity = speed;
            }
            
            if(e.getKeyCode()==KeyEvent.VK_UP){
               player2YVelocity = -speed;
            }
            if(e.getKeyCode()==KeyEvent.VK_DOWN){
               player2YVelocity = speed;
            }
            if(e.getKeyCode()==KeyEvent.VK_LEFT){
               player2XVelocity = -speed;
            }
            if(e.getKeyCode()==KeyEvent.VK_RIGHT){
               player2XVelocity = speed;
            }
        }

        public void keyReleased(KeyEvent e) {
         if(e.getKeyCode()==KeyEvent.VK_W){
               player1YVelocity = 0;
            }
            if(e.getKeyCode()==KeyEvent.VK_S){
               player1YVelocity = 0;
            }
            if(e.getKeyCode()==KeyEvent.VK_A){
               player1XVelocity = 0;
            }
            if(e.getKeyCode()==KeyEvent.VK_D){
               player1XVelocity = 0;
            }
            
            if(e.getKeyCode()==KeyEvent.VK_UP){
               player2YVelocity = 0;
            }
            if(e.getKeyCode()==KeyEvent.VK_DOWN){
               player2YVelocity = 0;
            }
            if(e.getKeyCode()==KeyEvent.VK_LEFT){
               player2XVelocity = 0;
            }
            if(e.getKeyCode()==KeyEvent.VK_RIGHT){
               player2XVelocity = 0;
            }
        }
}