package school.faang.sprint_4.task_bjs250903;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final long EMULATE_WORK_MILLIS = 200;

    public CompletableFuture<Void> followAccount(TwitterAccount account, ExecutorService threadPool) {
        return CompletableFuture.runAsync(() -> {
            emulateWork();
            account.addFollower();
        }, threadPool);
    }

    private static void emulateWork() {
        try {
            Thread.sleep(EMULATE_WORK_MILLIS);
        } catch (InterruptedException e) {
            log.warn("Thread {} was interrupted", Thread.currentThread().getName());
            Thread.currentThread().interrupt();
        }
    }
}
