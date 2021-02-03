package Application;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;
import boardGame.Board;
import java.util.Scanner;

/**
 *
 * @author Levi
 */
public class Program {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        ChessMatch jogo = new ChessMatch();
        while (true) {
            UI.printBoard(jogo.getPieces());
            System.out.print("\nSource = ");
            ChessPosition source = UI.readChessPosition(ler);
            System.out.print("\nTarget = ");
            ChessPosition target = UI.readChessPosition(ler);
            ChessPiece capturedPiece = jogo.performChessMove(source,target);
            
        }

    }

}
