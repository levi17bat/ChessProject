/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Chess.COLOR;
import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class UI {//user interface
// https://stackoverflow.com/questions/5762491/how-to-print-color-in-console-using-system-out-println
    //códigos especiais para usar cores no meu termi    

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";

    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";

    // https://stackoverflow.com/questions/2979383/java-clear-the-console 
    public static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();

    }

    public static ChessPosition readChessPosition(Scanner sc) {
        try {
            String s = sc.nextLine().toLowerCase();
            char col = s.charAt(0);
            int row = Integer.parseInt(s.substring(1, 2));
            return new ChessPosition(col, row);
        } catch (RuntimeException e) {
            throw new InputMismatchException("Error reading ChessPosition."
                    + " Valid values are from a1 to h8.");
        }
    }

    public static void printBoard(ChessPiece[][] pec) {
        int aux = 8;
        for (int l = 0; l < pec.length; l++) {
            System.out.print(aux - l + " ");
            for (int c = 0; c < pec[l].length; c++) {
                showPiece(pec[l][c], false);
                System.out.print(" ");
            }
            System.out.println("\n");
        }
        System.out.println(" a  b  c  d  e  f  g  h");
    }

    public static void printMatch(ChessMatch chessMatch, List<ChessPiece> captured) {
        printBoard(chessMatch.getPieces());
        System.out.println("");
        printCapturedPieces(captured);
        System.out.println("\nTurn : " + chessMatch.getTurn());
        
        
        if(!chessMatch.getCheckMate()){
        if(chessMatch.getCheck()){
            System.out.println("CHECK!");
        }
        System.out.println("Waiting Player " + chessMatch.getCurrentPlayer());
        return;
      }else
            System.out.println("CHECKMATE!");
            System.out.println("Winner : "+chessMatch.getCurrentPlayer());
            
    }

    public static void printBoard(ChessPiece[][] pec, boolean[][] possibleMoves) {
        int aux = 8;
        for (int l = 0; l < pec.length; l++) {
            System.out.print(aux - l + " ");
            for (int c = 0; c < pec[l].length; c++) {
                showPiece(pec[l][c], possibleMoves[l][c]);
                System.out.print(" ");
            }
            System.out.println("\n");
        }
        System.out.println("  a  b  c  d  e  f  g  h");
    }

    public static void showPiece(ChessPiece piece, boolean background) {
        if (background) {
            System.out.print(ANSI_BLUE_BACKGROUND);
        }
        if (piece == null) {
            System.out.print("-" + ANSI_RESET);
        } else {
            if (piece.getColor() == COLOR.WHITE) {
                System.out.print(ANSI_WHITE + piece + ANSI_RESET);
            } else {
                System.out.print(ANSI_YELLOW + piece + ANSI_RESET);
            }
        }
        System.out.print(" ");
    }

    private static void printCapturedPieces(List<ChessPiece> captures) {
        List<ChessPiece> white = captures.stream().filter(x -> x.getColor() == COLOR.WHITE).collect(Collectors.toList());
        List<ChessPiece> black = captures.stream().filter(x -> x.getColor() == COLOR.BLACK).collect(Collectors.toList());

        //white
        System.out.print(ANSI_WHITE);
        System.out.print("White : ");
        for (int a = 0; a < white.size(); a++) {
            System.out.print(white.get(a)+" ");
        }
            System.out.println(ANSI_RESET);
        //black
        System.out.println(ANSI_YELLOW);
        System.out.print("Black : ");
        for (int a = 0; a < black.size(); a++) {
            System.out.print(black.get(a)+" ");
        }
        System.out.println(ANSI_RESET);

    }
}
