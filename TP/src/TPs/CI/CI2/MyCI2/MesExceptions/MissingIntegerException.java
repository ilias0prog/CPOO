package MyCI2.MesExceptions;


public class MissingIntegerException extends Exception {
    public MissingIntegerException() { 
        super(); 
    }
    public MissingIntegerException(String message) { 
        super(message); 
    }
}