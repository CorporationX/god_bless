package school.faang.task_50669;

import school.faang.exception.CheckException;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.stream.IntStream;

public class TwitterSubscriptionSystem {
    private static final int FOLLOWERS_COUNT = 10000;

    public void addFollowers(TwitterAccount account, ExecutorService executor) {
        if (account == null) {
            throw new CheckException("account");
        }

        CompletableFuture<?>[] futuresArray = IntStream.range(0, FOLLOWERS_COUNT)
                .mapToObj(i -> followAccount(account, executor))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futuresArray)
                .thenRun(() -> System.out.printf("У аккаунта: %s - %s подписчиков!%n",
                        account.getUsername(),
                        account.getFollowers().get()));
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account, ExecutorService executor) {
        return CompletableFuture.runAsync(account::addFollower, executor);
    }
}
