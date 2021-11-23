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
    final int PLAYER_SIZE = 40;
    final Color PLAYER1_COLOR = new Color(255,0,0);
    final Color PLAYER2_COLOR = new Color(0,0,255);

    //Planning for instances(Note this is for the buidling process just to keep track so no one is confused :)
    Thread gameThread;//This is for runnable it makes a cool little thread for something
    Player player1;
    Player player2;
    Goals goal1;
    Goals goal2;
    Ball ball;
    Board board;
    
    public Game(){
        newComponents();

        
        gameThread = new Thread(this);//Making a thread
        gameThread.start();
    }
    
    /*Creating new objects*/
    public void newComponents(){
        board = new Board(GAME_WIDTH,GAME_HEIGHT);
        goal1 = new Goals(GAME_WIDTH,GAME_HEIGHT,1);
        goal2 = new Goals(GAME_WIDTH,GAME_HEIGHT,2);
        ball = new Ball(GAME_WIDTH,GAME_HEIGHT);
        player1 = new Player((GAME_WIDTH/2)-250, (GAME_HEIGHT/2)-(40/2),PLAYER_SIZE, 1);
        //player2 = new Player(((GAME_WIDTH/2)+250)-(40/2), (GAME_HEIGHT/2)-(40/2), 2);
    }
    //Updating/Drawing objects onto the panel
    public void paint(Graphics g){
        Image image = createImage(getWidth(),getHeight());
        Graphics graphics = image.getGraphics();

        draw(graphics);//Draws all of the components in the draw method

        g.drawImage(image, 0, 0, this);//This draws the image which should have all the components
    }

    public void draw(Graphics g){
        board.draw(g);
        goal1.draw(g);
        goal2.draw(g);
        ball.draw(g);
        player1.draw(g);
    }

    public void updatePanel(){
        checkInteractions();
        move();
        repaint();
    }

    public void checkInteractions(){

    }
    public void move(){
        ball.move();
        player1.move();
        //player2.move();
    }
    

    public void run() {
        while(true){
            try {//This should allow it to run 60 times a second
                Thread.sleep(34);
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
            player1.yVelocity = 10;
        }

        public void keyReleased(KeyEvent e) {

        }
}