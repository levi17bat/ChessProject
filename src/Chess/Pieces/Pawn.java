/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chess.Pieces;

import Chess.COLOR;
import Chess.ChessPiece;
import boardGame.Board;
import boardGame.Position;

/**
 *
 * @author Levi
 */
public class Pawn extends ChessPiece {

    public Pawn(Board board, COLOR color) {
        super(board, color);
    }

    @Override
    public boolean[][] possibleMovies() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);
        if (getColor() == COLOR.WHITE) {
            p.setValues(position.getRow() - 1, position.getColumn());
            if (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;

            }

            p.setValues(position.getRow() - 2, position.getColumn());
            Position p2 = new Position(position.getRow() - 1, position.getColumn());
            if (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p) && this.getMoveCount() == 0 && getBoard().positionsExists(p2) && !getBoard().thereIsAPiece(p2)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColumn() - 1);
            if (getBoard().positionsExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() - 1, position.getColumn() + 1);
            if (getBoard().positionsExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }
        } else {

            p.setValues(position.getRow() + 1, position.getColumn());
            if (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;

            }

            p.setValues(position.getRow() + 2, position.getColumn());
            Position p2 = new Position(position.getRow() + 1, position.getColumn());
            if (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p) && this.getMoveCount() == 0 && getBoard().positionsExists(p2) && !getBoard().thereIsAPiece(p2)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColumn() - 1);
            if (getBoard().positionsExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

            p.setValues(position.getRow() + 1, position.getColumn() + 1);
            if (getBoard().positionsExists(p) && isThereOpponentPiece(p)) {
                mat[p.getRow()][p.getColumn()] = true;
            }

        }
        return mat;
    }
    
    //others
    @Override
    public String toString(){
    return"P";
    }

}
