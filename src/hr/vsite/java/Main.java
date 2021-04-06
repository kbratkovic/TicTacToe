package hr.vsite.java;

import java.util.Scanner;

public class Main {

    public static String player1, player2;

    public static void main(String[] args) {

        char[][] board = {{' ', '|', ' ', '|', ' ' },
                {'-', '+', '-', '+', '-' },
                {' ', '|', ' ', '|', ' ' },
                {'-', '+', '-', '+', '-' },
                {' ', '|', ' ', '|', ' ' }};

        Scanner scanPlayer = new Scanner(System.in);
        System.out.print("Player ONE enter your name: ");
        player1 = scanPlayer.nextLine();
        System.out.print("Player TWO enter your name: ");
        player2 = scanPlayer.nextLine();

        System.out.println();

        int counter = 0;
        int position;
        boolean validPosition;
        boolean positionFree;
        int player1Score = 0;
        int player2Score = 0;

        Scanner scanner = new Scanner(System.in);

        printBoard(board);

        do {
            do {
                //Player1
                System.out.println(player1 + " (X)" + " - select your position (1-9)");
                while (!scanner.hasNextInt())
                    scanner.next();
                position = scanner.nextInt();


                validPosition = validPosition(position);
                positionFree = checkIfPositionIsFree(board, position);

                if (validPosition && positionFree) {
                    placeSymbol(board, position, player1);
                    printBoard(board);

                    ++counter;
                    System.out.println();
                }

                if (checkWinner(board,'X')) {
                    System.out.println("!!!!!!! " + player1 + " (X) IS THE WINNER !!!!!!!");
                    ++player1Score;
                    result(player1, player1Score, player2, player2Score);

                    newGame(board);
                    printBoard(board);
                    counter = 0;
                } else if (counter == 9){
                    System.out.println("!!!!!!! IT'S A TIE !!!!!!!");
                    result(player1, player1Score, player2, player2Score);
                    newGame(board);
                    printBoard(board);
                    counter = 0;
                }
            }
            while (!(validPosition && positionFree));

            if (counter == 9)
                break;

            do {
                //Player2
                System.out.println(player2 + " (O)" + " - select your position (1-9)");
                while (!scanner.hasNextInt())
                    scanner.next();
                position = scanner.nextInt();

                validPosition = validPosition(position);
                positionFree = checkIfPositionIsFree(board, position);

                if (validPosition && positionFree) {
                    placeSymbol(board, position, player2);
                    printBoard(board);

                    ++counter;
                    System.out.println();
                }

                if (checkWinner(board,'O')) {
                    System.out.println("!!!!!!! " + player2 + " (O) IS THE WINNER !!!!!!!");
                    ++player2Score;
                    result(player1, player1Score, player2, player2Score);

                    newGame(board);
                    printBoard(board);
                    counter = 0;
                } else if (counter == 9){
                    System.out.println("!!!!!!! IT'S A TIE !!!!!!!");
                    result(player1, player1Score, player2, player2Score);
                    newGame(board);
                    printBoard(board);
                    counter = 0;
                }

            }
            while (!(validPosition && positionFree));

        } while (true);

    }

    public static boolean validPosition(int position){
        return position >= 1 && position <= 9;
    }

    public static boolean checkIfPositionIsFree(char [] [] board, int position){
        switch (position){
            case 1:
                if (board [0] [0] == ' ')
                    return true;
                break;
            case 2:
                if (board [0] [2] == ' ')
                    return true;
                break;
            case 3:
                if (board [0] [4] == ' ')
                    return true;
                break;
            case 4:
                if (board [2] [0] == ' ')
                    return true;
                break;
            case 5:
                if (board [2] [2] == ' ')
                    return true;
                break;
            case 6:
                if (board [2] [4] == ' ')
                    return true;
                break;
            case 7:
                if (board [4] [0] == ' ')
                    return true;
                break;
            case 8:
                if (board [4] [2] == ' ')
                    return true;
                break;
            case 9:
                if (board [4] [4] == ' ')
                    return true;
                break;
            default:
                break;
        }
        return false;
    }
    
    public static void placeSymbol(char [] [] board, int position, String player) {
        char symbol = ' ';

        if (player.equals(player1))
            symbol = 'X';
        else if (player.equals(player2))
            symbol = 'O';

            switch (position){
                case 1:
                    board [0] [0] = symbol;
                    break;
                case 2:
                    board [0] [2] = symbol;
                    break;
                case 3:
                    board [0] [4] = symbol;
                    break;
                case 4:
                    board [2] [0] = symbol;
                    break;
                case 5:
                    board [2] [2] = symbol;
                    break;
                case 6:
                    board [2] [4] = symbol;
                    break;
                case 7:
                    board [4] [0] = symbol;
                    break;
                case 8:
                    board [4] [2] = symbol;
                    break;
                case 9:
                    board [4] [4] = symbol;
                    break;
                default:
                    break;
            }
    }

    public static void printBoard ( char[][] board){
        for (char[] row : board) {
            for (char c : row) {
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public static boolean checkWinner(char [] [] board, char symbol) {
        if (board [0] [0] == symbol && board [0] [2] == symbol && board [0] [4] == symbol)
            return true;
        if (board [2] [0] == symbol && board [2] [2] == symbol && board [2] [4] == symbol)
            return true;
        if (board [4] [0] == symbol && board [4] [2] == symbol && board [4] [4] == symbol)
            return true;
        if (board [0] [0] == symbol && board [2] [0] == symbol && board [4] [0] == symbol)
            return true;
        if (board [0] [2] == symbol && board [2] [2] == symbol && board [4] [2] == symbol)
            return true;
        if (board [0] [4] == symbol && board [2] [4] == symbol && board [4] [4] == symbol)
            return true;
        if (board [0] [0] == symbol && board [2] [2] == symbol && board [4] [4] == symbol)
            return true;
        if (board [0] [4] == symbol && board [2] [2] == symbol && board [4] [0] == symbol)
            return true;
        return false;
    }

    public static void result(String player1, int player1Score, String player2, int player2Score){
        System.out.println(">>>>> SCORE <<<<<");
        System.out.println(player1 + " " + player1Score + " : " + player2Score + " " + player2);
        System.out.println();
    }

    public static void newGame(char [] [] board){
        for (int row = 0; row < board.length; row += 2) {
            for (int col = 0; col < board[row].length; col += 2) {
                board[row][col] = ' ';
            }
        }
    }

}

