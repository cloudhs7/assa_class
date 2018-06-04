package piece;

import java.util.ArrayList;

import board.Board;
import board.Tile;
import java.awt.image.BufferedImage;

public class Pawn extends Piece{
   public int curX = 0;
   public int curY = 0;
   //private int[] possibleX = {curX-1+(2*Piece.color),curX-2+(4*Piece.color)};
   //private int[] possibleY = {curY,curY};     //기본적으로 갈 수 있는 2칸(앞 칸, 앞앞 칸)
   
   //Constructor
   public Pawn(String id, BufferedImage img, int color) {   //white가 0    black이 1
      super(id, img, color);
    }
   
   //method
   @Override
   public ArrayList<Tile> move(int cur_X, int cur_Y)
   {
      possibleMove.clear();
      this.curX = cur_X;
      this.curY = cur_Y;

      if(curX>=0 && curX<8 && curY>=0 && curY<8){                      //8*8 안에 있는지(유효성 검사)
            if(curX == 1 && Board.board[curX][curY].getColor() == 1 )   //검은 말의 폰 위치(curX=1)    
               for(int i=1;i<3;i++) {
            	   if(Board.board[curX+i][curY].getPiece() == null)
            		   possibleMove.add(Board.board[curX+i][curY]);  
            	   else break;
               }
            else if(curX == 6 && Board.board[curX][curY].getColor() == 0) //흰색 말의 폰 위치(curX=6)
                 for(int i=1;i<3;i++) {
                	 if(Board.board[curX-i][curY].getPiece() == null)
                		 possibleMove.add(Board.board[curX-i][curY]);
                	 else break;
                 }
            else if(Board.board[curX][curY].getColor()==1 && curX<=6){   //검은색 말 && 검은색 말이 반대편 끝 칸은 아님 (단 폰의 처음 이동이 아닐 경우)
               if(Board.board[curX+1][curY].getPiece()==null)                                                //폰이 전진할 칸이 null
                  possibleMove.add(Board.board[curX+1][curY]);
               if(Board.board[curX+1][curY-1].getPiece() != null && Board.board[curX+1][curY-1].getColor() != Board.board[curX][curY].getColor())   //폰 시선 기준 오른쪽 앞 차있다 && 적일때
                  possibleMove.add(Board.board[curX+1][curY-1]);                  
               if(Board.board[curX+1][curY+1].getPiece() != null && Board.board[curX+1][curY+1].getColor() != Board.board[curX][curY].getColor())   //폰 시선 기준 왼쪽 앞 차있다 && 적일때
                  possibleMove.add(Board.board[curX+1][curY+1]);
            }
            else if(Board.board[curX][curY].getColor() == 0 && curX>=1){   //흰색 말 && 흰색 말이 반대편 끝 칸은 아님 (단 폰의 처음 이동이 아닐 경우)
               if(Board.board[curX-1][curY].getPiece()==null)                                                //폰이 전진할 칸이 null
                  possibleMove.add(Board.board[curX-1][curY]);                  
               if(Board.board[curX-1][curY+1].getPiece() != null && Board.board[curX-1][curY+1].getColor() != Board.board[curX][curY].getColor())   //폰 시선 기준 오른쪽 앞 차있다 && 적일때
                  possibleMove.add(Board.board[curX-1][curY+1]);
               if(Board.board[curX-1][curY-1].getPiece() != null && Board.board[curX-1][curY-1].getColor() != Board.board[curX][curY].getColor())   //폰 시선 기준 왼쪽 앞 차있다 && 적일때
                  possibleMove.add(Board.board[curX-1][curY-1]);
            }
            else if((Board.board[curX][curY].getColor() == 0 && curX==0) ||(Board.board[curX][curY].getColor() == 1 && curX==7) )   //폰이고, 반대편 끝에 도달
               System.out.println("Promotion!");
            else                                                                               //흰 폰이 x=7이거나 검은 폰이 x=0 즉 불가능
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