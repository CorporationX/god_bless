package school.faang.sprint_4.bjs2_38983_twitterCelebrity;

import lombok.extern.slf4j.Slf4j;
import school.faang.sprint_4.bjs2_38983_twitterCelebrity.account_manager.AccountManager;
import school.faang.sprint_4.bjs2_38983_twitterCelebrity.account_manager.TwitterAccount;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class TwitterSubscriptionSystem {
    public static void main(String[] args) {
        AccountManager manager = new AccountManager();
        ExecutorService executor = Executors.newCachedThreadPool();

        List<String> usersToCreate = List.of(
                "Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Uma", "Heidi", "Ivan", "Judy",
                "Mallory", "Uma", "Olivia", "Charlie", "Quentin", "Rupert", "Sybil", "Trent", "Uma", "Victor"
        );

        List<CompletableFuture<Void>> accountCreateTasks = usersToCreate.stream()
                .map(user -> CompletableFuture.runAsync(() -> manager.createTwitterAccount(user), executor))
                .toList();

        CompletableFuture.allOf(accountCreateTasks.toArray(new CompletableFuture[0])).thenRun(() -> {
            List<TwitterAccount> allAccounts = manager.getAllAccounts();

            List<CompletableFuture<Void>> everyoneSubscribeTasks = allAccounts.stream()
                    .map(follower -> CompletableFuture.runAsync(() -> {
                        List<CompletableFuture<Void>> subscriptionTasks = allAccounts.stream()
                                .filter(target -> !follower.equals(target))
                                .map(target -> CompletableFuture.runAsync(() ->
                                        manager.follow(follower, target), executor))
                                .toList();

                        CompletableFuture.allOf(subscriptionTasks.toArray(new CompletableFuture[0])).join();
                    }, executor))
                    .toList();

            CompletableFuture.allOf(everyoneSubscribeTasks.toArray(new CompletableFuture[0])).thenRun(() ->
                    allAccounts.forEach(account ->
                            log.info("Account with username '{}', has '{}' followers.",
                                    manager.getAccountUsername(account), manager.getFollowersCount(account)))).join();
        }).join();

        executor.shutdown();
        try {
            if (!executor.awaitTermination(5, TimeUnit.SECONDS)) {
                log.info("Something went wrong! Shutting down immediately!");
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("An error occurred while thread shutting down now.", e);
            throw new IllegalStateException(e);
        }
    }
}
