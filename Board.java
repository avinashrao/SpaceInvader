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
    SpaceShip ship;
    //ArrayList<Alien> army;
    //ArrayList<Rocket> barage; 
    Timer tA;
    JLabel score;
    int x;
    //ImageIcon[][] alienArmy;

    public Board()
    {
        all = new JFrame();
        all.setSize(400,400);
        ship = new SpaceShip(200,350);
        //army = new ArrayList<Alien>();
        //barage = new ArrayList<Rocket>();
        tA=new Timer(3000,this);
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
                    case KeyEvent.VK_SPACE:{ 

                        if(a%2==0){
                            Rocket r = new Rocket(ship.getXPos(),ship.getYPos());
                            all.add(r);
                            all.setVisible(true);

                            //barage.add(r);

                            break;

                        }
                    }}}

            public void keyTyped(KeyEvent e){}

            public void keyReleased(KeyEvent e){
                switch (e.getKeyCode()){            
                    case KeyEvent.VK_LEFT:{
                        ship.stop();
                    }
                    case KeyEvent.VK_RIGHT:{ 
                        ship.stop();

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
        this.drawBarriers();

        score=new JLabel();
        score.setForeground(Color.GREEN);
        score.setText("0");

        all.add(score);
        all.setVisible(true);
        all.add(this);
        all.setVisible(true);// sets to visible
        all.addKeyListener(new MoveListener());

        all.add(ship);
        all.setVisible(true);
        tA.start();

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
        x = (int) Math.random()*AlienManager.army.size();
        all.add(new Slime(AlienManager.army.get(x).getXPos(),AlienManager.army.get(x).getYPos()));
        all.setVisible(true);
 
        for(int j = 0; j<AlienManager.army.size(); j++){
            if (j>AlienManager.army.size()) break;
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
