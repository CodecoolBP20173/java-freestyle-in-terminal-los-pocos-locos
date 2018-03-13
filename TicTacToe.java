package TicTacToe;

import TerminalManipulation.src.com.codecool.termlib.Terminal;
import TerminalManipulation.src.com.codecool.termlib.Color;
import TerminalManipulation.src.com.codecool.termlib.Attribute;
import TerminalManipulation.src.com.codecool.termlib.Direction;
//import com.sun.org.apache.regexp.internal.recompile;
//import com.sun.org.apache.xpath.internal.operations.String;

public class TicTacToe {

    public static void main(String[] args) {
        String[][] board = new String[][] { { "_", "x", "_" }, { "_", "_", "_" }, { "_", "_", "_" } };
        Terminal term = new Terminal();
        term.printField(board);
    }

    public static Boolean WinCheck(String a, String[][] board) {
        return false;
    }

    public static Boolean horizontalCheck(String a, String[][] board) {
        return false;
    }

    public static Boolean verticalCheck(String a, String[][] board) {
        return false;
    }

    public static Boolean diagonalDownwardslCheck(String a, String[][] board) {
        String lastItem = a;
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (i == j) {
                    if (i == 0 && j == 0) {
                        lastItem = board[i][j];
                    } else {
                        if (board[i][j] == lastItem) {
                            count++;
                        }
                    }
                }
            }
        }
        if (count == board.length - 1) {
            return true;
        } else {
            return false;
        }
    }

    public static Boolean DiagonalUpwardsCheck(String a, String[][] board) {
        return false;
    }

}
