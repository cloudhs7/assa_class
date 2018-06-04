package piece;

import java.util.ArrayList;

import board.Board;
import board.Tile;
import java.awt.image.BufferedImage;

public class Knight extends Piece{
   private int curX;
   private int curY;

      
   //Constructor
   public Knight(String id, BufferedImage img, int color) {
	   super(id, img, color);
    }
   
   //method
   @Override
   public ArrayList<Tile> move(int cur_X, int cur_Y)
   {
      this.curX = cur_X;
      this.curY = cur_Y;
      possibleMove.clear();
      int[] possibleX = {curX+1,curX+1,curX+2,curX+2,curX-1,curX-1,curX-2,curX-2};
      int[] possibleY = {curY-2,curY+2,curY-1,curY+1,curY-2,curY+2,curY-1,curY+1};         //기본적으로 갈 수 있는 8칸

      
      for(int i=0;i<8;i++){          
            if(possibleX[i]>=0 && possibleX[i]<8 && possibleY[i]>=0 && possibleY[i]<8){         //이동할 좌표 8*8안에 있는지
               if(Board.board[possibleX[i]][possibleY[i]].getPiece() == null || Board.board[possibleX[i]][possibleY[i]].getColor() != Board.board[curX][curY].getColor())
               {                        //이동할 좌표가 비어있거나, 적의 말이 있는지
                     possibleMove.add(Board.board[possibleX[i]][possibleY[i]]);
               }
            }
      }      
      return possibleMove;
   }

 /*  public int[] getPossibleX() {return possibleX;}
   public void setPossibleX(int possibleX[]) {   this.possibleX = possibleX;}
   public int[] getPossibleY() {return possibleY;}
   public void setPossibleY(int possibleY[]) {   this.possibleY = possibleY;}
*/
}