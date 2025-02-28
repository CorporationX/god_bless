package school.faang.becoming_a_celebrity_on_twitter.BJS2_62552;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount roxi = new TwitterAccount("Roxi");

        List<CompletableFuture<Void>> roxySubscriptions = new ArrayList<>();
        for (int i = 0; i < 52; i++) {
            roxySubscriptions.add(twitterSubscriptionSystem.followAccount(roxi));
        }
        CompletableFuture.allOf(roxySubscriptions.toArray(new CompletableFuture[0])).join();
        log.info("Количество подписчиков {}: {}", roxi.getUsername(), roxi.getFollowers());
    }
}
