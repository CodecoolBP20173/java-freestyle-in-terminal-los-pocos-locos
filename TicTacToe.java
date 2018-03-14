
package TicTacToe;

import TerminalManipulation.src.com.codecool.termlib.Terminal;
import TerminalManipulation.src.com.codecool.termlib.Color;
import TerminalManipulation.src.com.codecool.termlib.Attribute;
import TerminalManipulation.src.com.codecool.termlib.Direction;

import java.util.Arrays;
import java.util.Scanner;

public class TicTacToe {

    public static String[][] board = generateBoard(3);

    public static Terminal term = new Terminal();

    public static void main(String[] args) {
        term.resetStyle();
        Scanner user_input = new Scanner(System.in);
        int[][] positions = new int[10][2];
        term.clearScreen();
        term.printField(board, positions);
        while (true) {
            int mynumb = userInput(user_input, "x");
            int[] indexArray = decisionIndexChanger(mynumb, board.length);
            move("x", indexArray);
            term.moveToAndPrint(positions[mynumb][0], positions[mynumb][1], "x");
            if (winCheck("x")) {
                break;
            }
            mynumb = userInput(user_input, "o");
            indexArray = decisionIndexChanger(mynumb, board.length);
            move("o", indexArray);
            term.moveToAndPrint(positions[mynumb][0], positions[mynumb][1], "o");
            if (winCheck("o")) {
                break;
            }
        }
        user_input.close();
        System.out.print("Winner Winner Chicken Dinner\n");
    }

    public static Boolean winCheck(String a) {
        if (horizontalCheck(a) || verticalCheck(a) || diagonalDownwardslCheck(a) || diagonalUpwardsCheck(a)) {
            return true;
        }
        return false;
    }

    public static Boolean horizontalCheck(String a) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == a && board[i][1] == a && board[i][2] == a) {
                return true;
            }
        }
        return false;
    }

    public static Boolean verticalCheck(String a) {
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == a && board[1][i] == a && board[2][i] == a) {
                return true;
            }
        }
        return false;
    }

    public static Boolean diagonalDownwardslCheck(String lastItem) {
        int matchCount = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i == j) {
                    if (lastItem == board[i][j]) {
                        matchCount++;
                    }
                }
            }
        }
        if (matchCount == board.length) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean diagonalUpwardsCheck(String lastItem) {
        int matchCount = 0;
        for (int i = board.length - 1; i >= 0; i--) {
            for (int j = 0; j < board.length; j++) {
                if (i + j == board.length - 1) {
                    if (lastItem == board[i][j]) {
                        matchCount++;
                    }
                }
            }
        }
        if (matchCount == board.length) {
            return true;
        } else {
            return false;
        }
    }

    public static String[][] generateBoard(int size) {
        String[][] board = new String[size][size];
        int tileCount = 1;
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = Integer.toString(tileCount);
                tileCount++;
            }
        }
        return board;
    }

    public static int[] decisionIndexChanger(Integer decision, int boardsize) {
        int rowIndex = decision / boardsize;
        int tempColumnIndex = decision % boardsize;
        int columnIndex;
        if (tempColumnIndex == 0) {
            columnIndex = boardsize - 1;
            rowIndex--;
        } else {
            columnIndex = (decision % boardsize) - 1;
        }
        int[] array = new int[] { rowIndex, columnIndex };
        return array;
    }

    public static Integer userInput(Scanner user_input, String player) {
        while (true) {
            try {
                System.out.print("\033[8;1H\033[K");
                System.out.print(player + "'s turn:");
                Integer number = user_input.nextInt();
                if (!validMove(player, number)) {
                    System.out.print("\033[1D\033[0J");
                    continue;
                }
                return number;
            } catch (java.lang.ArrayIndexOutOfBoundsException | java.util.NoSuchElementException e) {
                user_input.nextLine();
            }
        }

    }

    public static void move(String player, int[] coords) {
        board[coords[0]][coords[1]] = player;
    }

    public static Boolean validMove(String player, Integer input) {
        int[] coordinate = decisionIndexChanger(input, 3);
        if (board[coordinate[0]][coordinate[1]] == "x" || board[coordinate[0]][coordinate[1]] == "o") {
            return false;
        }
        return true;
    }

}
