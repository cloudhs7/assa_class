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
		
		//���� ��
		for(int i=1; i<=curY; i++) {
			if(curX-i < 0 || curX-i > 7 || curY-i < 0 || curY-i > 7) break;			//�ε��� ���� �� ���ο� ���� ���� ����
			if(Board.board[curX-i][curY-i].getPiece() == null)		//�� ĭ�̸� ������ �̵�
				possibleMove.add(Board.board[curX-i][curY-i]);
			else {													//��� ���� ���� ��� ����� ���̸� ������ �̵�
				if(Board.board[curX-i][curY-i].getColor() != Board.board[curX][curY].getColor()) {
					possibleMove.add(Board.board[curX-i][curY-i]);
					break;
				}
				else break;
			}
		}
		//������ ��
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
		//���� �Ʒ�
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
		//������ �Ʒ�
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
