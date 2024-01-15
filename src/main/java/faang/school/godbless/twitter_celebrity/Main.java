package faang.school.godbless.twitter_celebrity;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount mask = new TwitterAccount("Ilon Mask", 6_000_000);

        List<CompletableFuture<Void>> futures = IntStream.rangeClosed(1, 666)
                .mapToObj(num -> CompletableFuture.runAsync(() -> twitterSubscriptionSystem.followAccount(mask)))
                .toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        twitterSubscriptionSystem.stopExecutorService();

        System.out.println("На аккаунте: " + mask.getUserName() + ", количество подписчиков " + mask.getFollowers());
    }
}


@Data
@AllArgsConstructor
class TwitterAccount {
    private String userName;
    private int followers;
}


class TwitterSubscriptionSystem {
     private final ExecutorService executorService = Executors.newCachedThreadPool();

    public synchronized void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.setFollowers(twitterAccount.getFollowers() + 1);
    }

    public void followAccount(TwitterAccount twitterAccount) {
        CompletableFuture.runAsync(() -> {
            System.out.println("Tread to go: " + Thread.currentThread().getName() + "!");
            addFollower(twitterAccount);
        }, executorService);
//        });
    }

    public void stopExecutorService() {
        executorService.shutdown();
        try {
            if (!executorService.awaitTermination(10, TimeUnit.SECONDS)) {
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }
    }
}