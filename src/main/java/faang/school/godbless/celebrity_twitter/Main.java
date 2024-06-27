package faang.school.godbless.celebrity_twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);

        TwitterAccount account = new TwitterAccount("Rauan");
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> completableFutures = new ArrayList<>();

        for (int i = 0; i < 100000; i++) {
            completableFutures.add(subscriptionSystem.followAccount(account, executorService));
        }

        completableFutures.forEach(CompletableFuture::join);
        executorService.shutdown();

        System.out.printf("Total %s followers: %s", account.getName(), account.getFollowers());
    }
}
