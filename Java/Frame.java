package Java;
//This file will create the frame and hold the splash and the start screen

/*Imports8*/
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.concurrent.TimeUnit;

import javax.swing.*;

public class Frame{
   
   
   Frame(){
      //Calling classes
      Splash spPanel = new Splash();
      
      //Making our components
      JFrame frame= new JFrame();
      JPanel splashPanel = new JPanel();
      JPanel gamePanel = new JPanel();
      
      //Default settings
      frame.setResizable(false);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setVisible(true);

      //Splash screen
      frame.add(splashPanel);
      frame.setTitle("24/7 Studios");
      frame.setLocationRelativeTo(null);
      frame.setBackground(Color.BLACK);
      splashPanel.add(spPanel.splashImg);
      frame.pack();
      frame.repaint();
      
      //I guess we needed a try and catch thing so yeah this exits, but really only to wait a couple of seconds
      try {
         Thread.sleep(5000);//Splash Screen cooldown
      } catch (Exception e) {
         System.out.println(e);
      }

      frame.remove(splashPanel);//Removing the splash panel
      
      //Setting up the new Game Board
      gamePanel = new Game();//Importing a panel from a class
      frame.add(gamePanel);
      frame.setTitle("24/7 Studios");
      frame.setLocationRelativeTo(null);
      frame.pack();

      
      frame.invalidate();
      frame.validate();
   }
}