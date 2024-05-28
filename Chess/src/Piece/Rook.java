package Piece;

import Board.Board;
import Position.Position;

// Rook.java
public class Rook extends Piece {
    public Rook(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Position start, Position end, Board board) {
        int startRow = start.getRow();
        int startCol = start.getCol();
        int endRow = end.getRow();
        int endCol = end.getCol();

        // Check if the move is in a straight line (either same row or same column)
        if (startRow == endRow || startCol == endCol) {
            // Ensure there are no pieces blocking the path
            if (isPathClear(start, end, board)) {
                Piece endPiece = board.getPiece(end);
                return endPiece == null || endPiece.isWhite() != this.isWhite();
            }
        }

        return false;
    }

    private boolean isPathClear(Position start, Position end, Board board) {
        int startRow = start.getRow();
        int startCol = start.getCol();
        int endRow = end.getRow();
        int endCol = end.getCol();

        int rowStep = Integer.signum(endRow - startRow);
        int colStep = Integer.signum(endCol - startCol);

        int currentRow = startRow + rowStep;
        int currentCol = startCol + colStep;

        while (currentRow != endRow || currentCol != endCol) {
            if (board.getPiece(new Position(currentRow, currentCol)) != null) {
                return false;
            }
            currentRow += rowStep;
            currentCol += colStep;
        }

        return true;
    }

    @Override
    public String toString() {
        return isWhite() ? "R" : "r";
    }
}
