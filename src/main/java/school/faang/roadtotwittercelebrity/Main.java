package school.faang.roadtotwittercelebrity;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Chill", 0);

        List<CompletableFuture<Void>> followTasks = List.of(
                subscriptionSystem.followAccount(account),
                subscriptionSystem.followAccount(account),
                subscriptionSystem.followAccount(account),
                subscriptionSystem.followAccount(account),
                subscriptionSystem.followAccount(account),
                subscriptionSystem.followAccount(account),
                subscriptionSystem.followAccount(account),
                subscriptionSystem.followAccount(account),
                subscriptionSystem.followAccount(account),
                subscriptionSystem.followAccount(account),
                subscriptionSystem.followAccount(account)
        );

        CompletableFuture<Void> allFollows = CompletableFuture.allOf(followTasks.toArray(new CompletableFuture[0]));
        allFollows.join();

        System.out.println("Количество подписчиков у " + account.getUsername() + ": " + account.getFollowers());
    }
}
