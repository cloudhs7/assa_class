package board;

import java.awt.BorderLayout;
import java.awt.Color;

import piece.Piece;


public class Tile extends ImagePanel  {
   
   int x;
   int y;
   protected Piece piece;
   int set;
   
   //constructors
   Tile(){
      
   }
  
   Tile(Tile tile){
	      
   }
   
   Tile(int x, int y, Piece piece, int set){
	   this.x = x;
       this.y = y;
       this.piece = piece;
       this.set = set;
       
       if(set==1) {
    	   if((x+y)%2 == 0) Board.panel[x][y].setBackground(Color.white);
    	   else Board.panel[x][y].setBackground(Color.gray);
       }
       
       else {
    	   if((x>=3&&x<=10)||(y>=3&&y<=10)) {
    		   if((x+y)%2 == 0)
    			   Board2.panel[x][y].setBackground(Color.white);
    		   else
    			   Board2.panel[x][y].setBackground(Color.gray);
    	   }
    	   else Board2.panel[x][y].setBackground(Color.pink); 
       }
       
       if(piece!=null)
		   setPiece(piece);
 
   }
   
   
   //getter & setter
   public Piece getPiece() {
      return piece;
   }
   
   public void setPiece(Piece piece) {
	   if(set==1) {
		   Board.image[x][y].setImage(piece.getImage());
		   Board.panel[x][y].add(Board.image[x][y], BorderLayout.CENTER);
	   }
	   else{
		   Board2.image[x][y].setImage(piece.getImage());
		   Board2.panel[x][y].add(Board2.image[x][y], BorderLayout.CENTER);
	   }
   }
   
   public int getColor() {
      return piece.color;
   }
}