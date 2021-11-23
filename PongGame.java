
/*Imports*/
import javax.swing.*;

public class PongGame extends JFrame{
    public static void main(String[] args){
        ImageIcon pong = new ImageIcon("./img/pong.png");
        JOptionPane.showMessageDialog(null,
               "Splash Screen", "ThePongGame",
               JOptionPane.INFORMATION_MESSAGE, pong);

        GameFrame frame = new GameFrame();    
    }
}