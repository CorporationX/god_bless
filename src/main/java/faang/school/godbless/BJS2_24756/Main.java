package faang.school.godbless.BJS2_24756;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        XAccount account = new XAccount("Elon Mask");
        XSubscriptionSystem subSystem = new XSubscriptionSystem();

        List<CompletableFuture<Void>> results = IntStream.range(0, 1000)
                .mapToObj(i -> CompletableFuture.runAsync(() -> subSystem.followAccount(account), executor))
                .toList();

        CompletableFuture.allOf(results.toArray(CompletableFuture[]::new)).join();

        int followers = account.getFollowers();
        System.out.println(account.getName() + " have " + followers + " followers");
    }
}
