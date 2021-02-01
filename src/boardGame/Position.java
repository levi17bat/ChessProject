package boardGame;

public class Position {

    private int row;
    private int column;
//constructors

    public Position(int row, int column) {
        this.row = row;
        this.column = column;
    }
    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    //end constructor
    //get and set
    public void setColumn(int column) {    
        this.column = column;
    }

    //end get and set
    //others
    public void setValues(int row, int column) {
        this.row = row;
        this.column = column;
    }
    
    @Override
    public String toString(){
    return  "--Position--"+
            "\nRow    = "+this.row+
            "\nColumn = "+this.column;
    }
    
    //end others
}
