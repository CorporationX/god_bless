package faang.school.godbless.async.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        List<TwitterAccount> accounts = new ArrayList<>();

        accounts.add(new TwitterAccount("Mister Beast", 100));
        accounts.add(new TwitterAccount("Lawyer Egorov", 1000));

        List<CompletableFuture<Void>> followingTasks = new ArrayList<>();


        for (int i = 0; i < 10000; i++) {
            accounts.forEach(account -> {
                CompletableFuture<Void> followTask = subscriptionSystem.followAccount(account);
                followingTasks.add(followTask);
            });
        }

        subscriptionSystem.shutdownThreadPool();

        CompletableFuture.allOf(followingTasks.toArray(new CompletableFuture[0]))
                .join();

        accounts.forEach(System.out::println);
    }
}
