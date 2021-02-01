/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package boardGame;

/**
 *
 * @author Levi
 */
public class Piece {

    protected Position position;//posição da peça em matriz, não em relação ao jogo - vai ganhar ou vai perder, vai comer ou não, isso tudo é definido por outra classe/método/atributo
    private Board board;

    //constructors
    public Piece(Board board) {
        this.board = board;
        this.position = null;
    }

    //end constructors
    
    //get and set
    
    
    protected Board getBoard() {
        return board;
    }
    
    //end get and set

    
    
}
