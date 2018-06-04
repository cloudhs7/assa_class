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

public class Board extends Main{
   static JPanel[][] panel = new JPanel[8][8];
   static ImagePanel[][] image = new ImagePanel[8][8];
   public static Tile [][] board = new Tile[8][8];
   Tile tile;
   
   public Board() {
      JFrame frame = new JFrame("Chess!");
      frame.setSize(800,800);
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
            //else if(i==0 && j==5)
            //   p = bb02;
            else if(i==0 && j==3)
               p = bk;
            //else if(i==0 && j==4)
            //   p = bq;
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
            
            //확인확인
            else if(i==3 && j==5)
               p = bb02;
            else if(i==3 && j==4)
               p = bq;
            tile = new Tile(i,j,p);
            board[i][j] = tile;
            panel[i][j].setBounds(50,50,100,100);
            panel[i][j].setBorder(new BevelBorder(BevelBorder.RAISED));
            frame.addMouseListener(new MyMouseListener());
            frame.addMouseMotionListener(new MyMouseListener());
            frame.add(panel[i][j]);
         }
      }
      frame.setVisible(true);
   }
   
   class MyMouseListener extends Tile implements MouseMotionListener, MouseListener{
         int clickedX = -1;
         int clickedY = -1;
         
         public void mousePressed(MouseEvent e){}
         public void mouseReleased(MouseEvent e){}
         public void mouseClicked(MouseEvent e){
            int x = e.getY()/100;
            int y = e.getX()/100;
            
            if(!(isEmptyTile(board[x][y]))){     
               Tile checkTile = new Tile();
               ArrayList<Tile> destMove;
               if(clickedX == -1 && clickedY == -1) {	//처음 클릭할 때 & 취소하고 다시 클릭할 때
                  panel[x][y].setBackground(Color.yellow);
                  destMove = board[x][y].piece.move(x,y);
                  for(int i=0;i<destMove.size();i++) {
                     checkTile = destMove.get(i);
                     panel[checkTile.x][checkTile.y].setBackground(Color.pink);
                  }
                  clickedX = x;
                  clickedY = y;
               }
               else if(clickedX != x || clickedY != y) {	//이동가능한 tile을 클릭했을 때
                  panel[clickedX][clickedY].setBackground((clickedX+clickedY)%2==0?Color.white:Color.gray);
                  for(int i=0;i<board[clickedX][clickedY].getPiece().possibleMove.size();i++) {
                     checkTile = board[clickedX][clickedY].getPiece().possibleMove.get(i);
                     panel[checkTile.x][checkTile.y].setBackground((checkTile.x+checkTile.y)%2==0?Color.white:Color.gray);
                  }
                  clickedX = x;
                  clickedY = y;
               }
               else {	//취소할 때							
                  panel[clickedX][clickedY].setBackground((clickedX+clickedY)%2==0?Color.white:Color.gray);
                  for(int i=0;i<board[clickedX][clickedY].getPiece().possibleMove.size();i++) {
                     checkTile = board[clickedX][clickedY].getPiece().possibleMove.get(i);
                     panel[checkTile.x][checkTile.y].setBackground((checkTile.x+checkTile.y)%2==0?Color.white:Color.gray);
                  }
                  clickedX = -1;
                  clickedY = -1;
               }
            }
         }
         public void mouseEntered(MouseEvent e){
            /*
            JPanel changecolor = (JPanel)e.getSource();
            prevcolor = changecolor.getBackground();
            changecolor.setBackground(Color.PINK);
            */
         }
         public void mouseExited(MouseEvent e){
            /*
            JPanel changecolor = (JPanel)e.getSource();
            changecolor.setBackground(prevcolor);
            */
         }
         public void mouseDragged(MouseEvent e){}
         public void mouseMoved(MouseEvent e){}
   }
}