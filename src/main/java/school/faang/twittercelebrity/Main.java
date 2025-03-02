package school.faang.twittercelebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount alex = new TwitterAccount("Alex");
        TwitterAccount elon = new TwitterAccount("Elon");

        List<CompletableFuture<TwitterAccount>> features = List.of(
                twitterSubscriptionSystem.followAccount(alex),
                twitterSubscriptionSystem.followAccount(alex),
                twitterSubscriptionSystem.followAccount(alex),
                twitterSubscriptionSystem.followAccount(elon),
                twitterSubscriptionSystem.followAccount(elon)
        );

        CompletableFuture.allOf(features.toArray(new CompletableFuture[0])).join();
        getFollowersCountInfo(alex);
        getFollowersCountInfo(elon);
    }

    private static void getFollowersCountInfo(TwitterAccount twitterAccount) {
        log.info("Количество подписчиков {} составляет {}",
                twitterAccount.getUsername(), twitterAccount.getFollowers());
    }
}
