package Piece;

import Board.Board;
import Position.Position;

// Pawn.java
public class Pawn extends Piece {
    public Pawn(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Position start, Position end, Board board) {
        int startRow = start.getRow();
        int startCol = start.getCol();
        int endRow = end.getRow();
        int endCol = end.getCol();

        Piece endPiece = board.getPiece(end);

        int rowDiff = endRow - startRow;
        int colDiff = Math.abs(endCol - startCol);

        // Check if the pawn is white or black
        if (isWhite()) {
            // White pawns move up the board (decreasing row number)
            if (rowDiff == -1 && colDiff == 0 && endPiece == null) {
                // Normal move
                return true;
            } else if (rowDiff == -1 && colDiff == 1 && endPiece != null && !endPiece.isWhite()) {
                // Capture move
                return true;
            } else if (startRow == 6 && rowDiff == -2 && colDiff == 0 && endPiece == null &&
                    board.getPiece(new Position(startRow - 1, startCol)) == null) {
                // Double move from starting position
                return true;
            }
        } else {
            // Black pawns move down the board (increasing row number)
            if (rowDiff == 1 && colDiff == 0 && endPiece == null) {
                // Normal move
                return true;
            } else if (rowDiff == 1 && colDiff == 1 && endPiece != null && endPiece.isWhite()) {
                // Capture move
                return true;
            } else if (startRow == 1 && rowDiff == 2 && colDiff == 0 && endPiece == null &&
                    board.getPiece(new Position(startRow + 1, startCol)) == null) {
                // Double move from starting position
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return isWhite() ? "P" : "p";
    }
}
