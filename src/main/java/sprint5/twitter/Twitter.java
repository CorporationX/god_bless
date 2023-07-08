package sprint5.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Twitter {
    private static final TwitterSubscriptionSystem SUBSCRIPTION_SYSTEM = new TwitterSubscriptionSystem();
    public static void main(String[] args) {
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        List<TwitterAccount> accounts = new ArrayList<>();
        TwitterAccount elonMusk = new TwitterAccount("Elon Musk");

        fillListWithAccounts(accounts);
        for (TwitterAccount account : accounts) {
            futures.add(SUBSCRIPTION_SYSTEM.followAccount(account, elonMusk));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Elon Musk's Subscribers: " + elonMusk.getFollowers());
    }

    private static void fillListWithAccounts(List<TwitterAccount> accounts) {
        for (int i = 0; i < 100; i++) {
            accounts.add(new TwitterAccount("Clone¹" + i));
        }
    }
}
