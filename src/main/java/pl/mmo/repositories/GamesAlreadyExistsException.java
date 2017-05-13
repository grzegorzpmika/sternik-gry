package pl.mmo.repositories;

public class GamesAlreadyExistsException extends Exception {
    private static final long serialVersionUID = -4576295597218170159L;

    public GamesAlreadyExistsException() {
    }

    public GamesAlreadyExistsException(String message, Throwable cause, boolean enableSuppression,
                                       boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public GamesAlreadyExistsException(String message, Throwable cause) {
        super(message, cause);
    }

    public GamesAlreadyExistsException(String message) {
        super(message);
    }

    public GamesAlreadyExistsException(Throwable cause) {
        super(cause);
    }
    
}