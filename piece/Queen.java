package piece;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import board.Board;
import board.Tile;

public class Queen extends Piece{
	private int curX;
	private int curY;
	
	//Constructor
	public Queen(String id, BufferedImage img, int color) {
		super(id, img, color);
	}

	@Override
	public ArrayList<Tile> move(int cur_X, int cur_Y) {
		this.curX = cur_X;
		this.curY = cur_Y;
		possibleMove.clear();
		
		/*Vertical direction*/
			//���� ����
				for(int left=1; left<=curY; left++) {
					if(Board.board[curX][curY-left].getPiece() == null)			//�� ĭ�̸� ������ �̵�
						possibleMove.add(Board.board[curX][curY-left]);
					else {														//��� ���� ���� ��� ����� ���̸� ������ �̵�
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
				
			/*Diagonal direction*/
				//���� ��
				for(int i=1; i<=curY; i++) {
					if(curX-i < 0 || curX-i > 7 || curY-i < 0 || curY-i > 7) break;	//�ε��� ���� �� ���ο� ���� ���� ����
					if(Board.board[curX-i][curY-i].getPiece() == null)			//��������� ������ �̵�
						possibleMove.add(Board.board[curX-i][curY-i]);
					else {												//������� ���� ĭ�� �� ����� ���̸� �̵� ����
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
					if(curX+i < 0 || curX+i > 7 || curY-i < 0 || curY-i > 7) break;
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
