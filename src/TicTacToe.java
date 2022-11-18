import java.util.Objects;
import java.util.Scanner;

public class TicTacToe {
    private static final int ROW = 3;
    private static final int COL = 3;
    private static String board [][] = new String[ROW][COL];

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        boolean Continue = true;
        int rowMove;
        int colMove;
        String turn = " ";
        String Player1 = "X";
        String Player2 = "O";
        do {
            clearBoard();
            for (int m = 1; m <= 9; ++m) {
                display();
                if (m % 2 == 0) {
                    turn = Player2;
                } else {
                    turn = Player1;
                }
                do {
                    rowMove = SafeInputs.getRangedInt(in, turn + "'s move. Enter Row: ", 1, 3);
                    rowMove = rowMove -1;
                    colMove = SafeInputs.getRangedInt(in, turn + "'s move. Enter Column: ", 1, 3);
                    colMove = colMove - 1;
                    isValidMove(rowMove, colMove);
                } while (!isValidMove(rowMove, colMove));
                if (turn.equals(Player1)) {
                    board[rowMove][colMove] = " X ";
                } else {
                    board[rowMove][colMove] = " O ";
                }
                isWin(turn);
                if(isWin(turn)){
                    display();
                    System.out.print(turn + " Won!");
                    break;
                }

                if(m >= 8){
                    if(isTie()){
                        display();
                        System.out.print("Tie!");
                        break;
                    }
                }
            }
            Continue = SafeInputs.getYNConfirm(in, "Play Again? [Y/N]");
            System.out.println();
            if(Continue){
                System.out.print("X will now use O and O will now use X");
                System.out.println();
            }
        }while (Continue);

    }

    private static void clearBoard() {
        for (int i = 0; i <= (ROW-1); ++i) {
            for (int k = 0; k <= (COL-1); ++k) {
                board[i][k] = " - ";
            }
        }
    }
    private static void display() {
        for (int i = 0; i <= (ROW-1); ++i) {
            for (int k = 0; k <= (COL-1); ++k) {
                System.out.print(board[i][k]);
            }
            System.out.println();
        }
    }
    private static boolean isValidMove(int row, int col) {
        boolean valmove = false;
        if (board[row][col].equals(" - ")) {
            valmove = true;
        } else{
            System.out.print("Illegal move. Cannot take already taken spot ");
        }
        return valmove;
    }
    private static boolean isWin(String player){
        boolean winColwin = isColumnWin(player);
        boolean winRowwin = isRowWin(player);
        boolean winDiagwin = isDiagonalWin(player);
        boolean win = false;
        if(winColwin){
            win = true;
        } else if (winRowwin) {
            win= true;
        } else if (winDiagwin) {
            win= true;
        }
        return win;
    }
    private static boolean isTie(){
        boolean tie = false;
        int fill= 0;

        for (int i = 0; i <= (ROW-1); ++i) {
            for (int k = 0; k <= (COL-1); ++k) {
                if(!board[i][k].equals(" - ")){
                    fill = fill + 1;
                }
            }
        }
        if(fill == 9){
            tie = true;
        }
        return tie;
    }
    private static boolean isColumnWin(String player1){
        boolean win= false;
        if(board[0][1].equals(" X ")){
            if(board[1][1].equals(" X ")){
                if(board[2][1].equals(" X ")){
                    win = true;
                }
            }
        }else if(board[0][0].equals(" X ")){
            if(board[1][0].equals(" X ")){
                if(board[2][0].equals(" X ")){
                    win = true;
                }
            }
        }else if(board[0][2].equals(" X ")) {
            if (board[1][2].equals(" X ")) {
                if (board[2][2].equals(" X ")) {
                    win = true;
                }
            }
        }else if(board[0][1].equals(" O ")){
            if(board[1][1].equals(" O ")){
                if(board[2][1].equals(" O ")){
                    win = true;
                }
            }
        }else if(board[0][0].equals(" O ")){
            if(board[1][0].equals(" O ")){
                if(board[2][0].equals(" O ")){
                    win = true;
                }
            }
        }else if(board[0][2].equals(" O ")) {
            if (board[1][2].equals(" O ")) {
                if (board[2][2].equals(" O ")) {
                    win = true;
                }
            }
        }
        return win;
    }
    private static boolean isRowWin(String player){
        boolean win= false;
        if(board[0][0].equals(" X ")){
            if(board[0][1].equals(" X ")){
                if(board[0][2].equals(" X ")){
                    win = true;
                }
            }
        }else if(board[1][0].equals(" X ")){
            if(board[1][1].equals(" X ")){
                if(board[1][2].equals(" X ")){
                    win = true;
                }
            }
        }else if(board[2][0].equals(" X ")) {
            if (board[2][1].equals(" X ")) {
                if (board[2][2].equals(" X ")) {
                    win = true;
                }
            }
        }else if(board[0][0].equals(" O ")){
            if(board[0][1].equals(" O ")){
                if(board[0][2].equals(" O ")){
                    win = true;
                }
            }
        }else if(board[1][0].equals(" O ")){
            if(board[1][1].equals(" O ")){
                if(board[1][2].equals(" O ")){
                    win = true;
                }
            }
        }else if(board[2][0].equals(" O ")) {
            if (board[2][1].equals(" O ")) {
                if (board[2][2].equals(" O ")) {
                    win = true;
                }
            }
        }
        return win;
    }
    private static boolean isDiagonalWin(String player){
        boolean diagWin = false;
        if(Objects.equals(board[0][0], board[1][1]) && Objects.equals(board[0][0], board[2][2])){
            if(board[0][0].equals(" - ")){
                diagWin = false;
            }else{
                diagWin = true;
            }
        }else if(Objects.equals(board[0][2], board[1][1]) && Objects.equals(board[0][2], board[2][0])){
            if(board[2][0].equals(" - ")){
                diagWin = false;
            }else{
                diagWin = true;
            }
        }else{
            diagWin = false;
        }
        return diagWin;
    }


}

    //https://bit.ly/SAFEINPUT
    //getRangedInt will be used
    //getYN will be used

