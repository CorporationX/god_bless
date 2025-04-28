package school.faang.bjs2_74874;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadStoppedException extends RuntimeException {
    public ThreadStoppedException(Throwable ex) {
        super("Thread stopped exception", ex);
        log.error("Thread stopped exception");
    }
}
