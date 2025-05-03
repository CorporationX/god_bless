package school.faang.bjs2_75806;

public class ThreadStoppedException extends RuntimeException {
    public ThreadStoppedException(Throwable ex) {
        super("Thread stopped exception", ex);
    }
}
