package TicTacToe;

import TerminalManipulation.src.com.codecool.termlib.Terminal;
import TerminalManipulation.src.com.codecool.termlib.Color;
import TerminalManipulation.src.com.codecool.termlib.Attribute;
import TerminalManipulation.src.com.codecool.termlib.Direction;
//import com.sun.org.apache.regexp.internal.recompile;
//import com.sun.org.apache.xpath.internal.operations.String;

public class TicTacToe {

    public static void main(String[] args) {
        String[][] board = new String[][] { { "-", "-", "-" , "-"}, { "-", "-", "-" , "-"},{ "-", "-", "-" , "-"},{ "-", "-", "-" ,"-"} };
        Terminal term = new Terminal();
        term.printField(board);
    }

    public static Boolean WinCheck(String a, String[][] board) {
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

    public static Boolean DiagonalUpwardsCheck(String a, String[][] board) {
        return false;
    }

}
