package Application;

import Chess.ChessMatch;
import Chess.ChessPiece;
import Chess.ChessPosition;
import Chess.Exceptions.ChessException;
import boardGame.Board;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Levi
 */
public class Program {

    public static void main(String[] args) {
        Scanner ler = new Scanner(System.in);
        List<ChessPiece> captured = new ArrayList<>();
        ChessMatch jogo = new ChessMatch();

        while (true) {
            try {
                UI.clearScreen();
                UI.printMatch(jogo, captured);
                System.out.print("\nSource = ");
                ChessPosition source = UI.readChessPosition(ler);
                boolean[][] possibleMoves = jogo.possibleMoves(source);
                UI.clearScreen();
                UI.printBoard(jogo.getPieces(), possibleMoves);

                System.out.print("\nTarget = ");
                ChessPosition target = UI.readChessPosition(ler);
                ChessPiece capturedPiece = jogo.performChessMove(source, target);
                if (capturedPiece != null) {
                    captured.add(capturedPiece);

                }

            } catch (ChessException e) {
                System.out.println(e.getMessage());
                ler.nextLine();
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
                ler.nextLine();
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
                ler.nextLine();
            }

        }

    }

}
