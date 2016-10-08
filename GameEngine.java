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
        int choose=Integer.parseInt(JOptionPane.showInputDialog("Would you like to resume your game from the file (press 1) or start a new game (press 2)?"));
       System.out.println("\fPress S to save, space to shoot, and left and right to move.");
        Board board;
        if(choose==1){
        board = new Board(1000);// create new isntance of Board class which contains all the content for the Game.
    }
        else{
        board = new Board(1000);// create new isntance of Board class which contains all the content for the Game.
    }

        board.createBoard();//call createBoard method Board object referenced by board. 
    }
}
