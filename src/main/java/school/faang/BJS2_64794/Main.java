package school.faang.BJS2_64794;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        TwitterAccount ramilTwitter = new TwitterAccount("Ramil", new AtomicInteger(92));
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();

        int futureSubscribers = 100;

        List<CompletableFuture<TwitterAccount>> subscriberLists = new ArrayList<>();

        for (int i = 0; i < futureSubscribers; i++) {
            subscriberLists.add(twitterSubscriptionSystem.followAccount(ramilTwitter));
        }

        CompletableFuture.allOf(subscriberLists.toArray(new CompletableFuture[0])).join();

        log.info("Текущее количество подписчиков {} на аккаунте {}",
                ramilTwitter.getFollowers(), ramilTwitter.getUsername());
    }
}
