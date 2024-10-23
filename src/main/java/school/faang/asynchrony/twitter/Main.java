package school.faang.asynchrony.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int FOLLOWERS_NUMBER = 1_000;

    public static void main(String[] args) {

        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("abzalkhan");
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        for (int i = 0; i < FOLLOWERS_NUMBER; i++) {
            futures.add(system.followAccount(account));
        }
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        system.shutDown();

        System.out.println("subscribers count is : " + account.getFollowers());
    }

}
