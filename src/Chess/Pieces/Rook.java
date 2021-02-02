/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chess.Pieces;

import Chess.COLOR;
import Chess.ChessPiece;
import boardGame.Board;

/**
 *
 * @author Levi
 */
public class Rook extends ChessPiece {

    public Rook(COLOR color, Board board) {
        super(color, board);
    }

    @Override
    public String toString() {
        return "R";
    }

}
