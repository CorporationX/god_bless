package school.faang.bjs2_92958;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwitterSubscriptionSystem {

    public void followAccount(TwitterAccount account) {
        account.getFollowers().incrementAndGet();
        log.info("Добавил подписчика к аккаунту {}. Итого подписчиков - {}",
                account.getUsername(), account.getFollowers());
    }
}
