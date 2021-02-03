package Chess.Exceptions;

import boardGame.Exceptions.BoardException;

public class ChessException extends BoardException {

    public ChessException() {
    }

    public ChessException(String msg) {
        super(msg);
    }
}
