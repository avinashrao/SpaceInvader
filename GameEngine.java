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
/**
 * Write a description of class GameEngine here.
 * 
   * @author (your name) 
 * @version (a version number or a date)
 */
public class GameEngine
{
    public static void main (String[] args){
    
        JFrame f= new JFrame("Welcome");
        f.setSize(400,400);
        
        JPanel p=new JPanel();
         p.setLayout(new BorderLayout());
         
         ImageIcon Ayy = new ImageIcon("6ca.jpg");
         JLabel l=new JLabel();

         p.add(l,BorderLayout.CENTER);
         
         p.setVisible(true);
         f.add(p);
         f.setVisible(true);
        
         
         
        
        Board board = new Board();
        //hello
        board.createBoard();
    }
}
