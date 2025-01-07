package school.faang.task_51666;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int threadsNumber = 10;

    public static void main(String... args) throws ExecutionException, InterruptedException {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        TwitterAccount account = new TwitterAccount("@Celebrity");

        CompletableFuture.allOf(
                IntStream.range(0, threadsNumber)
                        .mapToObj(i -> system.followAccount(account))
                        .toArray(CompletableFuture[]::new)
        )
                .thenRun(() -> log.info(
                        "All followers are added. Total number of followers: {}",
                        account.getFollowers()
                        )
                )
                .get();
    }
}
