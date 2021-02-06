package Chess;

import static Chess.COLOR.WHITE;
import Chess.Exceptions.ChessException;
import Chess.Pieces.Rook;
import Chess.Pieces.King;
import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ChessMatch {//o coração do nosso jogo de xadrez

    private List<Piece> piecesOnTheBoard = new ArrayList<>();
    private List<Piece> capturedPieces = new ArrayList<>();

    private int turn;
    private Board board;
    private COLOR currentPlayer;
    private boolean check;//por padrão começa com falso

    //constructor
    public ChessMatch() {//assim que o objeto é criado, já fala o tamanho do tabuleiro
        this.board = new Board(8, 8);
        this.turn = 1;
        this.currentPlayer = COLOR.WHITE;
        initialSetup();

    }

    //end constructor
    
    public boolean getCheck(){
    return this.check;
    }
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

        if (testCheck(this.currentPlayer)) {
            undoMove(source, target, capturedPiece);
            throw new ChessException("You can't put yourself in check");
        }
        this.check = (testCheck(opponent(currentPlayer))) ? true : false;

        nextTurn();
        return (ChessPiece) capturedPiece;

    }

    private Piece makeMove(Position origin, Position target) {
        Piece p = board.removePiece(origin);
        Piece capturedPiece = board.removePiece(target);
        if (capturedPiece != null) {
            this.piecesOnTheBoard.remove(capturedPiece);
            this.capturedPieces.add(capturedPiece);
        }
        board.placePiece(p, target);
        return capturedPiece;
    }

    private void undoMove(Position origin, Position target, Piece capturedPiece) {
        Piece p = board.removePiece(target);
        board.placePiece(p, origin);

        if (capturedPiece != null) {
            board.placePiece(capturedPiece, target);
            capturedPieces.remove(capturedPiece);
            this.piecesOnTheBoard.add(capturedPiece);
        }

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
        this.piecesOnTheBoard.add(piece);
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

    private COLOR opponent(COLOR color) {
        return (color.equals(COLOR.WHITE)) ? COLOR.BLACK : COLOR.WHITE;
    }

    private ChessPiece king(COLOR color) {
        List<Piece> list = this.piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor().equals(color)).collect(Collectors.toList());
        for (Piece p : list) {
            if (p instanceof King) {
                return (ChessPiece) p;
            }
        }
        throw new IllegalStateException("There's no " + color + " king on the board.");
    }

    private boolean testCheck(COLOR color) {
        Position kingPosition = king(color).getChessPosition().toPosition();
        List<Piece> opponentPieces = this.piecesOnTheBoard.stream().filter(x -> ((ChessPiece) x).getColor().equals(this.opponent(color))).collect(Collectors.toList());

        for (Piece p : opponentPieces) {
            boolean[][] mat = p.possibleMovies();
            if (mat[kingPosition.getRow()][kingPosition.getColumn()]) {
                return true;
            }
        }
        return false;
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
