package school.faang.task50663;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class TwitterSubscriptionSystem {

    private void validateUsers(TwitterAccount... accounts) {
        Arrays.stream(accounts).forEach(Objects::requireNonNull);

        if (accounts[0].equals(accounts[1])) {
            throw new IllegalArgumentException("Пользователь не может добавить самого себя");
        }
    }

    private synchronized TwitterAccount addFollower(TwitterAccount follower, TwitterAccount account) {
        account.followers().add(follower);

        return account;
    }

    public CompletableFuture<Void> followAccount(TwitterAccount follower, TwitterAccount account) {
        validateUsers(follower, account);

        return CompletableFuture
                .supplyAsync(() -> addFollower(account, follower))
                .thenRunAsync(() -> log.info("{} подписался на {}", follower.username(), account.username()));
    }
}
