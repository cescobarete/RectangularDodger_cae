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

    import java.util.Random;
    import java.util.ArrayList;

    class RectangularDodger extends JPanel implements ActionListener, KeyListener {
        Timer tm = new Timer(5, this);
        int x=380,y=380,speedX=0,speedY=0;
        private int red, green, blue;
        
        RectangularDodger() {
            tm.start();
            
            //Container contentPane = getContentPane();
            //contentPane.setLayout(new BorderLayout());
        
            //JPanel buttonPanel = new JPanel();
            //contentPane.add(buttonPanel, BorderLayout.SOUTH);

            //JButton randomize = new JButton("Randomize");
            //buttonPanel.add(randomize);
            //randomize.addActionListener(this);

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
    private static int GetNumberBetween(int min, int max) {
        Random rand = new Random();
        return min + rand.nextInt(max-min+1);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(red,green,blue));
        g.fillRect(x,y,50,30);
    }
    //Determine boundaries for rectangle
    public void actionPerformed(ActionEvent e) {
        
        if(x<0) {
            speedX=0;
            x=0;
        }
       
        if(x>1315) {
            speedX=0;
            x=1315;
        }
        
        if(y<0) {
            speedY=0;
            y=0;
        }
        
        if(y>675) {
            speedY=0;
            y=675;
        }
        
        x=x+speedX;
        y=y+speedY;
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
    //class RectangleFrame extends JFrame implements Runnable 
    class RectangleFrame extends JFrame {
        //static Rectangle object = new Rectangle(375,375,25,25);
        //static AI AI = new AI(object);

        RectangleFrame() {
            setDefaultLookAndFeelDecorated(true);
            setBounds(200,10,800,800);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            RectangularDodger r = new RectangularDodger();
            add(r);
        }
    }
    public static void main(String[] args) {
        System.out.println("\nRectangularDodger Starting...");
        System.out.println("\nWelcome to Rectangular Dodger");
        System.out.println("\nUse UP, DOWN, RIGHT and LEFT arrow keys to move rectangle.");
        
        //RectangularDodger main = new RectangularDodger();
        //Thread t = new Thread(main);
        //t.start();
        //Thread t1 = new Thread(AI);
        //t1.start();

        RectangularDodger rD = new RectangularDodger();
        RectangleFrame myFrame = rD.new RectangleFrame();
        myFrame.setTitle("Rectangular Dodger");
        myFrame.setVisible(true);
    }
}
    

