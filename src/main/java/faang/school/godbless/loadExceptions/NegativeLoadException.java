package faang.school.godbless.loadExceptions;

public class NegativeLoadException extends Exception {
    public NegativeLoadException(String message) {
        super("Load cannot be negative.\n" + message);
    }
}
