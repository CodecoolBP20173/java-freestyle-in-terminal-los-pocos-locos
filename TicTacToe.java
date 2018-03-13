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
        for (i = 0; i < board.length; i++) {
            if (board[i][0] == a && board[i][1] == a && board[i][2] == a) {
                return true;
            }
        }
    }

    public static Boolean verticalCheck(String a, String[][] board) {
        for (i = 0; i < board.length; i++) {
            if (board[0][i] == a && board[1][i] == a && board[2][i] == a) {
                return true;
            }
        }

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

    public static void UserInput(String player) {
        Scanner user_input = new Scanner(System.in);
        System.out.println("Which array: ");
        int array = user_input.nextInt();        
        System.out.println("Which element: ");
        int element = user_input.nextInt();
        user_input.close();

    }
}
