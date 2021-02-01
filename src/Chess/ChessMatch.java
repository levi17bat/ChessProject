package Chess;

import boardGame.Board;

public class ChessMatch {//o coração do nosso jogo de xadrez

    private Board board;

    //constructor
    public ChessMatch() {//assim que o objeto é criado, já fala o tamanho do tabuleiro
        this.board = new Board(8, 8);
    }

    //end constructor
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
