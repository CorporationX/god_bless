package school.faang.bjs2_92949;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {

    private void addFollower(TwitterAccount account) {
        if (account == null) {
            log.error("account cannot be null");
            return;
        }
        account.addFollower();
        log.info("followers added");
    }

    public CompletableFuture followAccount(TwitterAccount account) {
        return CompletableFuture.runAsync(() -> {
            addFollower(account);
        });
    }
}
