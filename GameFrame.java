
/*Imports*/
import java.awt.*;
import javax.swing.*;

public class GameFrame extends JFrame{//This pulls in the methods from Jframe to then be used a little better

    GamePanel panel;

    GameFrame(){
        panel = new GamePanel();

        this.add(panel);
        this.setTitle("Pong Game");
        this.setResizable(false);
        this.setBackground(Color.BLACK);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//This closes the app instead of doing bullshit
        this.pack();//This will make this fit around the game panel so it does it automaticly so thats cool
        this.setLocationRelativeTo(null);//Makes the frame spawn in the middle of the screen
        this.setVisible(true);
    }
}
