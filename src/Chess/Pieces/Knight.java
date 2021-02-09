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

public class Knight extends ChessPiece {//aoooba cavalo
    


    public Knight(Board board, COLOR color) {
        super(board, color);

    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) this.getBoard().piece(position);
        return p == null || p.getColor() != this.getColor();
    }

    @Override
    public String toString() {
        return "N";
    }

    @Override
    public boolean[][] possibleMovies() {
        
        
        
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);

        p.setValues(this.position.getRow() - 1, this.position.getColumn()-2);
        if (getBoard().positionsExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(this.position.getRow() - 1, this.position.getColumn()+2);
        if (getBoard().positionsExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(this.position.getRow()-2, this.position.getColumn() - 1);
        if (getBoard().positionsExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(this.position.getRow()-2, this.position.getColumn() + 1);
        if (getBoard().positionsExists(p) && canMove(p)) {  
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(this.position.getRow() + 1, this.position.getColumn() + 2);
        if (getBoard().positionsExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        p.setValues(this.position.getRow() + 1, this.position.getColumn() -2);
        if (getBoard().positionsExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
      
        p.setValues(this.position.getRow() +2, this.position.getColumn() - 1);
        if (getBoard().positionsExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
    
        p.setValues(this.position.getRow() + 2, this.position.getColumn() + 1);
        if (getBoard().positionsExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        return mat;
    }
}
    

