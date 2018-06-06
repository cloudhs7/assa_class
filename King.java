package piece;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import board.Tile;
import board.Board;

public class King extends Piece {
	public int curX;
	public int curY;
	private int[] possibleX = {curX+1,curX+1,curX+1,curX,curX,curX-1,curX-1};
	private int[] possibleY = {curY-1,curY,curY+1,curY-1,curY+1,curY-1,curY,curY+1};         //�⺻������ �� �� �ִ� 7ĭ
	      
	//Constructor
	public King (String id, BufferedImage img, int color) {
	     super(id, img, color);
	 }
	   
	   //method
	@Override
	   public ArrayList<Tile> move(int curX, int curY)
	   {
	      this.curX = curX;
	      this.curY = curY;

	      if(curX>=0 && curX<8 && curY>=0 && curY<8){                                       //8*8 �ȿ� �ִ���
	         for(int i=0;i<8;i++){
	            if(possibleX[i]>=0 && possibleX[i]<8 && possibleY[i]>=0 && possibleY[i]<8 ){         //�̵��� ��ǥ�� 8*8�ȿ� �ִ��� 
	            	  if((!isCheck(possibleX[i],possibleY[i],Board.board[curX][curY].getColor()))
	            			  &&(Board.board[possibleX[i]][possibleY[i]].getPiece() == null || Board.board[possibleX[i]][possibleY[i]].getColor() != Board.board[curX][curY].getColor()))                      
	                        possibleMove.add(Board.board[possibleX[i]][possibleY[i]]);		 //�̵��� ��ǥ�� ����ְų�, ���� ���� �ִ���
	            }
	         }
	      }      
	      return possibleMove;
	   }

	   public int[] getPossibleX() {return possibleX;}
	   public void setPossibleX(int possibleX[]) {   this.possibleX = possibleX;}
	   public int[] getPossibleY() {return possibleY;}
	   public void setPossibleY(int possibleY[]) {   this.possibleY = possibleY;}

	
	   
	
}
