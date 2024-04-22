package faang.school.godbless.become_celebrity_in_twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        List<TwitterAccount> twitterAccounts = initialize();
        ExecutorService executorService = Executors.newFixedThreadPool(twitterAccounts.size());
        List<CompletableFuture<Void>> futures = new ArrayList<>();

        twitterAccounts.forEach(account -> futures.add(twitterSubscriptionSystem.followAccount(account, executorService)));
        futures.forEach(CompletableFuture::join);
        executorService.shutdown();

        twitterAccounts.forEach(System.out::println);
    }

    public static List<TwitterAccount> initialize() {
        return List.of(
                new TwitterAccount("Test1", new AtomicInteger(2)),
                new TwitterAccount("Test2", new AtomicInteger(4)),
                new TwitterAccount("Test3", new AtomicInteger(2)),
                new TwitterAccount("Test4", new AtomicInteger(6)),
                new TwitterAccount("Test5", new AtomicInteger(8)),
                new TwitterAccount("Test6", new AtomicInteger(99)),
                new TwitterAccount("Test7", new AtomicInteger(23)),
                new TwitterAccount("Test8", new AtomicInteger(45))
        );
    }
}