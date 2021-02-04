/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chess.Pieces;

import Chess.COLOR;
import Chess.ChessPiece;
import boardGame.Board;

public class King extends ChessPiece{
    
    public King(Board board, COLOR color) {
        super(board,color);
        
    }
    
    @Override
    public String toString(){
    return "K";
    }
}
