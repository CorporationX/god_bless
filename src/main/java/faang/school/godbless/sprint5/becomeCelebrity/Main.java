package faang.school.godbless.sprint5.becomeCelebrity;

import faang.school.godbless.sprint5.becomeCelebrity.classes.TwitterAccount;
import faang.school.godbless.sprint5.becomeCelebrity.classes.TwitterSubscriptionSystem;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("User 1");
        List<CompletableFuture<TwitterAccount>> followers = new ArrayList<>();
        for (int i = 0; i < 1_000_000; i++) {
            followers.add(system.followAccount(account));
        }

        CompletableFuture.allOf(followers.toArray(new CompletableFuture[0]))
                .join();

        System.out.println(account.getFollowers());
    }
}