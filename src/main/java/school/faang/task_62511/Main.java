package school.faang.task_62511;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final String TOTAL_FOLLOWERS_MESSAGE = "Общее количество подписчиков на аккаунт \"{}\": {}";

    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Graccio");

        CompletableFuture<Void> firstFollower = system.followAccount(account);
        CompletableFuture<Void> secondFollower = system.followAccount(account);
        CompletableFuture<Void> thirdFollower = system.followAccount(account);

        CompletableFuture.allOf(firstFollower, secondFollower, thirdFollower)
                .thenAccept(
                        future -> log.info(TOTAL_FOLLOWERS_MESSAGE, account.getUsername(), account.getFollowers())
                )
                .join();

        system.shutdownExecutor();
    }
}
