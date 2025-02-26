package asyncfactorial;

public class FactorialComputationException extends RuntimeException {
    public FactorialComputationException(String message, Throwable cause) {
        super(message, cause);
    }

    public FactorialComputationException(String message) {
        super(message);
    }
}
