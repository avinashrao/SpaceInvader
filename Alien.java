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

public class Alien extends JComponent
{
    BufferedImage alien;// construct instance field variables.
    int posX;
    int posY;
    Timer t;
    int z;
    public Alien(int x, int y)
    {
        posX = x;
        posY = y;
        int z= 0;

         try {// allows you to test a block of code and then check for errors(as image imports usually throw and error)
            alien = ImageIO.read(new File("Unknown.png"));// accesses image stored within the local folder
        } catch (IOException e) {// allows you to catch a specific error without compile type errors. In the case of image imports 'IOException e'
        }
    }

        public void paintComponent(Graphics g) {//paintcomponent method invoked when Jcompent draw on the frame
        Graphics2D g2 = (Graphics2D) g;//casts the graphics object referenced by g to a graphics2D reference,  g2
        g2.drawImage(alien, posX, posY, null);//draws the image of the alien image to the screen using the draw image mutator method
    }
    
        public void move(){//invoked regularly to change the position of the alien
        z++;//increments the value of primitive variable z
            if(z%10<5)posX-=8;//changes the value of the instance field primitive variable posX
            else{posX+=8;}
            if(z%20==0)posY+=10;
        

    }

    public int getXPos()//accessor method for the alien class
    {
        return posX;
    }

    public int getYPos()
    {
        return posY;
    }

    public void setX(int k)//mutator method for the alien class
    {
        posX = k;
    }
    public String toString()//mutator method for the alien class
    {
        return posX+","+posY;
    }
}
