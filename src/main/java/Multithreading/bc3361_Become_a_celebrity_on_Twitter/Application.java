package Multithreading.bc3361_Become_a_celebrity_on_Twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Application {
    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscription = new TwitterSubscriptionSystem();
        TwitterAccount twitterAccount = new TwitterAccount("Michael Jordan", 0);
        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        for (int i = 0; i < 1000; i++) {
            if (new Random().nextBoolean()) {
                CompletableFuture.runAsync(() -> twitterSubscription.followAccount(twitterAccount), executorService);
            } else {
                completableFutures.add(CompletableFuture.runAsync(() -> twitterSubscription.addFollower(twitterAccount), executorService));
            }
        }

        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();
        executorService.shutdown();
        System.out.println(twitterAccount.getFollowers());
    }
}
