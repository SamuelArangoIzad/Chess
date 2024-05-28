package Piece;

import Board.Board;
import Position.Position;

// Queen.java
public class Queen extends Piece {
    public Queen(boolean isWhite) {
        super(isWhite);
    }

    @Override
    public boolean isValidMove(Position start, Position end, Board board) {
        Rook rookMove = new Rook(this.isWhite());
        Bishop bishopMove = new Bishop(this.isWhite());

        // Queen's move is valid if it's valid for either a rook or a bishop
        return rookMove.isValidMove(start, end, board) || bishopMove.isValidMove(start, end, board);
    }

    @Override
    public String toString() {
        return isWhite() ? "Q" : "q";
    }
}
