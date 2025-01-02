package school.faang.task_50761;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount user = new TwitterAccount("Robot", 10);

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(
                system.followAccount(user),
                system.followAccount(user),
                system.followAccount(user),
                system.followAccount(user),
                system.followAccount(user));

        allFutures.get();
        allFutures.thenRun(() -> log.info("Count followers: {}", user.getFollowers()));
    }
}
