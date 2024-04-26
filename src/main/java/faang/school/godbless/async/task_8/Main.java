package faang.school.godbless.async.task_8;

import faang.school.godbless.async.task_8.model.TwitterAccount;
import faang.school.godbless.async.task_8.service.TwitterSubscriptionSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int NUM_OF_FOLLOWERS = 50;

    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount denis = new TwitterAccount("denis", 3);
        List<CompletableFuture<TwitterAccount>> futureFollowers = new ArrayList<>();
        for (int index = 0; index < NUM_OF_FOLLOWERS; index++) {
            futureFollowers.add(subscriptionSystem.followAccount(denis));
        }
        subscriptionSystem.shutDownPoolOfTwitterSubscriptionSystem();
        CompletableFuture.allOf(futureFollowers.toArray(new CompletableFuture[0]))
                .thenAccept((Void) -> System.out.println("количество подписчиков " + denis.getUsername() + ": " + denis.getFollowers()));
    }
}