package Chess;

import static Chess.COLOR.WHITE;
import Chess.Pieces.Rook;
import Chess.Pieces.King;
import boardGame.Board;
import boardGame.Position;



public class ChessMatch {//o coração do nosso jogo de xadrez

    private Board board;

    //constructor
    public ChessMatch() {//assim que o objeto é criado, já fala o tamanho do tabuleiro
        this.board = new Board(8, 8);
        initialSetup();
    }

    //end constructor
    private void placeNewPiece(char column, int row, ChessPiece piece){
    board.placePiece(piece, new ChessPosition(column,row).toPosition());
    }
    
    
    
    public void initialSetup(){
    placeNewPiece('b',6,new Rook(WHITE,this.board));
    placeNewPiece('e',8,new King(COLOR.BLACK,this.board));
    placeNewPiece('e',1,new King(COLOR.WHITE,this.board));
    }
    
    public ChessPiece[][] getPieces() {//classe para retornar uma matriz que percorre o tabuleiro
        ChessPiece mat[][] = new ChessPiece[board.getRows()][board.getColumns()];
        for (int a = 0; a < board.getRows(); a++) {
            for (int b = 0; b < board.getColumns(); b++) {
                mat[a][b] = (ChessPiece)board.piece(a,b);
            }
        }
        return mat; 
    }

}
