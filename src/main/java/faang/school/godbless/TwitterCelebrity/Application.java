package faang.school.godbless.TwitterCelebrity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        TwitterAccount twitterAccount = new TwitterAccount("username1", 0);
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i =0; i< 10; i++){
            futures.add(twitterSubscriptionSystem.followAccount(twitterAccount));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        System.out.println(twitterAccount.getFollowers());
    }
}
