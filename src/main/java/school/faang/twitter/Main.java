package school.faang.twitter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    private static final int THREAD_COUNT = 4;
    private static final int SUBSCRIPTIONS_TO_SAFIXL = 113;
    private static final int SUBSCRIPTIONS_TO_SDAWNNEW = 87;
    private static final int TIMEOUT_SEC = 10;

    public static void main(String[] args) {
        TwitterAccount accountOne = new TwitterAccount("Safixl");
        TwitterAccount accountTwo = new TwitterAccount("SDawnNew");
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_COUNT);
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem(executor);
        List<CompletableFuture<Void>> futuresOne = IntStream.range(0, SUBSCRIPTIONS_TO_SAFIXL)
                .mapToObj(subscriptionIndex -> system.followAccount(accountOne))
                .toList();
        List<CompletableFuture<Void>> futuresTwo = IntStream.range(0, SUBSCRIPTIONS_TO_SDAWNNEW)
                .mapToObj(subscriptionIndex -> system.followAccount(accountTwo))
                .toList();
        CompletableFuture.allOf(futuresOne.toArray(new CompletableFuture[0])).join();
        CompletableFuture.allOf(futuresTwo.toArray(new CompletableFuture[0])).join();
        System.out.println(
                "У пользователя " + accountOne.getUsername() + " " + accountOne.getFollowers() + " подписчиков");

        System.out.println(
                "У пользователя " + accountTwo.getUsername() + " " + accountTwo.getFollowers() + " подписчиков");
        executor.shutdown();
        try {
            executor.shutdownNow();
            executor.awaitTermination(TIMEOUT_SEC, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}