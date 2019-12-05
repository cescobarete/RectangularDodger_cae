    import javax.swing.JFrame;
    import javax.swing.JPanel;
    import javax.swing.JButton;
    import javax.swing.Timer;

    import java.awt.event.KeyEvent;
    import java.awt.event.KeyListener;
    import java.awt.event.ActionListener;
    import java.awt.event.ActionEvent;

    import java.awt.Graphics;
    import java.awt.Color;
    import java.awt.Container; 
    import java.awt.GridLayout;
    import java.awt.BorderLayout;
    import java.awt.Rectangle;

    import java.util.Random;
    import java.util.ArrayList;

    class RectangularDodger extends JPanel implements ActionListener, KeyListener {
        Timer tm = new Timer(5, this);
        int x=0,y=0,speedX=0,speedY=0;
        private int red, green, blue;

        static Rectangle player = new Rectangle(100,100,100,100);
        static Rectangle object = new Rectangle(375,375,25,25);

        static AI AI = new AI(object, player);

        RectangularDodger() {
            tm.start();

            addKeyListener(this);
            setFocusable(true);
            setFocusTraversalKeysEnabled(false);
            SetRandomValues();
        }

    final public void SetRandomValues() {
        red=GetNumberBetween(0,255);
        green=GetNumberBetween(0,255);
        blue=GetNumberBetween(0,255);
    }
    //Randomization for colors
    public static int GetNumberBetween(int min, int max) {
        Random rand = new Random();
        return min + rand.nextInt(max-min+1);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(red,green,blue));
        g.fillRect(player.x,player.y,50,30);
        AI.draw(g);
    }
    
    //Determine boundaries for rectangle
    public void actionPerformed(ActionEvent e) {
        if(player.x<0) {
            speedX=0;
            player.x=0;
        }
       
        if(player.x>1317) {
            speedX=0;
            player.x=1317;
        }
        
        if(player.y<0) {
            speedY=0;
            player.y=0;
        }
        
        if(player.y>675) {
            speedY=0;
            player.y=675;
        }
        
        player.x=player.x+speedX;
        player.y=player.y+speedY;
    
        repaint();
    }
    //Gives the direction of what key you pressed
    public void keyPressed(KeyEvent e) {
        int c=e.getKeyCode();

        if(c==KeyEvent.VK_LEFT) {
            speedX=-6;
            speedY=0;
        }
        if(c==KeyEvent.VK_UP) {
            speedX=0;
            speedY=-6;
        }
        if(c==KeyEvent.VK_RIGHT) {
            speedX=6;
            speedY=0;
        }
        if(c==KeyEvent.VK_DOWN) {
            speedX=0;
            speedY=6;
        }
    }

    public void keyTyped(KeyEvent e) {}
    //Rect will keep moving unless givin a key released to tell it to stop
    public void keyReleased(KeyEvent e) {
        speedX=0;
        speedY=0;
    }
     
    class RectangleFrame extends JFrame implements Runnable {
        RectangleFrame() {
            setDefaultLookAndFeelDecorated(true);
            setBounds(200,10,800,800);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            RectangularDodger r = new RectangularDodger();
            add(r);
        }
        public void run(){}
    }

    public static void main(String[] args) {
        System.out.println("\nRectangularDodger Starting...");
        System.out.println("\nWelcome to Rectangular Dodger");
        System.out.println("\nUse UP, DOWN, RIGHT and LEFT arrow keys to move rectangle.");
        System.out.println("Avoid CPU when it chases you down.");
        System.out.println("");
        
        Thread t1 = new Thread(AI);
        t1.start();
        
        RectangularDodger rD = new RectangularDodger();
        RectangleFrame myFrame = rD.new RectangleFrame();
        myFrame.setTitle("Rectangular Dodger");
        myFrame.setVisible(true);
    }
}
    

