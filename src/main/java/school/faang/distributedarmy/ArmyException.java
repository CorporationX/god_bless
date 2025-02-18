package school.faang.distributedarmy;

public class ArmyException extends Exception {
    public ArmyException(String message) {
        super(message);
    }

    public ArmyException(String message, Throwable cause) {
        super(message, cause);
    }
}
