package Piece;

import Board.Board;
import Position.Position;

public abstract class Piece {
    private boolean isWhite;

    public Piece(boolean isWhite) {
        this.isWhite = isWhite;
    }

    public boolean isWhite() {
        return isWhite;
    }

    public abstract boolean isValidMove(Position start, Position end, Board board);

    @Override
    public abstract String toString();
}