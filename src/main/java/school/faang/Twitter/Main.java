package school.faang.Twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        TwitterAccount twitterAccount = new TwitterAccount("Nikita", 0);

        List<CompletableFuture<Void>> waveOfSubscriptions = new ArrayList<>();

        waveOfSubscriptions.add(twitterSubscriptionSystem.followAccount(twitterAccount));
        waveOfSubscriptions.add(twitterSubscriptionSystem.followAccount(twitterAccount));
        waveOfSubscriptions.add(twitterSubscriptionSystem.followAccount(twitterAccount));
        waveOfSubscriptions.add(twitterSubscriptionSystem.followAccount(twitterAccount));
        waveOfSubscriptions.add(twitterSubscriptionSystem.followAccount(twitterAccount));

        CompletableFuture<Void> completableFuture = CompletableFuture.allOf(waveOfSubscriptions.toArray(new CompletableFuture[0]));

        completableFuture.thenRun(() -> System.out.printf("подписчиков у %s -> %s\n", twitterAccount.getUsername(), twitterAccount.getFollowers()));
    }
}
