package school.faang.bjs2_74731;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class TwitterSubscriptionSystem {

    private static final Random random = new Random();

    private void addFollower(TwitterAccount account) {
        account.newFollower();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        int randomNumberOfFollowers = random.nextInt(1, 10);
        List<CompletableFuture<Void>> newFollowers = new ArrayList<>(randomNumberOfFollowers);
        for (int i = 0; i < randomNumberOfFollowers; i++) {
            newFollowers.add(CompletableFuture.runAsync(() -> addFollower(account)));
        }

        return CompletableFuture.allOf(newFollowers.toArray(new CompletableFuture[0]));
    }
}
