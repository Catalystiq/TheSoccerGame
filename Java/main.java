package Java;
/*This is the main file that creates the frame for everything to run*/
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class main {

    //Basic Game Variables
    static final int GAME_HEIGHT = 550;
    static final int GAME_WIDTH = 1000;
    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH,GAME_HEIGHT);//Making it into a Diemension form for the pannal
    static final Color FIELD = new Color(0,153,0);
    
    public static void main(String args[]){
      //Calling classes
      Splash spPanel = new Splash();
      
      //Making our components
      JFrame frame= new JFrame();
      JPanel splashPanel = new JPanel();
      JPanel gamePanel = new JPanel();
      
      //Default settings
      frame.setResizable(false);
      frame.setLocationRelativeTo(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);

      //Splash screen
      frame.add(splashPanel);
      frame.setTitle("24/7 Studios");
      frame.setLocationRelativeTo(null);
      frame.setBackground(Color.BLACK);
      splashPanel.add(spPanel.splashImg);
      frame.pack();
      
      //I guess we needed a try and catch thing so yeah this exits, but really only to wait a couple of seconds
      try {
         Thread.sleep(5000);//Splash Screen cooldown
      } catch (Exception e) {
         System.out.println(e);
      }

      frame.remove(splashPanel);//Removing the splash panel
      
      //Setting up the new Game Board
      gamePanel = new Game();//Importing a panel from a class
      frame.addKeyListener(new Game());
      gamePanel.setFocusable(true);
      gamePanel.setPreferredSize(SCREEN_SIZE);
      gamePanel.setBackground(FIELD);
      frame.add(gamePanel);
      frame.setTitle("The Soccer Game");
      frame.setLocationRelativeTo(null);
      frame.pack();
   }
}