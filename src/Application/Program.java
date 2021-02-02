
package Application;

import Chess.ChessMatch;


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
