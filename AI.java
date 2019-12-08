import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Graphics;

public class AI implements Runnable {
    Rectangle AI, target;
    int xDir, yDir;
    boolean resting = false;
    boolean giveSetRandDir = true;
    
    AI(Rectangle ai, Rectangle t) {
        AI = ai;
        target = t;
    }
    
    public void draw (Graphics g) {
        g.setColor(Color.BLUE);
        if(AI != null) {
            g.fillRect(AI.x,AI.y,AI.width,AI.height);
        }
    }
    //Searches for target and runs the path to get to it
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
    //allows AI to move with x or y = x or y + xDir or yDir
    public void move() {
        AI.x += xDir;
        AI.y += yDir;
    }
    //determines how long it will stay resting 
    public void run() {
        try {
            while(true) {
                if (!resting) {
                    long start = System.currentTimeMillis();
                    //determines how far object will move before end
                    long end = start + 1*2000;
                    while (System.currentTimeMillis() < end) {
                        findPathToTarget();
                        move();
                        Thread.sleep(10);
                    }
                    resting = true;
                //when path is found set the direction and start moving 
                } else {
                    Thread.sleep(10);
                    giveSetRandDir = true;
                    resting = false;
                }
            }
        } catch(Exception ex) {
            System.err.println("Error");
        }
    }
}
