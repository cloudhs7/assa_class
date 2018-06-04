package board;

import java.awt.BorderLayout;
import java.awt.Color;

import piece.Piece;

public class Tile extends ImagePanel{
	
	int x;
	int y;
	protected Piece piece = null;
	
	Tile(){
		
	}
	
	Tile(int x, int y, Piece piece){
		this.x = x;
	    this.y = y;
	    this.piece = piece;
	    if((x+y)%2 == 0)
	    	Board.panel[x][y].setBackground(Color.white);
		else
			Board.panel[x][y].setBackground(Color.gray);
	    if(piece!=null)
	    	setPiece(piece);	    	
	}
	
	public boolean isEmptyTile(Tile tile) {   /*board[][] 형식으로 인자 들어옴*/
		if(tile.piece==null)
	         return true;
	    return false;
	}
	
	public Piece getPiece() {
		return piece;
	}

	public void setPiece(Piece piece) {
		Board.image[x][y].setImage(piece.getImage());
		Board.panel[x][y].add(Board.image[x][y], BorderLayout.CENTER);
	}
	
	public int getColor() {
		return piece.color;
	}
}
