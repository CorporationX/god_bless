package faang.school.godbless.twitter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();

        List<TwitterAccount> accounts = new ArrayList<>();
        accounts.add(new TwitterAccount("Balbes"));
        accounts.add(new TwitterAccount("Rediska"));
        accounts.add(new TwitterAccount("MachineGun"));
        accounts.add(new TwitterAccount("KotakBus"));


        List<CompletableFuture<Void>> futureResults = new ArrayList<>();

        accounts.forEach(account -> {
            System.out.println("Following for " + account.getUserName() + " has started");
            futureResults.add(CompletableFuture.runAsync(() -> {
                int randomNumber = 10000;
                for (int i = 0; i < randomNumber; i++) {
                    system.followAccount(account);
                }
            }));
        });

        CompletableFuture.allOf(futureResults.toArray(CompletableFuture[]::new)).join();
        accounts.forEach((account) -> System.out.printf("%s has %s followers\n", account.getUserName(), account.getFollowers().toString()));
    }
}
