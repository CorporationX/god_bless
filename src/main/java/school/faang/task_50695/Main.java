package school.faang.task_50695;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Альфред");

        List<CompletableFuture<TwitterAccount>> futures = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            futures.add(twitterSubscriptionSystem.followAccount(account));
        }

        futures.forEach(CompletableFuture::join);

        log.info("Количество подписчиков у {} равно {}", account.getUsername(), account.getFollowers());
    }
}