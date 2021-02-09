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

public class Bishop extends ChessPiece{


    public Bishop(Board board, COLOR color) {
        super(board, color);
    }

    @Override
    public String toString() {
        return "B";
    }

    @Override
    public boolean[][] possibleMovies() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);
        
        
        //NW
        p.setValues(this.position.getRow() - 1, this.position.getColumn()-1);
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()-1,p.getColumn()-1);
        }
        if(getBoard().positionsExists(p)&&(this.isThereOpponentPiece(p))){
        mat[p.getRow()-1][p.getColumn()-1] = true;
        }
        
        
        
        
        //ne
         p.setValues(this.position.getRow()-1, this.position.getColumn()+1);
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()-1,p.getColumn()+1);
        }
        if(getBoard().positionsExists(p)&&(this.isThereOpponentPiece(p))){
        mat[p.getRow()][p.getColumn()] = true;
        }
        
        
        
        
        
        
        //se - sudeste
          p.setValues(this.position.getRow()+1, this.position.getColumn()+1);
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()+1,p.getColumn()+1);
        }
        if(getBoard().positionsExists(p)&&(this.isThereOpponentPiece(p))){
        mat[p.getRow()][p.getColumn()] = true;
        }
        
        
        
        //sw
         p.setValues(this.position.getRow() + 1, this.position.getColumn()-1);
        while (getBoard().positionsExists(p) && !getBoard().thereIsAPiece(p)) {
            mat[p.getRow()][p.getColumn()] = true;
            p.setValues(p.getRow()+1,p.getColumn()-1);
        }
        if(getBoard().positionsExists(p)&&(this.isThereOpponentPiece(p))){
        mat[p.getRow()][p.getColumn()] = true;
        }
        
        
        
        
        return mat;
    }

}
