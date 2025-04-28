package school.faang.bjs2_73342;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ThreadStoppageException extends RuntimeException {
    public ThreadStoppageException(Throwable cause) {
        super("Thread stooped exception", cause);
        log.error("Thread stooped exception");
    }
}
