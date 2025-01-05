package school.faang.sprint_4.task_50867;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        TwitterAccount account = new TwitterAccount("user", 15);

        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        CompletableFuture<Void> future1 = CompletableFuture.runAsync(
                () -> system.followAccount(account)
        );
        CompletableFuture<Void> future2 = CompletableFuture.runAsync(
                () -> system.followAccount(account)
        );
        CompletableFuture<Void> future3 = CompletableFuture.runAsync(
                () -> system.followAccount(account)
        );

        CompletableFuture<Void> allFutures = CompletableFuture.allOf(future1, future2, future3);
        allFutures.get();

        System.out.println(account);
    }
}
