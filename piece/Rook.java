package piece;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import board.Tile;
import board.Board;

public class Rook extends Piece{
	private int curX;
	private int curY;
	
	public Rook(String id, BufferedImage img, int color) {
		super(id, img, color);
	}
	

	@Override
	public ArrayList<Tile> move(int cur_X, int cur_Y){
		this.curX = cur_X;
		this.curY = cur_Y;
		possibleMove.clear();
		
		//���� ����
		for(int left=1; left<=curY; left++) {
			if(Board.board[curX][curY-left].getPiece() == null)		//�� ĭ�̸� ������ �̵�
				possibleMove.add(Board.board[curX][curY-left]);
			else {													//��� ���� ���� ��� ����� ���̸� ������ �̵�
				if(Board.board[curX][curY-left].getColor() != Board.board[curX][curY].getColor()) {
					possibleMove.add(Board.board[curX][curY-left]);
					break;
				}
				else break;
			}	
		}
		//���� ������
		for(int right=1; right<=7-curY; right++) {
			if(Board.board[curX][curY+right].getPiece() == null)
				possibleMove.add(Board.board[curX][curY+right]);
			else {
				if(Board.board[curX][curY+right].getColor() != Board.board[curX][curY].getColor()) {
					possibleMove.add(Board.board[curX][curY+right]);
					break;
				}
				else break;
			}	
		}
		//���� ��
		for(int up=1; up<=curX; up++) {
			if(Board.board[curX-up][curY].getPiece() == null)
				possibleMove.add(Board.board[curX-up][curY]);
			else {
				if(Board.board[curX-up][curY].getColor() != Board.board[curX][curY].getColor()) {
					possibleMove.add(Board.board[curX-up][curY]);
					break;
				}
				else break;
			}	
		}
		//���� �Ʒ�
		for(int down=1; down<=7-curX; down++) {
			if(Board.board[curX+down][curY].getPiece() == null)
				possibleMove.add(Board.board[curX+down][curY]);
			else {
				if(Board.board[curX+down][curY].getColor() != Board.board[curX][curY].getColor()) {
					possibleMove.add(Board.board[curX+down][curY]);
					break;
				}
				else break;
			}	
		}
	
		return possibleMove;
	}
	
}