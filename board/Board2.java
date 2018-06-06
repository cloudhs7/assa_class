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

public class Board2 extends Main {
	static JPanel[][] panel = new JPanel[14][14];
	static ImagePanel[][] image = new ImagePanel[14][14];
	public static Tile[][] board = new Tile[14][14];
	private Tile t, previous = null;
	private int chance = 0;
	Tile tile;
	ArrayList<Tile> destinationlist;
	
	public Board2() {
		JFrame frame = new JFrame("Chess 2vs2 !!");
	      frame.setSize(1000,1000);
	      frame.setLayout(null);
	      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	      frame.setLocationRelativeTo(null);
	      frame.setLayout(new GridLayout(14,14));
	      piece.Piece p;
	      
	      for(int i=0;i<14;i++){
	          for(int j=0;j<14;j++) {
	        	  panel[i][j] = new JPanel();
	        	  panel[i][j].setLayout(new BorderLayout());
	        	  image[i][j] = new ImagePanel();
	        	  p=null;
	        	  
	        	  if((i>=3&&i<=10)||(j>=3&&j<=10)) {
	        		 //Black
	        		 if(i==0) {
	        			 if(j==3) p = br01;
	        			 if(j==4) p = bn01;
	        			 if(j==5) p = bb01;
	        			 if(j==6) p = bk;
	        			 if(j==7) p = bq;
	        			 if(j==8) p = bb02;
	        			 if(j==9) p = bn02;
	        			 if(j==10) p = br02;
	        		 }
	        		 else if(i==1) p = bp[j-3];
	        		 
	        		 //Red
	        		 else if(j==0) {
	        			 if(i==3) p = rr01;
	        			 if(i==4) p = rn01;
	        			 if(i==5) p = rb01;
	        			 if(i==6) p = rk;
	        			 if(i==7) p = rq;
	        			 if(i==8) p = rb02;
	        			 if(i==9) p = rn02;
	        			 if(i==10) p = rr02;
	        		 }
	        		 else if (j==1) p = rp[i-3];
	        		 
	        		//White
	        		 if(i==13) {
	        			 if(j==3) p = wr01;
	        			 if(j==4) p = wn01;
	        			 if(j==5) p = wb01;
	        			 if(j==6) p = wq;
	        			 if(j==7) p = wk;
	        			 if(j==8) p = wb02;
	        			 if(j==9) p = wn02;
	        			 if(j==10) p = wr02;
	        		 }
	        		 else if(i==12) p = wp[j-3];
	        		 
	        		 //Green
	        		 else if(j==13) {
	        			 if(i==3) p = gr01;
	        			 if(i==4) p = gn01;
	        			 if(i==5) p = gb01;
	        			 if(i==6) p = gk;
	        			 if(i==7) p = gq;
	        			 if(i==8) p = gb02;
	        			 if(i==9) p = gn02;
	        			 if(i==10) p = gr02;
	        		 }
	        		 else if (j==12) p = gp[i-3];
	        	 }
	        	 
	        	 tile = new Tile(i,j,p,2);
        		 board[i][j] = tile;
        		 frame.add(panel[i][j]);
	          }
	     
	          frame.setVisible(true);
	      }
	}
}
