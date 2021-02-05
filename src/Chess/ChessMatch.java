package Chess;

import static Chess.COLOR.WHITE;
import Chess.Exceptions.ChessException;
import Chess.Pieces.Rook;
import Chess.Pieces.King;
import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;
import java.util.Scanner;

public class ChessMatch {//o coração do nosso jogo de xadrez

    private int turn;
    private Board board;
    private COLOR currentPlayer;

    //constructor
    public ChessMatch() {//assim que o objeto é criado, já fala o tamanho do tabuleiro
        this.board = new Board(8, 8);
        this.turn = 1;
        this.currentPlayer = COLOR.WHITE;
        initialSetup();
    }

    //end constructor
    public int getTurn() {
        return this.turn;
    }

    public COLOR getCurrentPlayer() {
        return this.currentPlayer;
    }

    public boolean[][] possibleMoves(ChessPosition sourcePosition) {
        Position position = sourcePosition.toPosition();
        this.validateSourcePosition(position);
        return board.piece(position).possibleMovies();
    }

    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);//validando posição de origem
        validateTargetPosition(source, target);//validando posição de destino
        Piece capturedPiece = makeMove(source, target);
        nextTurn();
        return (ChessPiece) capturedPiece;

    }

    private Piece makeMove(Position origin, Position target) {
        Piece p = board.removePiece(origin);
        Piece capturedPiece = board.removePiece(target);
        board.placePiece(p, target);
        return capturedPiece;
    }

    private void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
            throw new ChessException("There's no piece in the positon");
        }
        if (!board.piece(position).isThereAnyPossibleMovie()) {
            throw new ChessException("There is no possible moves for the chosen piece");
        }
        if (this.currentPlayer != ((ChessPiece) (board.piece(position))).getColor()) {
            throw new ChessException("The chosen piece isn't yours");
        }
    }

    private void validateTargetPosition(Position source, Position target) {
        Scanner ler = new Scanner(System.in);

        if (!board.piece(source).possibleMovia(target)) {
            throw new ChessException("The chosen piece can't be moved target positon");
        }

    }

    private void nextTurn() {
        this.turn++;
        this.currentPlayer = (this.currentPlayer == COLOR.WHITE) ? COLOR.BLACK : COLOR.WHITE;
    }

    private void placeNewPiece(char column, int row, ChessPiece piece) {
        board.placePiece(piece, new ChessPosition(column, row).toPosition());
    }

    public void initialSetup() {
        placeNewPiece('c', 1, new Rook(board, COLOR.WHITE));
        placeNewPiece('c', 2, new Rook(board, COLOR.WHITE));
        placeNewPiece('d', 2, new Rook(board, COLOR.WHITE));
        placeNewPiece('e', 2, new Rook(board, COLOR.WHITE));
        placeNewPiece('e', 1, new Rook(board, COLOR.WHITE));
        placeNewPiece('d', 1, new King(board, COLOR.WHITE));

        placeNewPiece('c', 7, new Rook(board, COLOR.BLACK));
        placeNewPiece('c', 8, new Rook(board, COLOR.BLACK));
        placeNewPiece('d', 7, new Rook(board, COLOR.BLACK));
        placeNewPiece('e', 7, new Rook(board, COLOR.BLACK));
        placeNewPiece('e', 8, new Rook(board, COLOR.BLACK));
        placeNewPiece('d', 8, new King(board, COLOR.BLACK));

    }

    public ChessPiece[][] getPieces() {//classe para retornar uma matriz que percorre o tabuleiro
        ChessPiece mat[][] = new ChessPiece[board.getRows()][board.getColumns()];
        for (int a = 0; a < board.getRows(); a++) {
            for (int b = 0; b < board.getColumns(); b++) {
                mat[a][b] = (ChessPiece) board.piece(a, b);
            }
        }
        return mat;
    }

}
