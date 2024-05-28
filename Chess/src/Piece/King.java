package Piece;

import Board.Board;
import Position.Position;

//King.java
public class King extends Piece {
 public King(boolean isWhite) {
     super(isWhite);
 }

 @Override
 public boolean isValidMove(Position start, Position end, Board board) {
     int startRow = start.getRow();
     int startCol = start.getCol();
     int endRow = end.getRow();
     int endCol = end.getCol();

     // Calculate the absolute difference in rows and columns
     int rowDiff = Math.abs(endRow - startRow);
     int colDiff = Math.abs(endCol - startCol);

     // Check if the move is within one square in any direction
     if (rowDiff <= 1 && colDiff <= 1) {
         Piece endPiece = board.getPiece(end);
         // Check if the end position is either empty or contains an opponent's piece
         return endPiece == null || endPiece.isWhite() != this.isWhite();
     }

     return false;
 }

 @Override
 public String toString() {
     return isWhite() ? "K" : "k";
 }
}
