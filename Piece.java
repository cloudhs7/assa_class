package piece;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

import board.Board;
import board.Tile;

interface Rule {
	 public boolean isCheck(int curX, int curY, int color);
	 public boolean isCheckmate(int curX, int curY);
	 public boolean isStalemate(int curX, int curY);
}

public abstract class Piece implements Rule {

	String id;
	BufferedImage img;
	public int color;
	ArrayList<Tile> checkmateCheck;   //add
	Tile afterMoveTile;            //add
	public ArrayList<Tile> possibleMove = new ArrayList<Tile>();	
	
	//Constructor
	public Piece(String id, BufferedImage img, int color){
		this.id = id;
		this.color = color;
		this.img = img;
	}
	
	/*Methods*/
	 public abstract ArrayList<Tile> move(int curX, int curY);
	  
	 protected void setId(String id){
		      this.id = id;
		      }
	   
	 public void setImage(BufferedImage image){
		      this.img = image;
		   }
		   
	 protected void setColor(int color) {
		      this.color = color;
		   }
		   
	 public String getId() {
		      return this.id;
		   }
		   
	 public BufferedImage getImage() {
		      return this.img;
		   }
	 
	 
	 /*implements interface Rule*/
	 public boolean isCheck(int curX, int curY,int color /*current location of king*/) {
		  Piece piece_temp;
		
		/*is Check*/
		//Vertical direction (Queen or Rook)
		for(int left=1; left<=curY; left++) {
			if((Board.board[curX][curY-left].getPiece() != null) && (Board.board[curX][curY-left].getColor()!=color)) {
				piece_temp=Board.board[curX][curY-left].getPiece();
				if(piece_temp.id == "wq" || piece_temp.id == "bq" || piece_temp.id =="wr01" || piece_temp.id =="wr02" || piece_temp.id =="br01" || piece_temp.id =="br02") return true;
			}
		}
		for(int right=1; right<=7-curY; right++) {
			if((Board.board[curX][curY+right].getPiece() != null) && (Board.board[curX][curY+right].getColor()!=color)) {
				piece_temp=Board.board[curX][curY+right].getPiece();
				if(piece_temp.id == "wq" || piece_temp.id == "bq" || piece_temp.id =="wr01" || piece_temp.id =="wr02" || piece_temp.id =="br01" || piece_temp.id =="br02") return true;
			}
		}
		for(int up=1; up<=curX; up++) {
			if((Board.board[curX-up][curY].getPiece() != null) && (Board.board[curX-up][curY].getColor()!=color)) {
				piece_temp=Board.board[curX-up][curY].getPiece();
				if(piece_temp.id == "wq" || piece_temp.id == "bq" || piece_temp.id =="wr01" || piece_temp.id =="wr02" || piece_temp.id =="br01" || piece_temp.id =="br02") return true;
			}
		}
		for(int down=1; down<=7-curX; down++) {
			if((Board.board[curX+down][curY].getPiece() != null) && (Board.board[curX+down][curY].getColor()!=color)) {
				piece_temp=Board.board[curX+down][curY].getPiece();
				if(piece_temp.id == "wq" || piece_temp.id == "bq" || piece_temp.id =="wr01" || piece_temp.id =="wr02" || piece_temp.id =="br01" || piece_temp.id =="br02") return true;
			}
		}
		
		
		
		//Diagonal direction (Queen or Bishop)
		for(int i=1; i<=curY; i++) {
			if(curX-i < 0 || curX-i > 7 || curY-i < 0 || curY-i > 7) break;
			if(Board.board[curX-i][curY-i].getPiece() != null && Board.board[curX-i][curY-i].getColor() != Board.board[curX][curY].getColor()) {
				piece_temp=Board.board[curX-i][curY-i].getPiece();
				if(piece_temp.id == "wq" || piece_temp.id == "bq" || piece_temp.id =="wb01" || piece_temp.id =="wb02" || piece_temp.id =="bb01" || piece_temp.id =="bb02") return true;
			}
		}
		for(int i=1; i<=7-curY; i++) {
			if(curX-i < 0 || curX-i > 7 || curY+i < 0 || curY+i > 7) break;
			if(Board.board[curX-i][curY+i].getPiece() != null && Board.board[curX-i][curY+i].getColor() != color) {
				piece_temp=Board.board[curX-i][curY+i].getPiece();
				if(piece_temp.id == "wq" || piece_temp.id == "bq" || piece_temp.id =="wb01" || piece_temp.id =="wb02" || piece_temp.id =="bb01" || piece_temp.id =="bb02") return true;
			}
		}
		for(int i=1; i<=7-curX; i++) {
			if(curX+i < 0 || curX+i > 7 || curY-i < 0 || curY-i > 7) break;
			if(Board.board[curX+i][curY-i].getPiece() != null && Board.board[curX+i][curY-i].getColor() != color) {
				piece_temp=Board.board[curX+i][curY-i].getPiece();
				if(piece_temp.id == "wq" || piece_temp.id == "bq" || piece_temp.id =="wb01" || piece_temp.id =="wb02" || piece_temp.id =="bb01" || piece_temp.id =="bb02") return true;
			}
		}
		for(int i=1; i<=7-curX; i++) {
			if(curX+i < 0 || curX+i > 7 || curY+i < 0 || curY+i > 7) break;
			if(Board.board[curX+i][curY+i].getPiece() != null && Board.board[curX+i][curY+i].getColor() != color) {
				piece_temp=Board.board[curX+i][curY+i].getPiece();
				if(piece_temp.id == "wq" || piece_temp.id == "bq" || piece_temp.id =="wb01" || piece_temp.id =="wb02" || piece_temp.id =="bb01" || piece_temp.id =="bb02") return true;
			}
		}
		
		
		//Knight direction
		for(int i=-2, k=0; i<=2; i++) {
			if(Math.abs(i)==1) k = 2;
			else if(Math.abs(i)==2) k = 1;
			else k = 0;
			
			if(curX+i>=0 && curX+i<8 && curY+k>=0 && curY+k<8) {
				if(Board.board[curX+i][curY+k] != null && Board.board[curX+i][curY+i].getColor() != color) {
					piece_temp=Board.board[curX+i][curY+i].getPiece();
					if(piece_temp.id == "wn01" || piece_temp.id == "wn02" || piece_temp.id == "bn01" || piece_temp.id == "bn02") return true;
				}
			}
			if(curX+i>=0 && curX+i<8 && curY-k>=0 && curY-k<8) {
				if(Board.board[curX+i][curY-k] != null && Board.board[curX+i][curY-i].getColor() != color) {
					piece_temp=Board.board[curX+i][curY-i].getPiece();
					if(piece_temp.id == "wn01" || piece_temp.id == "wn02" || piece_temp.id == "bn01" || piece_temp.id == "bn02") return true;
				}
			}
		}
		
		
		//Pawn direction
		if(color==0) {			//king is white
			if(curX-1>=0 && curX-1<8 && curY-1>=0 && curY-1<8) {
				if(Board.board[curX-1][curY-1]!=null && Board.board[curX-1][curY-1].getColor()==1) {
					piece_temp=Board.board[curX-1][curY-1].getPiece();
					if(piece_temp.id.contains("p")) return true;
				}
			}
			if(curX-1>=0 && curX-1<8 && curY+1>=0 && curY+1<8) {
				if(Board.board[curX-1][curY+1]!=null && Board.board[curX-1][curY+1].getColor()==1) {
					piece_temp=Board.board[curX-1][curY+1].getPiece();
					if(piece_temp.id.contains("p")) return true;
				}
			}
		}
		else {										//king is black
			if(curX+1>=0 && curX+1<8 && curY-1>=0 && curY-1<8) {
				if(Board.board[curX+1][curY-1]!=null && Board.board[curX+1][curY-1].getColor()==0) {
					piece_temp=Board.board[curX+1][curY-1].getPiece();
					if(piece_temp.id.contains("p")) return true;
				}
			}
			if(curX+1>=0 && curX+1<8 && curY+1>=0 && curY+1<8) {
				if(Board.board[curX+1][curY+1]!=null && Board.board[curX+1][curY+1].getColor()==0) {
					piece_temp=Board.board[curX+1][curY+1].getPiece();
					if(piece_temp.id.contains("p")) return true;
				}
			}
		}
		
		
		 /*is not Check*/
		 return false;
	}
	 
