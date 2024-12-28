package school.faang.bjs_50741;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

class TwitterSubscriptionSystemTest {

    @Test
    void followAccount() {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Twitter User");
        int followers = 10;

        List<CompletableFuture<TwitterAccount>> futureList = IntStream.range(0, followers)
                .boxed()
                .map(i -> system.followAccount(account))
                .toList();

        CompletableFuture.allOf(futureList.toArray(new CompletableFuture[0])).join();

        int actual = account.getFollowers();

        Assertions.assertEquals(followers, actual);
    }
}