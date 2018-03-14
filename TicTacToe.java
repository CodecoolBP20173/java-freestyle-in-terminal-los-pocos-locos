package TicTacToe;

import TerminalManipulation.src.com.codecool.termlib.Terminal;
import TerminalManipulation.src.com.codecool.termlib.Color;
import TerminalManipulation.src.com.codecool.termlib.Attribute;
import TerminalManipulation.src.com.codecool.termlib.Direction;

import java.util.Arrays;
import java.util.Scanner;
//import com.sun.org.apache.regexp.internal.recompile;
//import com.sun.org.apache.xpath.internal.operations.String;

public class TicTacToe {

    public static Terminal term = new Terminal();

    public static void main(String[] args) {
        Scanner user_input = new Scanner(System.in);
        String[][] board = generateBoard(3);
        term.clearScreen();
        term.printField(board);
        while (true) {
            String mynumb = userInput(user_input, "x");
            int[] kecske = decisionIndexChanger(mynumb, board.length);
            move("x", kecske, board);
            term.clearScreen();
            term.printField(board);
            if (winCheck("x", board)){
                break;
            }
            mynumb = userInput(user_input, "o");
            kecske = decisionIndexChanger(mynumb, board.length);
            move("o", kecske, board);
            term.clearScreen();
            term.printField(board);
            if (winCheck("o", board)){
                break;
            }
        }
        user_input.close();
    }

    public static Boolean winCheck(String a, String[][] board) {
        if (horizontalCheck(a, board) || verticalCheck(a, board) || diagonalDownwardslCheck(a, board) || diagonalUpwardsCheck(a, board)){
            return true;
        }
        return false;
    }

    public static Boolean horizontalCheck(String a, String[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] == a && board[i][1] == a && board[i][2] == a) {
                return true;
            }
        }
        return false;
    }

    public static Boolean verticalCheck(String a, String[][] board) {
        for (int i = 0; i < board.length; i++) {
            if (board[0][i] == a && board[1][i] == a && board[2][i] == a) {
                return true;
            }
        }
        return false;
    }

    public static Boolean diagonalDownwardslCheck(String lastItem, String[][] board) {
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

    public static Boolean diagonalUpwardsCheck(String lastItem, String[][] board) {
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

    public static int[] decisionIndexChanger(String decision, int boardsize) {
        int decisionInt = Integer.parseInt(decision);
        int rowIndex = decisionInt / boardsize;
        int tempColumnIndex = decisionInt % boardsize;
        int columnIndex;
        if (tempColumnIndex == 0) {
            columnIndex = boardsize - 1;
            rowIndex--;
        } else {
            columnIndex = (decisionInt % boardsize) - 1;
        }
        int[] array = new int[] { rowIndex, columnIndex };
        return array;
    }

    public static String userInput(Scanner user_input ,String player) {
        while (true) {
            try {
                System.out.println(player + "'s turn:");
                String number = user_input.next();
                return number;
            } catch (java.util.InputMismatchException e) {
                user_input.nextLine();
                System.out.println("\nYou have entered an invalid coordinate! \nTry again please!\n");
            }
        }

    }

    public static void move(String player, int[] coords, String[][] board) {
        board[coords[0]][coords[1]] = player;
    }
}