	 public boolean isCheckmate(int curX, int curY){
	      int i=0;
	      if(isCheck(curX, curY,Board.board[curX][curY].getColor()) == true){            //이동 전 check 가 true이면서
	          checkmateCheck = move(curX, curY);         //checkmateCheck는 ArrayList<Tile>로 맨위에 선언함, 여기에다가 possible move 대입
	          CLABEL:
	          for(i=0; i<checkmateCheck.size();i++){   //possible move에 저장된 애들 순회
	                afterMoveTile = checkmateCheck.get(i);//이렇게 하면 움직인 곳에 king 들어감(possible좌표에_
	                Board.board[curX][curY].setPiece(null);//원래 있던 곳은 piece가 null로 만들어 놓은 후에, king이 움직인 후의 8가지의 경우에 대해 check 검사를 할거임
	               if(isCheck(checkmateCheck.get(i).getX(),checkmateCheck.get(i).getY(),Board.board[checkmateCheck.get(i).getX()][checkmateCheck.get(i).getY()].getColor())==true)//possibleㅡmove의 각 좌표에 대해 check 검사
	                     continue CLABEL;            //8가지 경우에 대해 다 검사함
	               else return false;
	          }    
	      if(i==checkmateCheck.size()) return true;      //8가지 경우에 대해 true면 true를 반환하세요.
	      }
	      return false;                           //나머진 false
	    }
	    
	 public boolean isStalemate(int curX, int curY){
	        int j=0;
	        if(isCheck(curX, curY,Board.board[curX][curY].getColor()) == false){               //이동 전 check 가 false이면서
	             checkmateCheck = move(curX, curY);         //checkmateCheck는 ArrayList<Tile>로 맨위에 선언함, 여기에다가 possible move 대입
	             CLABEL:
	             for(j=0; j<checkmateCheck.size();j++){   //possible move에 저장된 애들 순회
	                   afterMoveTile = checkmateCheck.get(j);//이렇게 하면 움직인 곳에 king 들어감(possible좌표에_
	                   Board.board[curX][curY].setPiece(null);//원래 있던 곳은 piece가 null로 만들어 놓은 후에, king이 움직인 후의 8가지의 경우에 대해 check 검사를 할거임
	                  if(isCheck(checkmateCheck.get(j).getX(),checkmateCheck.get(j).getY(),Board.board[checkmateCheck.get(j).getX()][checkmateCheck.get(j).getY()].getColor())==true)//possiblemove의 각 좌표에 대해 check 검사
	                        continue CLABEL;            //8가지 경우에 대해 다 검사함
	                  else return false;
	             }    
	         if(j==checkmateCheck.size()) return true;      //8가지 경우에 대해 true면 true를 반환하세요.
	         }
	        return false;
	     }
}
