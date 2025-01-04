package school.faang.bjs250924;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestClass {
    private static final ExecutorService service = Executors.newFixedThreadPool(4);

    public static void main(String[] args) {
        runTest();
        service.shutdown();
    }

    private static void runTest() {
        List<TwitterAccount> accounts = new ArrayList<>();
        for (int accauntId = 1;  accauntId < 20; accauntId++) {
            accounts.add(new TwitterAccount("user" + accauntId));
        }

        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem(service);

        List<CompletableFuture<Void>> futuresList = accounts.stream()
                .map(account -> system.followAccount(accounts.get(0)))
                .toList();

        CompletableFuture.allOf(futuresList.toArray(new CompletableFuture[0])).join();

        accounts.forEach(account ->
                System.out.println(account.getUsername() + " has " + account.getFollowers() + " followers")
        );
    }
}
