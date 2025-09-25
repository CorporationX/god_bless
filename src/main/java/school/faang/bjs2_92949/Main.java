package school.faang.bjs2_92949;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TwitterAccount accountOne = new TwitterAccount("One", new AtomicInteger(0));
        TwitterAccount accountTwo = new TwitterAccount("Two", new AtomicInteger(1));
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        CompletableFuture future1 = twitterSubscriptionSystem.followAccount(accountOne);
        CompletableFuture future2 = twitterSubscriptionSystem.followAccount(accountTwo);

        CompletableFuture.allOf(future1, future2).thenRun(() -> {
                    System.out.printf("Account: %s, Followers: %s%n",
                            accountOne.getUsername(),
                            accountOne.getFollowersCount());
                    System.out.printf("Account: %s, Followers: %s%n",
                            accountTwo.getUsername(),
                            accountTwo.getFollowersCount());
                })
                .join();
    }
}
