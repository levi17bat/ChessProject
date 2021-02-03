/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Chess;

import Chess.Exceptions.ChessException;
import boardGame.Position;

/**
 *
 * @author Levi
 */
public class ChessPosition {
    private char column;
    private int row;

    public ChessPosition(char column, int row) {
        if((column<'a') || (column>'h')|| (row<1) || (row>8)){
        throw new ChessException("Error : Model isn't compatible with the required. Valid "
                + "values are from a1 at h8");
        }
        this.column = column;
        this.row = row;
    }
    //get and set

    public char getColumn() {
        return column;
    }

  
    public int getRow() {
        return row;
    }

  
    
    //end get and set
    
    protected Position toPosition(){//converte a matriz normal[0][0] 
        //para a posição do tabuleiro do jogo
    
    return new Position(8-this.row,this.column-'a');
    }
    
    protected static ChessPosition fromPosition(Position position){
    return new ChessPosition((char)('a'-position.getColumn()),8-position.getRow());
    }
    
    @Override
    public String toString(){
    return""+this.column+this.row;
    
    }
    
}
