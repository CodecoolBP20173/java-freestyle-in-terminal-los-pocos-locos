package TicTacToe;

import TerminalManipulation.src.com.codecool.termlib.Terminal;
import TerminalManipulation.src.com.codecool.termlib.Color;
import TerminalManipulation.src.com.codecool.termlib.Attribute;
import TerminalManipulation.src.com.codecool.termlib.Direction;
import java.util.Scanner;
//import com.sun.org.apache.regexp.internal.recompile;
//import com.sun.org.apache.xpath.internal.operations.String;

public class TicTacToe {

    public static void main(String[] args) {
        String[][] board = generateBoard(3);
        Terminal term = new Terminal();
        term.printField(board);
        Boolean win = diagonalUpwardsCheck("x", board);
        System.out.println(win);
    }

    public static Boolean winCheck(String a, String[][] board) {
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

    public static Boolean diagonalDownwardslCheck(String a, String[][] board) {
        String lastItem = a;
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

    public static Boolean diagonalUpwardsCheck(String a, String[][] board) {
        String lastItem = a;
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

    public static void userInput(String player) {
        Scanner user_input = new Scanner(System.in);
        System.out.println("Which array: ");
        int array = user_input.nextInt();
        System.out.println("Which element: ");
        int element = user_input.nextInt();
        user_input.close();

    }
}
