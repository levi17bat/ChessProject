
package Chess;

import boardGame.Board;
import boardGame.Piece;



public class ChessPiece extends Piece{
    private COLOR color;


    public ChessPiece(COLOR color, Board board) {
        super(board);
        this.color = color;
    }

    public COLOR getColor() {
        return color;
    }
    
    
    
}
