package faang.school.godbless;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Application {
    private static final int NUMBER_OF_SUBSCRIPTORS = 25;
    private static final int THREAD_POOL_SIZE = NUMBER_OF_SUBSCRIPTORS;

    public static void main(String[] args) {
        TwitterAccount nurs = new TwitterAccount("nurs", 0);
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem(THREAD_POOL_SIZE);
        List<CompletableFuture<Void>> list = IntStream.range(0, NUMBER_OF_SUBSCRIPTORS+1)
                .mapToObj(i -> subscriptionSystem.followAccount(nurs)).toList();

        CompletableFuture.allOf(list.toArray(new CompletableFuture[0]))
                .thenRun(() -> log.info("nurs have new {} new followers", nurs.getFollowers()))

                .join();

        System.out.println("total folowers for " + nurs.getUsername() + " : " + nurs.getFollowers());
        subscriptionSystem.shutDown();
    }

}