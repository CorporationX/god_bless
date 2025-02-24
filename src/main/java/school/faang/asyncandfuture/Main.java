package school.faang.asyncandfuture;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    private static final MasterCardService CARD_SERVICE = new MasterCardService();

    public static void main(String[] args) {
        try {
            CARD_SERVICE.doAll();
        } catch (InterruptedException interruptedException) {
            log.error("Thread has been interrupted");
            handlingException(interruptedException);
        } catch (ExecutionException executionException) {
            log.error("Execution tasks is failed");
            handlingException(executionException);
        }
    }

    private static void handlingException(Exception exception) {
        log.error("Thread name: {}\nException: {}\nStack trace: {}",
                Thread.currentThread().getName(), exception, exception.getStackTrace());
        Thread.currentThread().interrupt();
    }
}
