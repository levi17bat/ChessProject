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

public class King extends ChessPiece {

    public King(Board board, COLOR color) {
        super(board, color);

    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) this.getBoard().piece(position);
        return p == null || p.getColor() != this.getColor();
    }

    @Override
    public String toString() {
        return "K";
    }

    @Override
    public boolean[][] possibleMovies() {
        boolean[][] mat = new boolean[getBoard().getRows()][getBoard().getColumns()];
        Position p = new Position(0, 0);
        //above
        p.setValues(this.position.getRow() - 1, this.position.getColumn());
        if (getBoard().positionsExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //below 
        p.setValues(this.position.getRow() + 1, this.position.getColumn());
        if (getBoard().positionsExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //right
        p.setValues(this.position.getRow(), this.position.getColumn() + 1);
        if (getBoard().positionsExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //left
        //right
        p.setValues(this.position.getRow(), this.position.getColumn() - 1);
        if (getBoard().positionsExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //top right diagonal
        p.setValues(this.position.getRow() - 1, this.position.getColumn() + 1);
        if (getBoard().positionsExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }

        //below right diagonal
        p.setValues(this.position.getRow() + 1, this.position.getColumn() + 1);
        if (getBoard().positionsExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //top left diagonal
        p.setValues(this.position.getRow() - 1, this.position.getColumn() - 1);
        if (getBoard().positionsExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        //below left diagonal
        p.setValues(this.position.getRow() + 1, this.position.getColumn() - 1);
        if (getBoard().positionsExists(p) && canMove(p)) {
            mat[p.getRow()][p.getColumn()] = true;
        }
        return mat;
    }
}
