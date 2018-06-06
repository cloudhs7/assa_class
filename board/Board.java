package board;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.*;

import piece.King;
import piece.Piece;

public class Board extends Main{
   static JPanel[][] panel = new JPanel[8][8];
   static ImagePanel[][] image = new ImagePanel[8][8];
   public static Tile [][] board = new Tile[8][8];
   private Tile t, previous = null;
   private int chance = 0;
   Tile tile;
   ArrayList<Tile> destinationlist;
   
   public Board() {
      JFrame frame = new JFrame("Chess!");
      frame.setSize(1000,1000);
      frame.setLayout(null);
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.setLocationRelativeTo(null);
      frame.setLayout(new GridLayout(8,8));
      piece.Piece p;
      
      for(int i=0;i<8;i++){
         for(int j=0;j<8;j++) {
            panel[i][j] = new JPanel();
            panel[i][j].setLayout(new BorderLayout());
            image[i][j] = new ImagePanel();
            p = null;
            if(i==0 && j==0)
               p = br01;
            else if(i==0 && j==7)
               p = br02;
            else if(i==0 && j==1)
               p = bn01;
            else if(i==0 && j==6)
               p = bn02;
            else if(i==0 && j==2)
               p = bb01;
            else if(i==0 && j==5)
               p = bb02;
            else if(i==0 && j==3)
               p = bk;
            else if(i==0 && j==4)
               p = bq;
            else if(i==1)
               p = bp[j];
            else if(i==6)
               p = wp[j];
            else if(i==7 && j==0)
               p = wr01;
            else if(i==7 && j==7)
               p = wr02;
            else if(i==7 && j==1)
               p = wn01;
            else if(i==7 && j==6)
               p = wn02;
            else if(i==7 && j==2)
               p = wb01;
            else if(i==7 && j==5)
               p = wb02;
            else if(i==7 && j==3)
               p = wq;   
            else if(i==7 && j==4)
               p = wk;
            
            tile = new Tile(i,j,p,1);
            board[i][j] = tile;
            frame.add(panel[i][j]);
         }
      }
      frame.setVisible(true);
   }
}