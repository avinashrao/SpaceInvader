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

public class GameEngine
{
    public static void main (String[] args){// main method to initiate code. 
        /*ImageIcon ship=null;       
        try {// allows you to test a block of code and then check for errors(as image imports usually throw and error)
         ship =new ImageIcon(ImageIO.read(new File("Unknown-2.png")));
        } catch (IOException e) {// allows you to catch a specific error without compile type errors. In the case of image imports 'IOException e'
        }
        JOptionPane j= new JOptionPane("Welcome to Space Invaders", JOptionPane.INFORMATION_MESSAGE,JOptionPane.OK_CANCEL_OPTION,ship);
        j.createDialog("Welcome");*/
        Board board = new Board(1000);// create new isntance of Board class which contains all the content for the Game.

        board.createBoard();//call createBoard method Board object referenced by board. 
    }
}
