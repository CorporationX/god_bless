package school.faang.twittercelebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {

    public CompletableFuture<Void> followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> addFollower(account));
    }

    private synchronized void addFollower(TwitterAccount account) {
        account.addFollower();
        log.info("У пользователя {} новый подписчик! Теперь у него их {}!",
                account.getUsername(), account.getFollowers());
    }
}
