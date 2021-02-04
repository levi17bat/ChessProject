package Chess;

import static Chess.COLOR.WHITE;
import Chess.Exceptions.ChessException;
import Chess.Pieces.Rook;
import Chess.Pieces.King;
import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;

public class ChessMatch {//o coração do nosso jogo de xadrez

    private Board board;

    //constructor
    public ChessMatch() {//assim que o objeto é criado, já fala o tamanho do tabuleiro
        this.board = new Board(8, 8);
        initialSetup();
    }

    //end constructor
    public ChessPiece performChessMove(ChessPosition sourcePosition, ChessPosition targetPosition) {
        Position source = sourcePosition.toPosition();
        Position target = targetPosition.toPosition();
        validateSourcePosition(source);
        Piece capturedPiece = makeMove(source, target);
        return (ChessPiece) capturedPiece;

    }

    private Piece makeMove(Position origin, Position target){
    Piece p = board.removePiece(origin);
    Piece capturedPiece = board.removePiece(target);
    board.placePiece(p, target);
    return capturedPiece;
    }
   
    
    public void validateSourcePosition(Position position) {
        if (!board.thereIsAPiece(position)) {
          throw new ChessException("There's no piece in the positon");
        }
        if(!board.piece(position).isThereAnyPossibleMovie()){
        throw new ChessException("There is no possible moves for the chosen piece");
        }
        
        
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
