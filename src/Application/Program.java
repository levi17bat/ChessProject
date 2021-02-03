
package Application;

import Chess.ChessMatch;
import boardGame.Board;


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
