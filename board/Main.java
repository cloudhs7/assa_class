package board;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.BufferedImage;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import board.ChessPieceSprite.ChessPieceSpriteType;
import board.FirstGUI.ListenerClass;
import piece.Bishop;
import piece.King;
import piece.Knight;
import piece.Pawn;
import piece.Queen;
import piece.Rook;

public class Main{
   protected static Rook wr01, wr02, br01, br02, rr01, rr02, gr01, gr02;
   protected static Knight wn01,wn02, bn01, bn02, rn01, rn02, gn01, gn02;
   protected static Bishop wb01, wb02, bb01, bb02, rb01, rb02, gb01, gb02;
   protected static Queen wq,bq,rq,gq;
   protected static King wk,bk,rk,gk;
   protected static Pawn wp[], bp[], rp[], gp[];
   
   Dimension dim = Toolkit.getDefaultToolkit().getScreenSize(); 

   static int Turn = 0;
   static BufferedImage BP = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_PAWN);   
   static BufferedImage WP = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_PAWN);
   static BufferedImage RP = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.RED_PAWN);
   static BufferedImage GP = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.GREEN_PAWN);
  
   static BufferedImage BR = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_LOOK);
   static BufferedImage WR = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_LOOK);
   static BufferedImage RR = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.RED_LOOK);
   static BufferedImage GR = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.GREEN_LOOK);
   
   static BufferedImage BN = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_KNIGHT);
   static BufferedImage WN = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_KNIGHT);
   static BufferedImage RN = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.RED_KNIGHT);
   static BufferedImage GN = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.GREEN_KNIGHT);
  
   static BufferedImage BB = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_BISHOP);
   static BufferedImage WB = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_BISHOP);
   static BufferedImage RB = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.RED_BISHOP);
   static BufferedImage GB = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.GREEN_BISHOP);
   
   static BufferedImage BQ = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_QUEEN);
   static BufferedImage WQ = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_QUEEN);
   static BufferedImage RQ = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.RED_QUEEN);
   static BufferedImage GQ = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.GREEN_QUEEN);

   static BufferedImage BK = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.BLACK_KING);
   static BufferedImage WK = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.WHITE_KING);
   static BufferedImage RK = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.RED_KING);
   static BufferedImage GK = ChessPieceSprite.getInstace().getChessPiece(ChessPieceSpriteType.GREEN_KING);
  
   
   public static void main(String[] args){
      /*Piece image initialization*/
	  //pawn
      bp = new Pawn[8];
      for(int i=0;i<8;i++) {
         bp[i] = new Pawn("BP0"+(i+1),BP,1);
      }
      wp = new Pawn[8];
      for(int i=0;i<8;i++) {
         wp[i] = new Pawn("WP0"+(i+1),WP,0);
      }
      rp = new Pawn[8];
      for(int i=0;i<8;i++) {
         rp[i] = new Pawn("RP0"+(i+1),RP,0);
      }
      gp = new Pawn[8];
      for(int i=0;i<8;i++) {
         gp[i] = new Pawn("GP0"+(i+1),GP,0);
      }
     
      //rook
      br01 = new Rook("BR01",BR,1);
      br02 = new Rook("BR02",BR,1);
      wr01 = new Rook("WR01",WR,0);
      wr02 = new Rook("WR02",WR,0);
      rr01 = new Rook("RR01",RR,0);
      rr02 = new Rook("RR02",RR,0);
      gr01 = new Rook("GR01",GR,0);
      gr02 = new Rook("GR02",GR,0);
     
      //knight
      bn01 = new Knight("BN01",BN, 1);
      bn02 = new Knight("BN02",BN, 1);
      wn01 = new Knight("WN01",WN,0);
      wn02 = new Knight("WN02",WN,0);
      rn01 = new Knight("RN01",RN,0);
      rn02 = new Knight("RN02",RN,0);
      gn01 = new Knight("GN01",GN,0);
      gn02 = new Knight("GN02",GN,0);
     
      //bishop
      bb01 = new Bishop("BB01",BB,1);
      bb02 = new Bishop("BB02",BB,1);
      wb01 = new Bishop("WB01",WB,0);
      wb02 = new Bishop("WB02",WB,0);
      rb01 = new Bishop("RB01",RB,0);
      rb02 = new Bishop("RB02",RB,0);
      gb01 = new Bishop("GB01",GB,0);
      gb02 = new Bishop("GB02",GB,0);
     
      
      //queen, king
      bq = new Queen("BQ",BQ,1);
      wq = new Queen("WQ",WQ,0);
      rq = new Queen("RQ",RQ,0);
      gq = new Queen("GQ",GQ,0);
     
      bk = new King("BK",BK,1);
      wk = new King("WK",WK,0);
      rk = new King("RK",RK,0);
      gk = new King("GK",GK,0);
      
      new FirstGUI();   
   }
}