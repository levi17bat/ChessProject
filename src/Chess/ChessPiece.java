
package Chess;

import boardGame.Board;
import boardGame.Piece;



public class ChessPiece extends Piece{
    private COLOR color;


    public ChessPiece(Board board,COLOR color) {
        super(board);
        this.color = color;
    }

    public COLOR getColor() {
        return color;
    }
    
    
    
}
