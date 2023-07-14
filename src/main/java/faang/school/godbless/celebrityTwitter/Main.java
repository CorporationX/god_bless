package faang.school.godbless.celebrityTwitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        List<TwitterAccount> accounts = new ArrayList<>();
        accounts.add(new TwitterAccount("Sara"));
        accounts.add(new TwitterAccount("Julia"));
        accounts.add(new TwitterAccount("Michail"));

        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> followTasks = new ArrayList<>();
        for (TwitterAccount account : accounts) {
            followTasks.add(CompletableFuture.runAsync(() -> subscriptionSystem.followAccount(account)));
        }
        CompletableFuture.allOf(followTasks.toArray(new CompletableFuture[0]))
                .thenRun(() -> {
                    System.out.println("Followers:");
                    for (TwitterAccount account : accounts) {
                        printAccountFollowers(account);
                    }
                })
                .join();
    }

    private static void printAccountFollowers(TwitterAccount account) {
        System.out.println(account.getUsername() + ": " + account.getFollowers() + " follower(s)");
    }

}
