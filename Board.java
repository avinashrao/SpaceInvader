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
    int a;// Initialize instance field variables. 
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
    static int ad;
    //ImageIcon[][] alienArmy;

    public Board(int x)
    {
        ad=100;
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
        AlienManager.initialize();// call static variable from AlienManager class to initialize array of Aliens.
        BlockManager.initialize();// call static variable from BlockManager class to initialize array of Blocks.
        //board = new JPanel();
        //alien = new JLabel(alien1);
        //alien1 = new ImageIcon("Unknown.png");
        //ImageIcon = new ImageIcon[5][11];
        //         try {// allows you to test a block of code and then check for errors(as image imports usually throw and error)
        //             alien = ImageIO.read(new File("Unknown.png"));// accesses image stored within the local folder
        //         } catch (IOException e) {// allows you to catch a specific error without compile type errors. In the case of image imports 'IOException e'
        //         }

    }

    public void drawAliens() // This class is put in charge of Drawing and managing the drawing of aliens as it contains the JFrame. 
    {
        for(int i = 0; i<AlienManager.army.size(); i++) //using the static array of aliens in the AlienManager class, this for loop draws all the aliens. 
        {
            all.add(AlienManager.army.get(i));// simply adding the aliens to the JFrame draws them according the the defined PaintComponent method in the class
            all.setVisible(true);// Set frame to visible using setVisible method on frame object to be able to view the newly drawn JComponenet. 
        }
    }

    public void drawBarriers()
    {
        for(int i = 0; i<BlockManager.barrier.size(); i++) 
        {
            all.add(BlockManager.barrier.get(i));// simply adding the aliens to the JFrame draws them according the the defined PaintComponent method in the class
            all.setVisible(true);// Set frame to visible using setVisible method on frame object to be able to view the newly drawn JComponenet.
        }
    }

    public void createBoard() 
    {
        all.getContentPane().setBackground( Color.BLACK );// Set color of the frame to black. 
        a=0;
        class MoveListener implements KeyListener{// MoveListener class implements KeyListener interface and performs actions after each event is generated
            public void keyPressed(KeyEvent e){// performs a specific action once event is generated when the key is pressed. 
                switch (e.getKeyCode()){//switch to toggle between object. 
                    case KeyEvent.VK_LEFT:{// When event source is left arrow button...
                        ship.left(2);// Inoke the move left method on the ship, while specifying the delta using a explicit parameter.
                        break;// used to keep from case moving onto next case. 

                    }
                    case KeyEvent.VK_RIGHT:{ // When event source is right arrow button...
                        ship.right(2);// Inoke the move right method on the ship, while specifying the delta using a explicit parameter.
                        break;

                    }

                }
            }

            public void keyTyped(KeyEvent e){}// method needs to be written as it is a method of KeyListener interface. 

            public void keyReleased(KeyEvent e){// method in KeyListener. Performs action when event generated by releasing key
                switch (e.getKeyCode()){        //switch to toggle between objec    
                    case KeyEvent.VK_LEFT:{// if even source is left
                        ship.stop();// inoke stop method on spaceship when key not pressed
                        break;// used to keep from case moving onto next case. 
                    }
                    case KeyEvent.VK_RIGHT:{ // if even source is right
                        ship.stop();// inoke stop method on spaceship when key not pressed
                        break;

                    }

                    case KeyEvent.VK_SPACE:{ // if even source is spacebar/
                        if(a%2==0){// performs action only when
                            Rocket r = new Rocket(ship.getXPos(),ship.getYPos());// construct new rocket from current location of ship.
                            all.add(r);// simply adding the aliens to the JFrame draws them according the the defined PaintComponent method in the class
                            all.setVisible(true);// Set frame to visible using setVisible method on frame object to be able to view the newly drawn JComponenet.

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

        this.drawAliens();//call method in this class to draw all aliens. More comment code of functionality in method itself.
        drawBarriers();//call method in this class to draw all aliens. More comment code of functionality in method itself.

        score=new JLabel(" "+ p);
        score.setForeground(Color.GREEN);

        all.add(score);
        all.setVisible(true);// Set frame to visible using setVisible method on frame object to be able to view the newly drawn JComponenet.
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

    public static boolean checkShip(int x, int y)//Method to check position of ship to a given location. 
    {    boolean hit=false;   // boolean returned with true fals based on boolean operator below. 
        if (ship.getXPos()-x>=-10 && ship.getXPos()-x<=7&& ship.getYPos()-y>=-4 && ship.getYPos()-y<=0) {// operator to check position of ship to distance within 4 vertically and 10 horizontally. 
            hit=true;// if ship in range, return true for hit.
        }
        return hit;// return hit.
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

    public void nextLevel(){
        AlienManager.initialize();
        BlockManager.initialize();
        this.drawAliens();
        this.drawBarriers();
        all.setVisible(true);
        tA.stop();
        tA=new Timer(z/2,this);
        z=z/2;
        ad=2*ad;
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
        if(AlienManager.army.size()>0){ //if statement meant to be a false safe, so program doesn't crash if no aliens remain in the Arraylist. 
            x= (int) r.nextInt(AlienManager.army.size());// Random number generator to randomly select aliens. nextInt method selects double value between 1 and 0. It is then multiplied by the numeber of elements in the arraylist to select a random number within the bounds of largest index. 
            all.add(new Slime(AlienManager.army.get(x).getXPos(),AlienManager.army.get(x).getYPos()));// constructs a slime (alien rocket) at the x,y cordinates of the randomly selected alien. Then in a single line, adds the slime to the frame. 
            all.setVisible(true);
        }
        if(AlienManager.army.size()==0){nextLevel(); // The program continues onto the next level once the size of the alien's ArrayList is 0. 
        }
        for(int j = 0; j<AlienManager.army.size(); j++){// goes through all the aliens. 

            Alien a = AlienManager.army.get(j);//holder variable for current element were j is it index is assigned to variable a of type Alien.
            a.move();//move method invoked on alien.
            a.repaint();// repainted. 

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
    }
}
