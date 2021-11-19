package Java;
//This file runs all the main scripts needed to run the game

/*Imports*/
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Game extends JPanel {
    //Basic Game Variables
    final Color FIELD = new Color(0,128,0);
    final Dimension SCREEN_SIZE = new Dimension(1000,550);
    
    
    public Game(){
        //Setting up panel
        this.setPreferredSize(SCREEN_SIZE);
        this.setBackground(FIELD);
    }

    //@Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
  
        Graphics2D g2 = (Graphics2D)g;
        g2.setColor(Color.CYAN);
        g2.fillRect(500, 275, 100, 50);
    }
}
