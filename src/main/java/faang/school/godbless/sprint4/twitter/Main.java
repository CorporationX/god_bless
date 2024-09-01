package faang.school.godbless.sprint4.twitter;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        XSubscriptionSystem system = new XSubscriptionSystem();
        XAccount johnnyDepp = new XAccount("johnny_depp");
        List<CompletableFuture<Void>> futures = IntStream.rangeClosed(1, 15000)
                .mapToObj(i -> system.followAccount(johnnyDepp))
                .toList();

        CompletableFuture.allOf(futures.toArray(CompletableFuture[]::new)).join();
        System.out.println("Modified account: " + johnnyDepp);
    }
}
