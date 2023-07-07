package faang.school.godbless.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterAccount twitterAccount = new TwitterAccount("Cristiano Ronaldo", 20_000);
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        List<CompletableFuture<TwitterAccount>> futuresAccounts = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            CompletableFuture<TwitterAccount> twitterAccountCompletableFuture = twitterSubscriptionSystem.followAccount(twitterAccount);
            futuresAccounts.add(twitterAccountCompletableFuture);
        }

        CompletableFuture.allOf(futuresAccounts.toArray(new CompletableFuture[0]))
                .join();

        System.out.println(twitterAccount.getFollowers());
    }
}
