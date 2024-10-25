package school.faang.twittercelebrity;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount accountToFollow = new TwitterAccount("Very Famous blogger", 1000);
        int newFollowersCount = 100;
        ExecutorService executor = Executors.newScheduledThreadPool(10);

        List<CompletableFuture<Void>> futureFollowers = new ArrayList<>();
        for (int i = 0; i < newFollowersCount; i++) {
            futureFollowers.add(system.followAccount(accountToFollow, executor));
        }
        CompletableFuture.allOf(futureFollowers.toArray(new CompletableFuture[0])).join();
        executor.shutdown();

        System.out.println("\nFINAL STATE: Account \"" + accountToFollow.getUsername() + "\" has TOTAL " + accountToFollow.getFollowers() + " followers");
    }
}