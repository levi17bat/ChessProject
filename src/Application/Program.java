/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import Chess.ChessMatch;
import Chess.UI;


/**
 *
 * @author Levi
 */
public class Program {
    public static void main(String[] args) {
      ChessMatch jogo = new ChessMatch();
      UI.printBoard(jogo.getPieces());
        
        
    }
    
    
}
