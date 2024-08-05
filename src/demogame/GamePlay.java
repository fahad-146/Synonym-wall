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
    private int totalBricks=21;
    private Timer timer;
    private int delay=8;
    private int ballposX=410;
    private int ballposY=630;
    private int ballXdir=-1;
    private int ballYdir=-2;
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
    }

    private void moveLeft(){
        play=true;
        playerX-=20;

    }
    private void moveRight(){
        play=true;
        playerX+=20;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_LEFT){
            if(playerX<=0)
                playerX=0;
            else
                moveLeft();
        }
        if(e.getKeyCode()==KeyEvent.VK_RIGHT){
            if(playerX>=650){
                playerX=650;
            }
            else
                moveRight();
        }

        if(e.getKeyCode()==KeyEvent.VK_ENTER){
            if(!play){
                score=0;
                totalBricks=21;
                ballposX=410;
                ballposY=630;
                ballXdir=-1;
                ballYdir=-2;
                playerX=320;


                map = new MapGenerator(3,7);
            }
        }
        repaint();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(play){

            if(ballposX<=0){
                ballXdir=-ballXdir;
            }
            if(ballposY<=0){
                ballYdir=-ballYdir;
            }
            if(ballposX>=680){
                ballXdir=-ballXdir;
            }
            if(ballposY>=700){
                play=false;
            }

            Rectangle ballRect = new Rectangle(ballposX,ballposY,20,20);
            Rectangle paddleRect = new Rectangle(playerX,650,100,8);

            if(ballRect.intersects(paddleRect)){
                ballYdir=-ballYdir;
            }
            A:for(int i=0; i<map.map.length;i++){
                for(int j=0; j<map.map[0].length; j++){
                    if(map.map[i][j]>0){
                        int width = map.brickWidth;
                        int height = map.brickHeight;
                        int brickXpos= j*width+80;
                        int brickYpos = i*height+50;

                        Rectangle brickRect = new Rectangle(brickXpos, brickYpos, width, height);
                        if(ballRect.intersects(brickRect)){
                            map.setBrick(0,i,j);
                            totalBricks--;
                            score+=5;

                            if(ballposX+19<=brickXpos || ballposX+1>brickXpos+width)
                                ballXdir=-ballXdir;
                            else ballYdir=-ballYdir;

                            break A;
                        }
                    }
                }
            }

            ballposX+=ballXdir;
            ballposY+=ballYdir;
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
