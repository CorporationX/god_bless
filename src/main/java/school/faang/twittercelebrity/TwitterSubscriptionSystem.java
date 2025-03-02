package school.faang.twittercelebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount account) {
        return CompletableFuture.supplyAsync(() -> addFollower(account))
                .thenApply(result -> {
                    log.info("Для аккаунта {} добавлен новый подписчик", account.getUsername());
                    return result;
                });
    }

    private TwitterAccount addFollower(TwitterAccount account) {
        account.addFollower();
        return account;
    }
}
