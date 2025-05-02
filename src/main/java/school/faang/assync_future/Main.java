package school.faang.assync_future;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    public static void main(String[] args) {
        try {
            MasterCardService.doAll();
        } catch (ExecutionException e) {
            log.error("Action is interrupted.");
        } catch (InterruptedException e) {
            log.error("Error {}", String.valueOf(e.getCause()));
            Thread.currentThread().interrupt();
        }
    }
}
