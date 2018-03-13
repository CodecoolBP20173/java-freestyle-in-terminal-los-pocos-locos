package TicTacToe;

import TerminalManipulation.src.com.codecool.termlib.Terminal;
import TerminalManipulation.src.com.codecool.termlib.Color;
import TerminalManipulation.src.com.codecool.termlib.Attribute;
import TerminalManipulation.src.com.codecool.termlib.Direction;
import java.util.Scanner;
//import com.sun.org.apache.regexp.internal.recompile;
//import com.sun.org.apache.xpath.internal.operations.String;

public class TicTacToe {

    public static Terminal term = new Terminal();

    public static void main(String[] args) {
        String[][] board = new String[][] { { "-", "-", "-" }, { "-", "-", "x" },{ "-", "-", "-" }};
        term.printField(board);
        Boolean win = diagonalUpwardsCheck("x", board);
        System.out.println(win);
        userInput("player");
    }

    public static Boolean winCheck(String a, String[][] board) {
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

    public static Integer userInput(String player) {
        Scanner user_input = new Scanner(System.in);
	while (true){
		try {
        		System.out.println(player + "'s turn:");
        		int number = user_input.nextInt();        
                user_input.close();
                term.clearScreen();
			    return number;
		}
		catch (java.util.InputMismatchException e){
            term.clearScreen();
            user_input.nextLine();
			System.out.println("\nYou have entered an invalid coordinate! \nTry again please!\n");
		}
	} 
    }
    public static void move(String player, int[] coords, String[][] board) {
        board[coords[0]][coords[1]] = player;

    }
}
