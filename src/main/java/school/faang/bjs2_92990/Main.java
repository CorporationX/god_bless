package school.faang.bjs2_92990;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final int FOLLOWERS_AMOUNT = 10;

    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount famousAccount = new TwitterAccount("Veritasium");
        List<CompletableFuture<TwitterAccount>> allFollowingActions = new ArrayList<>();

        for (int i = 0; i < FOLLOWERS_AMOUNT; i++) {
            allFollowingActions.add(twitterSubscriptionSystem.followAccount(famousAccount));
        }
        CompletableFuture.allOf(allFollowingActions.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("Общее количество подписчиков на аккаунте {}: {}",
                        famousAccount.getUsername(), famousAccount.getFollowers()));
        twitterSubscriptionSystem.shutdownCorrectly();
    }
}
