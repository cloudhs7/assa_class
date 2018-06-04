package piece;

import java.util.ArrayList;

import board.Board;
import board.Tile;
import java.awt.image.BufferedImage;

public class Pawn extends Piece{
   public int curX = 0;
   public int curY = 0;
   //private int[] possibleX = {curX-1+(2*Piece.color),curX-2+(4*Piece.color)};
   //private int[] possibleY = {curY,curY};     //�⺻������ �� �� �ִ� 2ĭ(�� ĭ, �վ� ĭ)
   
   //Constructor
   public Pawn(String id, BufferedImage img, int color) {   //white�� 0    black�� 1
      super(id, img, color);
    }
   
   //method
   @Override
   public ArrayList<Tile> move(int cur_X, int cur_Y)
   {
      possibleMove.clear();
      this.curX = cur_X;
      this.curY = cur_Y;

      if(curX>=0 && curX<8 && curY>=0 && curY<8){                      //8*8 �ȿ� �ִ���(��ȿ�� �˻�)
            if(curX == 1 && Board.board[curX][curY].getColor() == 1 )   //���� ���� �� ��ġ(curX=1)    
               for(int i=1;i<3;i++) {
            	   if(Board.board[curX+i][curY].getPiece() == null)
            		   possibleMove.add(Board.board[curX+i][curY]);  
            	   else break;
               }
            else if(curX == 6 && Board.board[curX][curY].getColor() == 0) //��� ���� �� ��ġ(curX=6)
                 for(int i=1;i<3;i++) {
                	 if(Board.board[curX-i][curY].getPiece() == null)
                		 possibleMove.add(Board.board[curX-i][curY]);
                	 else break;
                 }
            else if(Board.board[curX][curY].getColor()==1 && curX<=6){   //������ �� && ������ ���� �ݴ��� �� ĭ�� �ƴ� (�� ���� ó�� �̵��� �ƴ� ���)
               if(Board.board[curX+1][curY].getPiece()==null)                                                //���� ������ ĭ�� null
                  possibleMove.add(Board.board[curX+1][curY]);
               if(Board.board[curX+1][curY-1].getPiece() != null && Board.board[curX+1][curY-1].getColor() != Board.board[curX][curY].getColor())   //�� �ü� ���� ������ �� ���ִ� && ���϶�
                  possibleMove.add(Board.board[curX+1][curY-1]);                  
               if(Board.board[curX+1][curY+1].getPiece() != null && Board.board[curX+1][curY+1].getColor() != Board.board[curX][curY].getColor())   //�� �ü� ���� ���� �� ���ִ� && ���϶�
                  possibleMove.add(Board.board[curX+1][curY+1]);
            }
            else if(Board.board[curX][curY].getColor() == 0 && curX>=1){   //��� �� && ��� ���� �ݴ��� �� ĭ�� �ƴ� (�� ���� ó�� �̵��� �ƴ� ���)
               if(Board.board[curX-1][curY].getPiece()==null)                                                //���� ������ ĭ�� null
                  possibleMove.add(Board.board[curX-1][curY]);                  
               if(Board.board[curX-1][curY+1].getPiece() != null && Board.board[curX-1][curY+1].getColor() != Board.board[curX][curY].getColor())   //�� �ü� ���� ������ �� ���ִ� && ���϶�
                  possibleMove.add(Board.board[curX-1][curY+1]);
               if(Board.board[curX-1][curY-1].getPiece() != null && Board.board[curX-1][curY-1].getColor() != Board.board[curX][curY].getColor())   //�� �ü� ���� ���� �� ���ִ� && ���϶�
                  possibleMove.add(Board.board[curX-1][curY-1]);
            }
            else if((Board.board[curX][curY].getColor() == 0 && curX==0) ||(Board.board[curX][curY].getColor() == 1 && curX==7) )   //���̰�, �ݴ��� ���� ����
               System.out.println("Promotion!");
            else                                                                               //�� ���� x=7�̰ų� ���� ���� x=0 �� �Ұ���
               System.out.println("Error - Pawn cannot move back!");       
      }
      return possibleMove;      
   }
   /*
   public int[] getPossibleX() {return possibleX;}
   public void setPossibleX(int possibleX[]) {this.possibleX = possibleX;}
   public int[] getPossibleY() {return possibleY;}
   public void setPossibleY(int possibleY[]) {this.possibleY = possibleY;}
   */
}