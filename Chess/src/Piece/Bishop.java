package Piece;

import Board.Board;
import Position.Position;

// Bishop.java
public class Bishop extends Piece {
    public Bishop(boolean isWhite) {
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

        // Check if the move is diagonal
        if (rowDiff == colDiff) {
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
        return isWhite() ? "B" : "b";
    }
}
