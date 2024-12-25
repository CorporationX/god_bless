package school.faang.task50663;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {

    private void validateUsers(List<TwitterAccount> accounts) {
        accounts.forEach(Objects::requireNonNull);

        if (accounts.get(0).equals(accounts.get(1))) {
            throw new IllegalArgumentException("Пользователь не может добавить самого себя");
        }
    }

    private synchronized TwitterAccount addFollower(TwitterAccount follower, TwitterAccount account) {
        account.followers().add(follower);

        return account;
    }

    public CompletableFuture<Void> followAccount(TwitterAccount follower, TwitterAccount account) {
        validateUsers(List.of(follower, account));

        return CompletableFuture
                .supplyAsync(() -> addFollower(account, follower))
                .thenRunAsync(() -> log.info("{} подписался на {}", follower.username(), account.username()));
    }
}
