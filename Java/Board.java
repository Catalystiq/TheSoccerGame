package Java;
//This file handles of displaying some decoration type things along with the score of the game
import java.awt.*;

public class Board extends Rectangle{
    final Color FIELD = new Color(0,128,0);//Background for game
    final Font SCORE_FONT = new Font("Dialog", 1,60);
    
    final int GOAL_WIDTH = 30;
    final int GOAL_HEIGHT = 200;
    final Color GOAL_1 = new Color(255,0,0);
    final Color GOAL_2 = new Color(0,0,255);
    
    int GAME_WIDTH,GAME_HEIGHT,player1,player2;//Some data for the screen and keeping trake of the player points

    Board(int GAME_WIDTH, int GAME_HEIGHT){//This switches the input over to local variables to be used
        this.GAME_WIDTH = GAME_WIDTH;
        this.GAME_HEIGHT = GAME_HEIGHT;
    }

    public void draw(Graphics g){
        //Building the field
        g.setColor(FIELD);
        g.fillRect(0, 0,GAME_WIDTH,GAME_HEIGHT);//This draws the background of the screen

        //extra details
        g.setColor(Color.white);
        g.drawLine(GAME_WIDTH/2,0,GAME_WIDTH/2,GAME_HEIGHT);

        //Drawing Scores
        g.setColor(Color.WHITE);
        g.setFont(SCORE_FONT);
        g.drawString(String.valueOf(player1), (GAME_WIDTH/2)-75, 75);//Players 1 score
        g.drawString(String.valueOf(player2), (GAME_WIDTH/2)+35, 75);//Players 2 score
    }
}
