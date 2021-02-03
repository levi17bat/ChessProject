package boardGame;

import boardGame.Exceptions.BoardException;

public class Board {

    private int rows;
    private int columns;
    private Piece[][] pieces;

    //constructors
    public Board(int rows, int columns) {
        if (rows < 1 || columns < 1) {
            throw new BoardException("Error creating board : There must be at least 1 row and columns");
        }

        this.rows = rows;
        this.columns = columns;
        pieces = new Piece[rows][columns];
    }
    //end constructors
    //get and set

    public int getRows() {
        return rows;
    }

    public int getColumns() {
        return columns;
    }

    //end get and set
//others
    public Piece piece(int row, int column) {
        if (!positionsExists(row, column)) {
            throw new BoardException("Position not on the board");
        }
        return this.pieces[row][column];
    }

    public Piece piece(Position position) { //retorna o que há na posição do tabuleiro
        if (!positionsExists(position)) {
            throw new BoardException("Position not on the board");
        }
        return this.pieces[position.getRow()][position.getColumn()];
    }

    public void placePiece(Piece piece, Position position){//esse método coloca a peça na posição do tabuleiro
        if (this.thereIsAPiece(position)) {
            throw new BoardException("There is already a piece on the position");//eu n falo que o método lança uma exceção pq ela é runtime
        }
        pieces[position.getRow()][position.getColumn()] = piece;
        piece.position = position;
    }

    public Piece removePiece(Position position){
    if(!positionsExists(position)){
    throw new BoardException("Position not on the board");
    }
    if(piece(position)==null){
        return null;
    }
    Piece aux = piece(position);
    aux.position = null;
    this.pieces[position.getRow()][position.getColumn()]=null;
    return aux;
    }
    
    public boolean positionsExists(Position pos) {//estou testando quando uma posição, numa
        //dada linha e coluna, existe? quando a posição está dentro do tabuleiro. 

        Boolean op = this.positionsExists(pos.getRow(), pos.getColumn());
        return op;
    }

    public boolean positionsExists(int row, int columns) {
        if (row >= 0 && row < this.rows && columns >= 0 && columns < this.columns) {
            return true;
        }
        return false;
    }

    public boolean thereIsAPiece(Position pos) {//vou ver se há alguma peça na posição
        if (positionsExists(pos)!=true) {
            throw new BoardException("Position not on the board");
        }else
        return (this.piece(pos)!=null);//dá pra retornar null ou true
        //sem fazer necessariamente um return boolean, 
        //só testando se uma condição é verdadeira
    }

    
    
    //end others 
}
