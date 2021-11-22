package Java;
//This will have the player scripts to draw them
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class Player {
    int GAME_WIDTH, GAME_HEIGHT, player;
    final int PLAYER_SIZE = 40;
    final Color player1 = new Color(255,0,0);
    final Color player2 = new Color(0,0,255);
    int x, y;

    Player(int GAME_WIDTH,int GAME_HEIGHT, int player){
        this.GAME_HEIGHT = GAME_HEIGHT;
        this.GAME_WIDTH = GAME_WIDTH;
        this.player = player;

        if(player == 1){//Setting first position
            this.x = (GAME_WIDTH/2)-250;
            this.y = (GAME_HEIGHT/2)-(PLAYER_SIZE/2);
        }else{
            this.x = ((GAME_WIDTH/2)+250)-(PLAYER_SIZE/2);
            this.y = (GAME_HEIGHT/2)-(PLAYER_SIZE/2);
        }
    }

    public void setDirection(int xVelocity, int yVelocity){

    }

    public void draw(Graphics g){
        switch(player){
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
