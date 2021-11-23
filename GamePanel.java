
/*Imports*/
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class GamePanel extends JPanel implements Runnable {

    static final int GAME_WIDTH = 1000;// Alright so the reason that there is a static and final is to make sure
                                       // everything is just one variable and does not turn into many
    static final int GAME_HEIGHT = 556;

    static final Dimension SCREEN_SIZE = new Dimension(GAME_WIDTH, GAME_HEIGHT);// WTF

    static final int BALL_DIAMETER = 20;// Setting demesions for the objects in the game
    static final int PADDLE_WIDTH = 25;
    static final int PADDLE_HEIGHT = 100;

    //Planning instances
    Thread gameThread;
    Image image;
    Graphics graphics;
    Random random;
    Paddle paddle1;
    Paddle paddle2;
    Ball ball;
    Score score;

    GamePanel() {
        newPaddles();
        newBall();
        score = new Score(GAME_WIDTH,GAME_HEIGHT);
        this.setFocusable(true);
        this.addKeyListener(new AL());
        this.setPreferredSize(SCREEN_SIZE);

        gameThread = new Thread(this);//Making a thread
        gameThread.start();
    }

    public void newBall() {
        random = new Random();
        ball = new Ball((GAME_WIDTH/2)-(BALL_DIAMETER/2),random.nextInt(GAME_HEIGHT-BALL_DIAMETER),BALL_DIAMETER,BALL_DIAMETER);//x,y,w,h
    }

    public void newPaddles() {
        //Calling new paddles using the instances and the constructer to make it fast and shit
        paddle1 = new Paddle(0,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,1);//X,Y,W,H
        paddle2 = new Paddle(GAME_WIDTH-PADDLE_WIDTH,(GAME_HEIGHT/2)-(PADDLE_HEIGHT/2),PADDLE_WIDTH,PADDLE_HEIGHT,2);//X,Y,W,H
    }

    public void paint(Graphics g) {
        image = createImage(getWidth(),getHeight());
        graphics = image.getGraphics();

        draw(graphics);

        g.drawImage(image, 0, 0, this);
    }

    public void draw(Graphics g) {
        paddle1.draw(g);
        paddle2.draw(g);
        ball.draw(g);
        score.draw(g);
    }

    public void move() {
        paddle1.move();
        paddle2.move();
        ball.move();
    }

    public void checkCollision() {
        
        //Bounce of the paddle
        if(ball.intersects(paddle1)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;//Makes the ball speed up a little

            if(ball.yVelocity>0){
                ball.yVelocity++;//Again more speed
            }else{
                ball.yVelocity--;
            }
            ball.setXDirection(ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        if(ball.intersects(paddle2)){
            ball.xVelocity = Math.abs(ball.xVelocity);
            ball.xVelocity++;//Makes the ball speed up a little

            if(ball.yVelocity>0){
                ball.yVelocity++;//Again more speed
            }else{
                ball.yVelocity--;
            }
            ball.setXDirection(-ball.xVelocity);
            ball.setYDirection(ball.yVelocity);
        }
        
        //To bounce the ball of walls
        if(ball.y <=0){
            ball.setYDirection(-ball.yVelocity);
        }else if(ball.y >= GAME_HEIGHT-BALL_DIAMETER){
            ball.setYDirection(-ball.yVelocity);
        }
        
        //Stops the paddles on the windows edges
        if(paddle1.y<=0){//Checking paddle 1 if its on edge
            paddle1.y=0;
        }else if(paddle1.y >= (GAME_HEIGHT-PADDLE_HEIGHT)){
            paddle1.y = GAME_HEIGHT-PADDLE_HEIGHT;
        }
        if(paddle2.y<=0){//Checking paddle 2 if its on edge
            paddle2.y=0;
        }else if(paddle2.y >= (GAME_HEIGHT-PADDLE_HEIGHT)){
            paddle2.y = GAME_HEIGHT-PADDLE_HEIGHT;
        }

        //This will give points and stuff and resets the game
        if(ball.x <0){//Player 2 has point
            score.player2++;
            newPaddles();
            newBall();
        }
        if(ball.x >= GAME_WIDTH-BALL_DIAMETER){//player 1 gets some points
            score.player1++;
            newPaddles();
            newBall();
        }
    }

    public void run() {
        //game loop
        long lastTime = System.nanoTime();//This makes a long value of shit
        double amountOfTicks = 60.0;
        double ns = 1000000000/amountOfTicks;
        double delta = 0;

        while(true){
            long now = System.nanoTime();
            delta += (now-lastTime)/ns;
            lastTime = now;
            if(delta >=1){
                move();
                checkCollision();
                repaint();
                delta--;
            }
        }
    }

    public class AL extends KeyAdapter {
        public void keyPressed(KeyEvent e) {
            paddle1.keyPressed(e);
            paddle2.keyPressed(e);
        }

        public void keyReleased(KeyEvent e) {
            paddle1.keyReleased(e);
            paddle2.keyReleased(e);
        }
    }
}
