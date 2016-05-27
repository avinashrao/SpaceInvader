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

public class Block extends JComponent //see alien class for comment code
{
    BufferedImage block;
    int posX;
    int posY;
    int z;
    public Block(int x, int y)
    {
        posX = x;
        posY = y;
        int z= 0;

         try {// allows you to test a block of code and then check for errors(as image imports usually throw and error)
            block = ImageIO.read(new File("New Piskel copy.png"));// accesses image stored within the local folder
        } catch (IOException e) {// allows you to catch a specific error without compile type errors. In the case of image imports 'IOException e'
        }
    }

        public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(block, posX, posY, null);
    }


    public int getXPos()
    {
        return posX;
    }

    public int getYPos()
    {
        return posY;
    }

    public void setX(int k)
    {
        posX = k;
    }
}
