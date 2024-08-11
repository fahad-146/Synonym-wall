package demogame;

import javax.swing.*;

public class MainClass {
    public static void main(String [] args){
        JFrame f = new JFrame();
        f.setTitle("Synonym wall");
        f.setBounds(0,0,700,700);
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setVisible(true);
        f.setResizable(false);


        GamePlay gamePlay = new GamePlay();
        f.add(gamePlay);


    }
}