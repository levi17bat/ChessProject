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
public abstract class Piece {

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
    public abstract boolean[][] possibleMovies();

    public boolean possibleMovia(Position position) {
        return possibleMovies()[position.getRow()][position.getColumn()];
        //ele vai retornar uma matriz, e ele já coloca do lado qual a posição ele quer comparar. Se for possível retornar, ele retorna true, se não, retorna false
        //mas ele vai retornar um abstract?? sim. o cara que chamar isso terá que ser
        //um cara que extends a classe e por isso, vai ter que implementar a classe possible
        //movies concetramente. prevendo isso, ele pode lidar com um método abstract, mas em
        //que ficar espertão pq isso aí pode dar ruim pra garaio 
    }

    public boolean isThereAnyPossibleMovie() {
        boolean[][] mat = possibleMovies();
        for (int a = 0; a < mat.length; a++) {
            for (int b = 0; b < mat[a].length; b++) {
                if (mat[a][b]) {
                    return true;
                }
            }
        }
        return false;
    }

}
