package school.faang.twitter;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionsSystem tss = new TwitterSubscriptionsSystem();

        List<TwitterAccount> accounts = List.of(
                new TwitterAccount("user1", 100),
                new TwitterAccount("user2", 250),
                new TwitterAccount("user3", 500),
                new TwitterAccount("user4", 750),
                new TwitterAccount("user5", 1000
                ));

        CompletableFuture[] completableFuture = accounts.stream().map(tss::followAccount).toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(completableFuture).join();

        for (TwitterAccount ta : accounts){
            System.out.println("Username: " + ta.getUsername() + ", Followers: " + ta.getFollowers());
        }
    }
}
