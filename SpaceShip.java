import java.awt.Rectangle;
import javax.swing.JComponent;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Ellipse2D.Double;
import java.awt.geom.Ellipse2D;
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

public class SpaceShip extends JComponent implements ActionListener//look in alien class for additional comment code
{
    BufferedImage ship;
    int posX;//
    int posY;
    boolean left;
    Timer t;
    int z;
    public SpaceShip(int x, int y)//constructor
    {
       t=new Timer(10,this);//creates a timer object with  parameters of this object and a 10ms delay
        posX = x;
        posY = y;
        left=true;
        z=0;

        try {// allows you to test a block of code and then check for errors(as image imports usually throw and error)
            ship = ImageIO.read(new File("Unknown-2.png"));// accesses image stored within the local folder
        } catch (IOException e) {// allows you to catch a specific error without compile type errors. In the case of image imports 'IOException e'
        }
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(ship, posX, posY, null);
    }

    public int getXPos()
    {
        return posX;
    }

    public int getYPos()
    {
        return posY;
    }

    public void actionPerformed(ActionEvent e){//invoked every time a timer causes a event on this class
        if(left==true){
            if(posX>5)posX = posX-z;//changes the value of the primivite instance field posX
            repaint();}
        if(left==false){
            if(posX<375)posX = posX+z;
            repaint();  
        }

    }

    public void left(int k)//mutator method of the SpaceShip class
    {
        z=k;
        left=true;
        t.start();
    }

    public void right(int k)
    {

        z=k;
        left=false;
        t.start();
    }

    public void setXY(int k,int j)
    {posX=k;
        posY=j;

      
    }

    public void stop()//stops the timer for this object by invoking the stop mutator method on the timer referenced by t
    {
        t.stop();
    }

}
