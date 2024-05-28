package Main;

// Main.java
import java.util.Scanner;

import Board.Board;
import Position.Position;

public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.displayBoard();
            System.out.println("Introduce tu movimiento (e.g., e2 e4) o 'exit' para salir:");

            String input = scanner.nextLine();
            if (input.equalsIgnoreCase("exit")) {
                break;
            }

            String[] parts = input.split(" ");
            if (parts.length == 2) {
                Position start = parsePosition(parts[0]);
                Position end = parsePosition(parts[1]);

                if (start != null && end != null && board.isValidPosition(start) && board.isValidPosition(end)) {
                    board.movePiece(start, end);
                } else {
                    System.out.println("Movimiento inválido. Intenta de nuevo.");
                }
            } else {
                System.out.println("Formato inválido. Intenta de nuevo.");
            }
        }

        scanner.close();
    }

    private static Position parsePosition(String pos) {
        if (pos.length() != 2) {
            return null;
        }

        char colChar = pos.charAt(0);
        char rowChar = pos.charAt(1);

        int col = colChar - 'a';
        int row = 8 - (rowChar - '0');

        if (col >= 0 && col < 8 && row >= 0 && row < 8) {
            return new Position(row, col);
        } else {
            return null;
        }
    }
}
