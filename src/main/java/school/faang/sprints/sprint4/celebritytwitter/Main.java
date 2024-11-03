package school.faang.sprints.sprint4.celebritytwitter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class Main {
    public static final int COUNT_NEW_SUBSCRIPTIONS = 20;

    public static void main(String[] args) {
        TwitterSubscriptionSystem tss = new TwitterSubscriptionSystem();
        TwitterAccount testAcc = getTestAcc();

        List<CompletableFuture<Void>> futureFollows = Stream.iterate(0, (i) -> ++i)
                .limit(COUNT_NEW_SUBSCRIPTIONS)
                .map((i) -> tss.followAccount(testAcc))
                .toList();

        CompletableFuture.allOf(futureFollows.toArray(CompletableFuture[]::new))
                .thenRun(() -> System.out.println("Кол-во подписчиков: " + testAcc.getFollowers()));
    }

    private static TwitterAccount getTestAcc() {
        String testAccUsername = "acc_1";
        int testAccFollowers = 100;
        return new TwitterAccount(testAccUsername, testAccFollowers);
    }
}
