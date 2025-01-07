package faang.school.godbless.FourthSprint.bjs2_51053;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int FOLLOWERS_COUNT = 15;
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount mainAccount = new TwitterAccount("John");

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < FOLLOWERS_COUNT; i++) {
            futures.add(system.followAccount(mainAccount));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        system.executorShutdown();
    }
}
