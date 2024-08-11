package demogame;

import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class MapGenerator {
    public int[][] map;
    public String[][] words;
    public int brickWidth;
    public int brickHeight;

    public MapGenerator(int row, int col, String chosenWord, ArrayList<String> synonyms, HashMap<String, ArrayList<String>> wordMap){
        map= new int[row][col];
        words= new String[row][col];

        Random random = new Random();
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                map[i][j]=1;

                // Randomly assign synonyms or other words
                if (random.nextBoolean()) {
                    words[i][j] = synonyms.get(random.nextInt(synonyms.size()));
                } else {
                    // Pick a random word that's not a synonym of chosenWord
                    String randomWord;
                    do {
                        randomWord = wordMap.keySet().toArray(new String[0])[random.nextInt(wordMap.size())];
                    } while (randomWord.equals(chosenWord) || synonyms.contains(randomWord));
                    words[i][j] = randomWord;
                }
            }
        }
        brickWidth=540/col;
        brickHeight=150/row;

    }

    public String getWord(int row, int col) {
        return words[row][col];
    }
    public void setBrick(int value, int r, int c){
        map[r][c]=value;

    }
    public void draw(Graphics2D g){
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j]>0){
                    g.setColor(Color.magenta);
                    g.fillRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);

                    g.setColor((Color.black));
                    g.setStroke(new BasicStroke(3));
                    g.drawRect(j*brickWidth+80,i*brickHeight+50,brickWidth,brickHeight);
                }
            }
        }


    }
}