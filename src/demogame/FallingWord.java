package demogame;

import java.awt.*;

public class FallingWord {
    private String word;
    private int x, y;
    private boolean synonym;
    private static final int FALL_SPEED = 1;

    public FallingWord(String word, int x, int y,boolean synonym) {
        this.word = word;
        this.x = x;
        this.y = y;
        this.synonym = synonym;
    }

    public void update() {
        y += FALL_SPEED;
    }

    public void draw(Graphics g) {
        g.setColor(Color.white);
        g.setFont(new Font("Arial", Font.PLAIN, 20));
        g.drawString(word, x, y);
    }

    public int getY() {
        return y;
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, word.length() * 10, 20);
    }

    public boolean isSynonym() {
        return synonym;
    }
}
