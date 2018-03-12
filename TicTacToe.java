import com.sun.org.apache.xpath.internal.operations.String;

public class MyClass{
    public static void main(String[] args) {
        String[][] GameBoard = new String[][]{
            {"_","_","_"},
            {"_","_","_"},
            {"_","_","_"}
        };
    }         
    
    public static Boolean WinCheck(String a, String[][] board) {
        
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

    }
    
    public static Boolean DiagonalUpwardsCheck(String a, String[][] board) {

    }

}