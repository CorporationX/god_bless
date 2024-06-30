package faang.school.godbless.multithreading_async.task_8;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class Main {
    public static void main(String[] args) {
        final TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        final List<TwitterAccount> twitterAccounts = getTwitterAccounts();
        final ExecutorService executor = Executors.newFixedThreadPool(twitterAccounts.size());
        final List<CompletableFuture<Void>> completableFutures = twitterAccounts.stream()
            .map(twitterAccount -> CompletableFuture.runAsync(() -> twitterSubscriptionSystem.addFollower(twitterAccount)))
            .toList();
        final CompletableFuture<Void> allFutures = CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0]));
        allFutures.join();
        twitterAccounts.forEach(twitterAccount -> log.info("{} has now {} followers!", twitterAccount.getUsername(), twitterAccount.getFollowers()));
        executor.shutdown();
    }

    private static List<TwitterAccount> getTwitterAccounts() {
        return List.of(
            new TwitterAccount("Kostah", 1000),
            new TwitterAccount("Someone4", 100),
            new TwitterAccount("CoolCat123", 50),
            new TwitterAccount("MoonWalker", 400),
            new TwitterAccount("LightningBolt"),
            new TwitterAccount("RiverFlow")
        );
    }


}
