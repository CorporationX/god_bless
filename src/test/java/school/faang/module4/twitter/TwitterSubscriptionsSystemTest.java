package school.faang.module4.twitter;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TwitterSubscriptionsSystemTest {
    private static final int INITIAL_FOLLOWERS = 2;

    @Test
    public void testFollowAccount() {
        TwitterAccount harry = new TwitterAccount("Harry Potter", INITIAL_FOLLOWERS);
        TwitterSubscriptionsSystem system = new TwitterSubscriptionsSystem();
        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
        completableFutures.add(CompletableFuture.runAsync(() -> system.addFollower(harry)));
        completableFutures.add(CompletableFuture.runAsync(() -> system.addFollower(harry)));
        completableFutures.add(CompletableFuture.runAsync(() -> system.addFollower(harry)));
        completableFutures.add(CompletableFuture.runAsync(() -> system.addFollower(harry)));
        completableFutures.stream()
                .forEach(completableFuture -> completableFuture.join());
        int expected = INITIAL_FOLLOWERS + completableFutures.size();
        assertEquals(expected, harry.getFollowers());
    }
}
