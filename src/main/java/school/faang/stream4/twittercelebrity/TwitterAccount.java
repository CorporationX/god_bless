package school.faang.stream4.twittercelebrity;

import lombok.Data;

import java.util.concurrent.CompletableFuture;

@Data
public class TwitterAccount {
    private final String username;
    private int followers;

    public CompletableFuture<Void> followAccount(TwitterAccount account){
        return CompletableFuture.runAsync(() -> TwitterSubscriptionSystem.addFollower(account));
    }
}
