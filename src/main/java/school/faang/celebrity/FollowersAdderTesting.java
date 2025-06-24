package school.faang.celebrity;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class FollowersAdderTesting {
    public static void main(String[] args) {
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Sam", new AtomicInteger(3));

        log.info("Стартовое число подписчиков аккаунта {} равно {}.",
                account.getUsername(), account.getFollowers());

        subscriptionSystem.followAccount(account, 100);
        log.info("Обновленное число подписчиков аккаунта {} равно {}.",
                account.getUsername(), account.getFollowers());
    }
}
