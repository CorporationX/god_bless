package school.faang.bjs50841;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static final TwitterSubscriptionSystem SUBSCRIPTION_SYSTEM = new TwitterSubscriptionSystem();

    public static void main(String[] args) {
        TwitterAccount account1 = new TwitterAccount("Alex");
        TwitterAccount account2 = new TwitterAccount("Max");
        TwitterAccount account3 = new TwitterAccount("Sam");
        TwitterAccount account4 = new TwitterAccount("Chris");
        TwitterAccount account5 = new TwitterAccount("Taylor");

        List<CompletableFuture<Void>> subscriptionResults = new ArrayList<>();
        subscriptionResults.add(account2.followAccount(account1));
        subscriptionResults.add(account3.followAccount(account1));
        subscriptionResults.add(account4.followAccount(account1));
        subscriptionResults.add(account5.followAccount(account1));
        subscriptionResults.forEach(CompletableFuture::join);
        log.info("Total subscribers: {}", account1.getFollowers());
    }
}
