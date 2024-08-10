package demogame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GamePlay extends JPanel implements ActionListener, KeyListener {

    private boolean play=false;
    private int score=0;
    private int totalBricks=15;
    private Timer timer;
    private int delay=8;
    private int ballposX=410;
    private int ballposY=630;
    private int ballXdir=-3;
    private int ballYdir=-6;
    private int playerX=350;
    private MapGenerator map;

    public GamePlay(){
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(true);

        timer = new Timer(delay, this);
        timer.start();

        map=new MapGenerator(3,5);

    }
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(1,1,1000,1000);

        //border
        g.setColor(Color.yellow);
        g.fillRect(0,0,700,5);
        g.fillRect(0,3,5,700);
        g.fillRect(682,0,5,700);

        //paddle
        g.setColor(Color.GREEN);
        g.fillRect(playerX,650,100,8);

        //ball
        g.setColor(Color.RED);
        g.fillOval(ballposX,ballposY,20,20);

        //bricks
        map.draw((Graphics2D)g);

        g.setColor(Color.green);
        g.setFont(new Font("Serif", Font.BOLD,20));
        g.drawString("SCORE :"+ score, 550, 30);

        //game over
        if(ballposY>665){
            play=false;
            ballXdir=0;
            ballYdir=0;

            g.setColor(Color.green);
            g.setFont(new Font("serif", Font.BOLD,30));
            g.drawString("GAME OVER !!  Score: "+score,200,350);
            g.drawString("Press Enter to restart the game", 200,450);
        }

        //game won
        if(totalBricks<=0){
            play=false;
            ballXdir=0;
            ballYdir=0;

            g.setColor(Color.green);
            g.setFont(new Font("serif", Font.BOLD,30));
            g.drawString("Won this stage, great !!  Score: "+score,200,350);
            g.drawString("Press Enter to restart the game", 200,450);
        }
    }

    private void moveLeft(){
        play=true;
        playerX-=30;

    }
    private void moveRight(){
        play=true;
        playerX+=30;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(playerX<=5)
                playerX=5;
            else
                moveLeft();
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(playerX>=600){
                playerX=600;
            }
            else
                moveRight();
        }

        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            if(!play){
                score=0;
                totalBricks=15;
                ballposX=410;
                ballposY=630;
                ballXdir=-3;
                ballYdir=-6;
                playerX=350;


                map = new MapGenerator(3,5);
            }
        }
        repaint();

    }


    @Override



    public void actionPerformed(ActionEvent e) {
        if (play) {
            if (ballposX <= 5) ballXdir = -ballXdir;
            if (ballposY <= 10) ballYdir = -ballYdir;
            if (ballposX >= 657) ballXdir = -ballXdir;
            if (ballposY >= 700) play = false;

            Rectangle ballRect = new Rectangle(ballposX, ballposY, 20, 20);
            Rectangle paddleRect = new Rectangle(playerX, 650, 100, 8);

            if (ballRect.intersects(paddleRect)) {
                // Calculate where the ball hit the paddle
                int paddleCenter = playerX + 50; // Center of the paddle
                int ballCenter = ballposX + 10; // Center of the ball
                int hitPosition = ballCenter - paddleCenter;

                // Normalize hit position to a range between -1 and 1
                double normalizedHitPosition = (double) hitPosition / 50.0;

                // Adjust the ball's X direction based on the hit position
                ballXdir = (int) (normalizedHitPosition * 4);
                if(hitPosition==0){
                    ballYdir= -ballYdir*50;
                }
                else ballYdir = -ballYdir;
            }

            // Check brick collisions
            A: for (int i = 0; i < map.map.length; i++) {
                for (int j = 0; j < map.map[0].length; j++) {
                    if (map.map[i][j] > 0) {
                        int width = map.brickWidth;
                        int height = map.brickHeight;
                        int brickXpos = j * width + 80;
                        int brickYpos = i * height + 50;

                        Rectangle brickRect = new Rectangle(brickXpos, brickYpos, width, height);
                        if (ballRect.intersects(brickRect)) {
                            map.setBrick(0, i, j);
                            totalBricks--;
                            score += 5;

                            // Determine the collision side
                            if(ballposX+19<=brickXpos || ballposX+1>brickXpos+width)
                                ballXdir=-ballXdir;
                            else ballYdir=-ballYdir;

                            break A;
                        }
                    }
                }

            }

            ballposX += ballXdir;
            ballposY += ballYdir;
        }
        repaint();
    }








    @Override
    public void keyTyped(KeyEvent e) {

    }



    @Override
    public void keyReleased(KeyEvent e) {

    }
}
