/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Chess.ChessPiece;

public class UI {//user interface

    public static void printBoard(ChessPiece[][] pec) {
        int aux = 8;
        for (int l = 0; l < pec.length; l++) {
            System.out.print(aux-l+"  ");
            for (int c = 0; c < pec[l].length; c++) {
                showPiece(pec[l][c]);
                System.out.print("  ");
            }
            System.out.println("\n");
            }
        System.out.println("   a  b  c  d  e  f  g  h");
        }
    

    public static void showPiece(ChessPiece piece){
        if(piece!=null){
            System.out.print(piece);
        }else
            System.out.print("-");
    }
}
