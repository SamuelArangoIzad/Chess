package Piece;

import Board.Board;
import Position.Position;

// Knight.java
public class Knight  extends Piece {
    public Knight(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Position start, Position end, Board board) {
        int startRow = start.getRow();
        int startCol = start.getCol();
        int endRow = end.getRow();
        int endCol = end.getCol();

        int rowDiff = Math.abs(endRow - startRow);
        int colDiff = Math.abs(endCol - startCol);

        // Check if the move is an L-shape
        if ((rowDiff == 2 && colDiff == 1) || (rowDiff == 1 && colDiff == 2)) {
            Piece endPiece = board.getPiece(end);
            return endPiece == null || endPiece.isWhite() != this.isWhite();
        }

        return false;
    }

    @Override
    public String toString() {
        return isWhite() ? "N" : "n";
    }
}
