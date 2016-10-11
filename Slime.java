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
import javax.swing.JFrame;//
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

public class Slime extends JComponent implements ActionListener// all comment code for slime class is identical to that found in the Rocket class. 
{
    BufferedImage slime;
    int posX;
    int posY;
    Timer t;
    public Slime(int x, int y)
    {
        if(y>300)Board.nextlife();
        posX = x;
        posY = y;
        t=new Timer(10,this);
        t.start();

        try {// allows you to test a block of code and then check for errors(as image imports usually throw and error)
            slime = ImageIO.read(new File("Unknown Copy.png"));// accesses image stored within the local folder
        } catch (IOException e) {// allows you to catch a specific error without compile type errors. In the case of image imports 'IOException e'
        }
    }

    public void actionPerformed(ActionEvent e){
        posY+=5;
        repaint();
        if(posY>500)t.stop();
        this.batteringRam();

    }

    public boolean batteringRam()
    {
        boolean hit = false;
        for(int i = 0; i< BlockManager.barrier.size() ; i++)
        {
            if (this.getXPos()-BlockManager.barrier.get(i).getXPos()>=-4 && this.getXPos()-BlockManager.barrier.get(i).getXPos()<=0 && this.getYPos()-BlockManager.barrier.get(i).getYPos()>=-4 && this.getYPos()-BlockManager.barrier.get(i).getYPos()<=0) 
            {
                //i=i-1;
                hit = true;
                if (hit) 
                {
                    Board.all.remove(this);
                    Board.all.remove(BlockManager.barrier.get(i));
                    BlockManager.barrier.remove(i);
                    t.stop();
                }
            }

        }
                boolean z=Board.checkShip(posX,posY);
        if(z){
            Board.all.remove(this);
            Board.nextlife();
            t.stop();
            
    }
        

        return hit;
    }

    public void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.drawImage(slime, posX, posY, null);
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
