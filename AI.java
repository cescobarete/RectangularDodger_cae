import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;
import java.util.Random;

public class AI implements Runnable {
    Rectangle AI, target;
    int xDir, yDir;
    boolean resting = false;
    boolean giveSetRandDir = true;

    public AI(Rectangle ai, Rectangle t) {
        AI = ai;
        target = t;
    }
    
    public void draw (Graphics g) {
        g.setColor(Color.BLUE);
        if(AI != null) {
            g.fillRect(AI.x,AI.y,AI.width,AI.height);
        }
    }

    public void findPathToTarget() {
        if(AI.x<target.x) {
            setXDir(1);
        }
        if(AI.x>target.x) {
            setXDir(-1);
        }
        if(AI.y<target.y) {
            setYDir(1);
        }
        if(AI.y>target.y) {
            setYDir(-1);
        }    
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
                if (!resting) {
                    long start = System.currentTimeMillis();
                    long end = start + 1*2000;
                    while (System.currentTimeMillis() < end) {
                        findPathToTarget();
                        move();
                        Thread.sleep(10);
                    }
                    resting = true;
                } else {
                    Thread.sleep(10);
                    giveSetRandDir = true;
                    resting = false;
                }
            }
        } catch(Exception ex) {
            System.err.println(ex.getMessage());
        }
    }
}
