package faang.school.godbless.loadExceptions;

public class ExcessLoadException extends Exception {
    public ExcessLoadException(String message){
        super("Cannot allocate load: exceeds max load.\n" + message);
    }
}
