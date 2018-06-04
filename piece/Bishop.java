package piece;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import board.Tile;
import board.Board;

public class Bishop extends Piece {
	private int curX;
	private int curY;
	
	public Bishop(String id, BufferedImage img, int color) {
		super(id, img, color);
	}

	@Override
	public ArrayList<Tile> move(int cur_X, int cur_Y) {
		this.curX = cur_X;
		this.curY = cur_Y;
		possibleMove.clear();
		
		//왼쪽 위
		for(int i=1; i<=curY; i++) {
			if(curX-i < 0 || curX-i > 7 || curY-i < 0 || curY-i > 7) break;			//인덱스 값이 판 내부에 있을 때만 실행
			if(Board.board[curX-i][curY-i].getPiece() == null)		//빈 칸이면 가능한 이동
				possibleMove.add(Board.board[curX-i][curY-i]);
			else {													//비어 있지 않을 경우 상대편 말이면 가능한 이동
				if(Board.board[curX-i][curY-i].getColor() != Board.board[curX][curY].getColor()) {
					possibleMove.add(Board.board[curX-i][curY-i]);
					break;
				}
				else break;
			}
		}
		//오른쪽 위
		for(int i=1; i<=7-curY; i++) {
			if(curX-i < 0 || curX-i > 7 || curY+i < 0 || curY+i > 7) break;
			if(Board.board[curX-i][curY+i].getPiece() == null)
				possibleMove.add(Board.board[curX-i][curY+i]);
			else {
				if(Board.board[curX-i][curY+i].getColor() != Board.board[curX][curY].getColor()) {
					possibleMove.add(Board.board[curX-i][curY+i]);
					break;
				}
				else break;
			}
		}
		//왼쪽 아래
		for(int i=1; i<=7-curX; i++) {
			if(curX+i < 0 || curX+i > 7 || curY-i < 0 || curY-i > 7) break;
			if(Board.board[curX+i][curY-i].getPiece() == null)
				possibleMove.add(Board.board[curX+i][curY-i]);
			else {
				if(Board.board[curX+i][curY-i].getColor() != Board.board[curX][curY].getColor()) {
					possibleMove.add(Board.board[curX+i][curY-i]);
					break;
				}
				else break;
			}
		}
		//오른쪽 아래
		for(int i=1; i<=7-curX; i++) {
			if(curX+i < 0 || curX+i > 7 || curY+i < 0 || curY+i > 7) break;
			if(Board.board[curX+i][curY+i].getPiece() == null)
				possibleMove.add(Board.board[curX+i][curY+i]);
			else {
				if(Board.board[curX+i][curY+i].getColor() != Board.board[curX][curY].getColor()) {
					possibleMove.add(Board.board[curX+i][curY+i]);
					break;
				}
				else break;
			}
		}
		
		return possibleMove;
	}
	

}
