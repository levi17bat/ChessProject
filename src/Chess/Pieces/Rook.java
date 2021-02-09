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

public class Rook extends ChessPiece {

    public Rook(Board board, COLOR color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "R";
    }

    @Override
    public boolean[][] possibleMovies() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);
        //above
        p.setValues(this.position.getRow() - 1, this.position.getColumn());
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow()-1);
        }
        if(getBoard().positionsExists(p)&&(this.isThereOpponentPiece(p))){
        mat[p.getRow()][p.getColumn()] = true;
        }
        //left
         p.setValues(this.position.getRow(), this.position.getColumn()-1);
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn()-1);
        }
        if(getBoard().positionsExists(p)&&(this.isThereOpponentPiece(p))){
        mat[p.getRow()][p.getColumn()] = true;
        }
        //right
          p.setValues(this.position.getRow(), this.position.getColumn()+1);
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setColumn(p.getColumn()+1);
        }
        if(getBoard().positionsExists(p)&&(this.isThereOpponentPiece(p))){
        mat[p.getRow()][p.getColumn()] = true;
        }
        //below
         p.setValues(this.position.getRow() + 1, this.position.getColumn());
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setRow(p.getRow()+1);
        }
        if(getBoard().positionsExists(p)&&(this.isThereOpponentPiece(p))){
        mat[p.getRow()][p.getColumn()] = true;
        }
        
        
        
        
        return mat;
    }

}
