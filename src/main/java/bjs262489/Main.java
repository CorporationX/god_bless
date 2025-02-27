package bjs262489;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        List<TwitterAccount> accounts = initializeAccounts();

        CompletableFuture.allOf(system.followAccount(accounts.get(0)),
                        system.followAccount(accounts.get(1)),
                        system.followAccount(accounts.get(2)),
                        system.followAccount(accounts.get(3)),
                        system.followAccount(accounts.get(4)),
                        system.followAccount(accounts.get(5)))
                .join();

        system.shutDownExecutorService();
    }

    private static List<TwitterAccount> initializeAccounts() {
        return new ArrayList<>(List.of(new TwitterAccount("Account1", 13),
                new TwitterAccount("Account2", 31),
                new TwitterAccount("Account3", 66),
                new TwitterAccount("Account4", 101),
                new TwitterAccount("Account5", 99),
                new TwitterAccount("Account6", 182)));
    }
}
