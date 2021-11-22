package Java;
//This has the goals that will declare who got the point
import java.awt.*;

public class Goals extends Rectangle{
    //Basic variables
    final int GOAL_WIDTH = 30;
    final int GOAL_HEIGHT = 150;
    final Color GOAL_1 = new Color(255,0,0);
    final Color GOAL_2 = new Color(0,0,255);
    int GAME_WIDTH,GAME_HEIGHT, id;

    Goals(int width, int height, int id){
        this.GAME_WIDTH = width;
        this.GAME_HEIGHT = height;
        this.id = id;
    }

    //Drawing the goal
    public void draw(Graphics g){
        //Figuring out which goal it is
        switch(id){
            case 1:
                g.setColor(GOAL_1);
                g.fillRect(0,(GAME_HEIGHT/2)-(GOAL_HEIGHT/2),GOAL_WIDTH, GOAL_HEIGHT);
                break;
            case 2:
                g.setColor(GOAL_2);
                g.fillRect(GAME_WIDTH-GOAL_WIDTH, (GAME_HEIGHT/2)-(GOAL_HEIGHT/2),GOAL_WIDTH, GOAL_HEIGHT);
                break;
        }
    }
}
