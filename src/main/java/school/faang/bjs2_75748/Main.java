package school.faang.bjs2_75748;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final Integer FOLLOWS = 8;

    public static void main(String[] args) {
        TwitterSubscriptionSystem twitterSubscriptionSystem = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Join");
        List<CompletableFuture<Void>> processedFollows = IntStream.range(0, FOLLOWS)
                .mapToObj(i -> twitterSubscriptionSystem.followAccount(account)).toList();
        CompletableFuture.allOf(processedFollows.toArray(CompletableFuture[]::new)).join();

        twitterSubscriptionSystem.shutDownExecutor(5L);
        log.info("У аккаунта {} - {} подписчиков", account.getUserName(), account.getFollowers());
    }
}
