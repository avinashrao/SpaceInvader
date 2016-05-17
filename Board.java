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
    JFrame all;
    Alien alien;
    SpaceShip ship;
    ArrayList<Alien> army;
    Timer tA;
    //ImageIcon[][] alienArmy;

    public Board()
    {
        all = new JFrame();
        all.setSize(400,400);
        ship = new SpaceShip(200,350);
        army = new ArrayList<Alien>();
        tA=new Timer(1000,this);
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
                            all.add(new Rocket(ship.getXPos(),ship.getYPos()));
                            all.setVisible(true);
                            a++;

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
        for( int i = 30; i<350; i=i+20){
            for (int j = 40;j<150; j=j+20) 
            {
                army.add(new Alien(i,j));
            }
        }

        for(int i = 0; i<army.size(); i++) 
        {
            all.add(army.get(i));
            all.setVisible(true);
        }

        all.add(this);
        all.setVisible(true);// sets to visible
        all.addKeyListener(new MoveListener());

        all.add(ship);
        all.setVisible(true);
        tA.start();

    }
    

    public void actionPerformed(ActionEvent e) {
        for(Alien a:army){
            a.move();
            a.repaint();
        }
        a++;

    }

}
