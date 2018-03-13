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
            int WinCounter = 0;
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] == a) {
                    WinCounter++;
                }
            }if (WinCounter == 3){
                return true;
            }
            
        }
        return false;
    }

    public static Boolean verticalCheck(String a, String[][] board) {
        for (int i = 0; i < board.length; i++) {
            int WinCounter = 0;
            for (int j = 0; j < board.length; j++){
                if (board[j][i] == a){
                    WinCounter++;
                }
            if (WinCounter == 3){
                return true;
                }

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

    public static void UserInput(String player) {
        Scanner user_input = new Scanner(System.in);
        System.out.println("Which array: ");
        int array = user_input.nextInt();        
        System.out.println("Which element: ");
        int element = user_input.nextInt();
        user_input.close();

    }
}
