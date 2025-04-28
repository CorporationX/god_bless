package school.faang.bjs2_74880;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadStoppedException extends RuntimeException {
    public ThreadStoppedException(Throwable ex) {
        super("Thread stopped error", ex);
        log.error("Thread stopped error");
    }
}
