package board;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;

import board.ChessPieceSprite.ChessPieceSpriteType;
import piece.Bishop;
import piece.King;
import piece.Knight;
import piece.Pawn;
import piece.Queen;
import piece.Rook;

public class Main{
	protected static Rook wr01, wr02, br01, br02;
	protected static Knight wn01,wn02, bn01, bn02;
	protected static Bishop wb01, wb02, bb01, bb02;
	protected static Queen wq,bq;
	protected static King wk,bk;
	protected static Pawn wp[], bp[];
	
	Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 

	static int Turn = 0;
	static BufferedImage BP = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_PAWN);	
	static BufferedImage WP = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_PAWN);
	static BufferedImage BR = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_LOOK);
	static BufferedImage WR = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_LOOK);
	static BufferedImage BN = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_KNIGHT);
	static BufferedImage WN = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_KNIGHT);
	static BufferedImage BB = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_BISHOP);
	static BufferedImage WB = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_BISHOP);
	static BufferedImage BQ = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_QUEEN);
	static BufferedImage WQ = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_QUEEN);
	static BufferedImage BK = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_KING);
	static BufferedImage WK = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_KING);
	
	public static void main(String[] args){
		//Piece image initialization
		bp = new Pawn[8];
		for(int i=0;i<8;i++) {
			bp[i] = new Pawn("BP0"+(i+1),BP,1);
		}
		wp = new Pawn[8];
		for(int i=0;i<8;i++) {
			wp[i] = new Pawn("WP0"+(i+1),WP,0);
		}
		br01 = new Rook("BR01",BR,1);
		br02 = new Rook("BR02",BR,1);
		wr01 = new Rook("WR01",WR,0);
		wr02 = new Rook("WR02",WR,0);
		bn01 = new Knight("BN01",BN, 1);
		bn02 = new Knight("BN02",BN, 1);
		wn01 = new Knight("WN01",WN,0);
		wn02 = new Knight("WN02",WN,0);
		bb01 = new Bishop("BB01",BB,1);
		bb02 = new Bishop("BB02",BB,1);
		wb01 = new Bishop("WB01",WB,0);
		wb02 = new Bishop("WB02",WB,0);
		bq = new Queen("BQ",BQ,1);
		wq = new Queen("WQ",WQ,0);
		bk = new King("BK",BK,1);
		wk = new King("WK",WK,0);
		
		new FirstGUI();	
	}
}
