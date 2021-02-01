
package boardGame;


public class Board {
    private int rows;
    private int columns;
    private Piece[][]pieces;
    
    
    //constructors
    public Board(int rows,int columns){
    this.rows =rows;
    this.columns = columns;
    pieces = new Piece[rows][columns];
    }
    //end constructors
    //get and set
    
    
    
    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }
    
    //end get and set
//others
    public Piece piece(int row, int column){
    return this.pieces[row][column];
    }
    
    public Piece piece(Position position){
    return this.pieces[position.getRow()][position.getColumn()];
    }
    
    //end others 
    
}
