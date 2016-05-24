import java.awt.image.BufferedImage;
import javax.swing.JComponent;
import javax.swing.JPanel;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.*;
import java.io.IOException;
import java.awt.*;
import javax.swing.ButtonGroup;
import java.awt.event.*;
import java.util.*;
import java.awt.font.TextAttribute;
import java.awt.GraphicsEnvironment;
import javax.swing.JComponent;
import javax.swing.JFrame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import java.io.IOException;
import javax.swing.Timer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.Random;

public class Board extends JComponent implements ActionListener 
{
    int a;
    public static JFrame all;
    Alien alien;
    static SpaceShip ship;
    static SpaceShip life1;
    static SpaceShip life2;
    static SpaceShip life3;
    //ArrayList<Alien> army;
    //ArrayList<Rocket> barage; 
    static Timer tA;
    static JLabel score;
    int x;
    Random r;
    static int p;
    static int l;
    int z;
    //ImageIcon[][] alienArmy;

    public Board(int x)
    {
        p= 0;
        l=3;
        z=x;
        r= new Random();
        all = new JFrame();
        all.setResizable(false);
        all.setSize(400,420);
        ship = new SpaceShip(200,350);
        life1 = new SpaceShip(250,10);
        life2 = new SpaceShip(300,10);
        life3= new SpaceShip(350,10);
        //army = new ArrayList<Alien>();
        //barage = new ArrayList<Rocket>();
        tA=new Timer(z,this);
        AlienManager.initialize();
        BlockManager.initialize();
        //board = new JPanel();
        //alien = new JLabel(alien1);
        //alien1 = new ImageIcon("Unknown.png");
        //ImageIcon = new ImageIcon[5][11];
        //         try {// allows you to test a block of code and then check for errors(as image imports usually throw and error)
        //             alien = ImageIO.read(new File("Unknown.png"));// accesses image stored within the local folder
        //         } catch (IOException e) {// allows you to catch a specific error without compile type errors. In the case of image imports 'IOException e'
        //         }

    }

    public void paintComponent(Graphics g) {// method inherited from the JComponent project

    }

    public void drawAliens()
    {
        for(int i = 0; i<AlienManager.army.size(); i++) 
        {
            all.add(AlienManager.army.get(i));
            all.setVisible(true);
        }
    }

    public void drawBarriers()
    {
        for(int i = 0; i<BlockManager.barrier.size(); i++) 
        {
            all.add(BlockManager.barrier.get(i));
            all.setVisible(true);
        }
    }

    public void createBoard() 
    {
        all.getContentPane().setBackground( Color.BLACK );
        a=0;
        class MoveListener implements KeyListener{
            public void keyPressed(KeyEvent e){
                switch (e.getKeyCode()){
                    case KeyEvent.VK_LEFT:{
                        ship.left(2);
                        break;

                    }
                    case KeyEvent.VK_RIGHT:{ 
                        ship.right(2);
                        break;

                    }

                }
            }

            public void keyTyped(KeyEvent e){}

            public void keyReleased(KeyEvent e){
                switch (e.getKeyCode()){            
                    case KeyEvent.VK_LEFT:{
                        ship.stop();
                        break;
                    }
                    case KeyEvent.VK_RIGHT:{ 
                        ship.stop();
                        break;

                    }

                    case KeyEvent.VK_SPACE:{ 

                        if(a%2==0){
                            Rocket r = new Rocket(ship.getXPos(),ship.getYPos());
                            all.add(r);
                            all.setVisible(true);

                            //barage.add(r);

                            break;

                        }
                    }
                }
            }
        }

        //         for( int i = 30; i<350; i=i+20){
        //             for (int j = 40;j<150; j=j+20) 
        //             {
        //                 army.add(new Alien(i,j));
        //             }
        //         }

        this.drawAliens();
        this.

        drawBarriers();

        score=new JLabel(" "+ p);
        score.setForeground(Color.GREEN);

        all.add(score);
        all.setVisible(true);
        all.add(this);
        all.setVisible(true);// sets to visible
        all.addKeyListener(new MoveListener());

        all.add(ship);
        all.setVisible(true);
        all.add(life1);
        all.setVisible(true);
        all.add(life2);
        all.setVisible(true);
        all.add(life3);
        all.setVisible(true);
        tA.start();

    }
    
    public static boolean checkShip(int x, int y)
    {    boolean hit=false;   
        if (ship.getXPos()-x>=-10 && ship.getXPos()-x<=7&& ship.getYPos()-y>=-4 && ship.getYPos()-y<=0) {
          hit=true;
                //i=i-1;

                    
                  
                    
                
            }
        return hit;
        }

    public static void nextlife()
    {
        l--;
        if(l==2){
            all.remove(life1);
                    all.setVisible(true);
                  ship.setXY(200,350);
        }
                if(l==1){
            all.remove(life2);
                    all.setVisible(true);
                    ship.setXY(200,350);
        }
                if(l==0){
            all.remove(life3);
                    all.setVisible(true);
                   all.remove(ship);
                   score.setText("GAME OVER!!! Your score is "+p);
                   score.setFont(new Font("Serif", Font.PLAIN,20));
                   all.setVisible(true);
                   tA.stop();
        }
    }

        //     public boolean alienGoBoom(Rocket r)
        //     {
        //         boolean hit = false;
        //         for(int i = 0; i< army.size() ; i++)
        //         {
        //             if (r.getXPos()-army.get(i).getXPos()<=15 && r.getXPos()-army.get(i).getXPos()>=0 && r.getYPos()-army.get(i).getYPos()<=15 && r.getYPos()-army.get(i).getYPos()>0) {
        //                 army.remove(i);
        //                 all.remove(army.get(i));
        //                 //i=i-1;
        //                 hit = true;
        //             }
        //         }
        //         return hit;
        //     }

        public void actionPerformed(ActionEvent e) {
        //         if (barage.size()>0)
        //         {
        //             for(int i = 0; i<barage.size(); i++){
        //                 if (barage.get(i).getYPos()<=0) barage.remove(i);
        //             }
        //         }
        if(AlienManager.army.size()>0){ x= (int) r.nextInt(AlienManager.army.size());
        all.add(new Slime(AlienManager.army.get(x).getXPos(),AlienManager.army.get(x).getYPos()));
        all.setVisible(true);}
        for(int j = 0; j<AlienManager.army.size(); j++){

                
                
                
            Alien a = AlienManager.army.get(j);
            a.move();
            a.repaint();

            //             if (barage.size()>0)
            //             {
            //                 for (int i = 0; i<barage.size(); i++) 
            //                 {
            //                     boolean hit = this.alienGoBoom(barage.get(i));
            //                     if (hit) 
            //                     {
            //                         j= j-1;
            //                         all.remove(barage.get(i));
            //                     }
            //                 }
            //             }
        }
        //System.out.println(AlienManager.army.size());
    }

}
