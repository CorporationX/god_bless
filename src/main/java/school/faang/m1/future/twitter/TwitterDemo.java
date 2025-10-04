package school.faang.m1.future.twitter;

import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class TwitterDemo {
    public static void main(String[] args) throws Exception {
        try (TwitterSubscriptionSystem system = new TwitterSubscriptionSystem()) {
            TwitterAccount account = new TwitterAccount("Trump", 0);

            CompletableFuture<?>[] tasks = IntStream.range(0, 300)
                    .mapToObj(i -> system.followAccount(account))
                    .toArray(CompletableFuture[]::new);

            CompletableFuture.allOf(tasks).join();

            System.out.println("@" + account.getUsername() +
                    " подписчиков: " + account.getFollowers());
        }
    }
}
