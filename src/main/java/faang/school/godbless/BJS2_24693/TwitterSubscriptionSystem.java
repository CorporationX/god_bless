package faang.school.godbless.BJS2_24693;

import lombok.RequiredArgsConstructor;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@RequiredArgsConstructor
public class TwitterSubscriptionSystem {

    private void addFollower(TwitterAccount twitterAccount) {
        twitterAccount.incrementFollowers();
    }

    public CompletableFuture<Void> followAccount(TwitterAccount twitterAccount, ExecutorService executorService) {
        return CompletableFuture.runAsync(() -> addFollower(twitterAccount), executorService);
    }

}
