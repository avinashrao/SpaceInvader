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

public class AlienManager// holder class for static ArrayList of aliens. Necessary to increase efficiency of codes and to avoid constant transfer and exchange of this array between Alien, Rocket, and Board classes.
{
    public static ArrayList<Alien> army = new ArrayList<Alien>(); // initialize Arraylist of elements of type Alien as public static (thus can be accessed and mutated by multiple related classes.)

    public static void initialize()// initialize method when classed will populate araylist with aliens. 
    {
        for( int i = 110; i<300; i=i+20){// for loop corresponding range of x values for aliens with step of +20 for spacing. 
            for (int j = 40;j<150; j=j+20) // inner for loop corresponding range of y values for aliens with step of +20 for spacing. 
            {
                army.add(new Alien(i,j));// construct and add new alien objects to ArrayList. 
            }
        }
    }
    public static void initialize(ArrayList<Alien> a)// initialize method when classed will populate araylist with aliens. 
    {
        army=a;
    }
    
    
}
