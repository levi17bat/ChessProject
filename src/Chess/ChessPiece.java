package Chess;

import boardGame.Board;
import boardGame.Piece;
import boardGame.Position;

public abstract class ChessPiece extends Piece {

    private COLOR color;
    private int moveCout;

    public ChessPiece(Board board, COLOR color) {
        super(board);
        this.color = color;
    }

    public COLOR getColor() {
        return color;
    }

    public int getMoveCount(){
    return this.moveCout;
    }
    
    public void increaseMoveCount() {
        this.moveCout++;
    }

    public void decreaseMoveCount() {
        this.moveCout--;
    }

    protected boolean isThereOpponentPiece(Position position) {
        ChessPiece aux = (ChessPiece) getBoard().piece(position);

        return aux != null && aux.getColor() != this.color;
    }

    public ChessPosition getChessPosition() {
        return ChessPosition.fromPosition(position);
    }
}
