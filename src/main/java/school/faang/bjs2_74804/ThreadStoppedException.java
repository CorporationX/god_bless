package school.faang.bjs2_74804;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadStoppedException extends RuntimeException {
    public ThreadStoppedException(Throwable cause) {
        super("Thread stopped exception", cause);
        log.error("Thread stopped exception");
    }
}
