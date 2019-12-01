/*
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.util.Random;

public class AI implements Runnable {
    Rectangle AI;

    int xDir, yDir;

    public AI(Rectangle ai) {
        AI = ai;
    }
    
    public void draw (Graphics g) {
        g.setColor(Color.BLUE);
        if(AI != null) {
            g.fillRect(AI.x,AI.y,AI.width,AI.height);
        }
    }

    public int chooseRandomDir() {
        Random r = new Random();
        int[] randDir = new int[3];
        randDir[0] = 0;
        randDir[1] = 1;
        randDir[2] = -1;
        int randChoice = r.nextInt(3);
        return randDir[randChoice];
    }

    public void setXDir(int dir) {
        xDir = dir;
    }
    
    public void setYDir(int dir) {
        yDir = dir;
    }

    public void move() {
        AI.x += xDir;
        AI.y += yDir;
    }

    public void run() {
        try {
            while(true) {

            }

        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
*/