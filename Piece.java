package kr.ac.cau.mecs.lenerd.chess;


public abstract class Piece {

	Alliance alliance;
	
	public final int KING = 1;
	public final int QUEEN = 2;
	public final int ROOK = 3;
	public final int BISHOP = 4;
	public final int KNIGHT = 5;
	public final int PAWN = 6;
	
	int pieceNumber;
	int curX, curY;
	
	Piece(int pieceNumber, int curX, int curY, Alliance alliance){
		this.pieceNumber = pieceNumber;
		this.curX = curX;
		this.curY = curY;
		this.alliance = alliance;
	}
	
}
