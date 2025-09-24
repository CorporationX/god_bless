package school.faang.bjs2_92958;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TwitterSubscriptionSystem {

    private synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public synchronized void followAccount(TwitterAccount account) {
        addFollower(account);
        log.info("Добавил подписчика к аккаунту {}. Итого подписчиков - {}",
                account.getUsername(), account.getFollowers());

    }



}
