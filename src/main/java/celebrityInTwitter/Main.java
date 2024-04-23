package celebrityInTwitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account1 = new TwitterAccount("nn1ck0");
        TwitterAccount account2 = new TwitterAccount("LSP");
        TwitterAccount account3 = new TwitterAccount("Eminem");

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        addFollowers(account1, subscriptionSystem, futures, 200);
        addFollowers(account2, subscriptionSystem, futures, 300);
        addFollowers(account3, subscriptionSystem, futures, 500);

        futures.forEach(CompletableFuture::join);
        System.out.printf("\n%s have %d followers", account1.getUsername(), account1.getFollowers().get());
        System.out.printf("\n%s have %d followers", account2.getUsername(), account2.getFollowers().get());
        System.out.printf("\n%s have %d followers", account3.getUsername(), account3.getFollowers().get());
    }

    static void addFollowers(TwitterAccount account, TwitterSubscriptionSystem subscriptionSystem, List<CompletableFuture<Void>> futures, int followers) {
        for (int i = 0; i < followers; i++) {
            futures.add(subscriptionSystem.followAccount(account));
        }
    }
}
