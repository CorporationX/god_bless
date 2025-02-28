package school.faang.sprint4.task_62666;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class TwitterSubscriptionSystem {
    private static final int FOLLOWERS_COUNT = 10;
    private static final List<CompletableFuture<Void>> FUTURES = new ArrayList<>();

    public static void main(String[] args) {
        TwitterAccount root = new TwitterAccount("Vasya");
        log.debug("Create root account {}", root.getUserName());

        IntStream.range(0, FOLLOWERS_COUNT)
                .mapToObj(num -> new TwitterAccount("follower_" + num))
                .peek(follower -> log.debug("Create Follower {}", follower.getUserName()))
                .forEach(follower -> FUTURES.add(follower.followAccount(root)));

        CompletableFuture.allOf(FUTURES.toArray(CompletableFuture[]::new))
                .thenAccept(non -> {
                    root.closeExecutor();
                    FUTURES.clear();
                    log.info("Added all followers {}",
                            root.getFollowers() == FOLLOWERS_COUNT);
                }).join();
    }
}
