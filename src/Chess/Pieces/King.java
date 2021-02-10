/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chess.Pieces;

import Chess.COLOR;
import Chess.ChessMatch;
import Chess.ChessPiece;
import boardGame.Board;
import boardGame.Position;

public class King extends ChessPiece {

    private ChessMatch chessmatch;

    public King(Board board, COLOR color, ChessMatch chessmatch) {
        super(board, color);
        this.chessmatch = chessmatch;
    }

    private boolean canMove(Position position) {
        ChessPiece p = (ChessPiece) this.getBoard().piece(position);
        return p == null || p.getColor() != this.getColor();
    }

    private boolean testRookCastling(Position position) {
        ChessPiece p = ((ChessPiece) getBoard().piece(position));

        return p != null && p instanceof Rook && p.getColor() == this.getColor() && p.getMoveCount() == 0;
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

        //#specialMoveCastling
        if (this.getMoveCount() == 0 && !this.chessmatch.getCheck()) {
            //kingsideRook
            Position posT1 = new Position(this.position.getRow(), this.position.getColumn() + 3);
            if (this.testRookCastling(posT1)) {
                Position p1 = new Position(this.position.getRow(), this.position.getColumn() + 1);
                Position p2 = new Position(this.position.getRow(), this.position.getColumn() + 2);
                if (this.getBoard().piece(p1) == null && this.getBoard().piece(p2) == null) {
                    mat[this.position.getRow()][this.position.getColumn() + 2] = true;

                }

            }
            //queenSideRook
            Position posT2 = new Position(this.position.getRow(), this.position.getColumn() - 4);
            if (this.testRookCastling(posT1)) {
                Position p1 = new Position(this.position.getRow(), this.position.getColumn() - 1);
                Position p2 = new Position(this.position.getRow(), this.position.getColumn() - 2);
                Position p3 = new Position(this.position.getRow(), this.position.getColumn() - 3);
                if (this.getBoard().piece(p1) == null && this.getBoard().piece(p2) == null && this.getBoard().piece(p3) == null) {
                    mat[this.position.getRow()][this.position.getColumn() - 2] = true;

                }

            }
        }

        return mat;
    }
}
