package Chess;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;

public abstract class ChessPiece extends Piece {

    private COLOR color;

    public ChessPiece(Board board, COLOR color) {
        super(board);
        this.color = color;
    }

    public COLOR getColor() {
        return color;
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece aux = (ChessPiece) getBoard().piece(position);

        return aux != null && aux.getColor() != this.color;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }
}
