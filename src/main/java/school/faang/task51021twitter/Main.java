package school.faang.task51021twitter;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {

        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("Tom");

        List<CompletableFuture> futures = new ArrayList<>();

        IntStream.range(0, 15).forEach(num -> futures.add(system.followAccount(account)));

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        system.executorShutdown();
        log.info("Количество подписчиков {} ", account.getFollowers());
    }
}
