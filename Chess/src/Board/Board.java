package Board;

// Board.java
import java.util.ArrayList;
import java.util.List;

import Piece.Bishop;
import Piece.King;
import Piece.Knight;
import Piece.Pawn;
import Piece.Piece;
import Piece.Queen;
import Piece.Rook;
import Position.Position;

public class Board {
    private Piece[][] board;

    public Board() {
        board = new Piece[8][8];
        initializeBoard();
    }

    private void initializeBoard() {
        // Colocar piezas blancas
        board[0][0] = new Rook(true);
        board[0][1] = new Knight(true);
        board[0][2] = new Bishop(true);
        board[0][3] = new Queen(true);
        board[0][4] = new King(true);
        board[0][5] = new Bishop(true);
        board[0][6] = new Knight(true);
        board[0][7] = new Rook(true);

        for (int i = 0; i < 8; i++) {
            board[1][i] = new Pawn(true);
        }

        // Colocar piezas negras
        board[7][0] = new Rook(false);
        board[7][1] = new Knight(false);
        board[7][2] = new Bishop(false);
        board[7][3] = new Queen(false);
        board[7][4] = new King(false);
        board[7][5] = new Bishop(false);
        board[7][6] = new Knight(false);
        board[7][7] = new Rook(false);

        for (int i = 0; i < 8; i++) {
            board[6][i] = new Pawn(false);
        }
    }

    public Piece getPiece(Position position) {
        return board[position.getRow()][position.getCol()];
    }

    public void setPiece(Position position, Piece piece) {
        board[position.getRow()][position.getCol()] = piece;
    }

    public void movePiece(Position start, Position end) {
        Piece piece = getPiece(start);
        if (piece != null && piece.isValidMove(start, end, this)) {
            setPiece(end, piece);
            setPiece(start, null);
        }
    }

    public void displayBoard() {
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                Piece piece = board[row][col];
                System.out.print((piece != null ? piece.toString() : ".") + " ");
            }
            System.out.println();
        }
    }

    public boolean isValidPosition(Position position) {
        int row = position.getRow();
        int col = position.getCol();
        return row >= 0 && row < 8 && col >= 0 && col < 8;
    }
}
