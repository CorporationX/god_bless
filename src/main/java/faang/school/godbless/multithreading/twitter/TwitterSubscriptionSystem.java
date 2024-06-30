package faang.school.godbless.multithreading.twitter;

import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {
    public static CompletableFuture<Void> addFollower(TwitterAccount account){
        return CompletableFuture.runAsync(account::incrementFollowers);
    }
}
