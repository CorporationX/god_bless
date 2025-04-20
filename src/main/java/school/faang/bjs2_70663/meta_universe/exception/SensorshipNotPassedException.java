package school.faang.bjs2_70663.meta_universe.exception;

public class SensorshipNotPassedException extends RuntimeException {
    public SensorshipNotPassedException(String message, Object... args) {
        super(ExceptionMessageFormatter.format(message, args));
    }
}
