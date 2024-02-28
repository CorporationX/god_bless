package faang.school.godbless.becometwitterceleb3193;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Twitter {
    static final List<TwitterAccount> TWITTER_ACCOUNTS = createTwitterAccountsList();
    static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(8);
    static final TwitterSubscriptionSystem SUBSCRIPTION_SYSTEM = new TwitterSubscriptionSystem();
    static final Random RANDOM = new Random();

    public static void main(String[] args) {
        System.out.printf("Before start situation:%n%s%n", TWITTER_ACCOUNTS);
        int accountsQuantity = TWITTER_ACCOUNTS.size();
        List<CompletableFuture<TwitterAccount>> futureAccounts = new ArrayList<>();

        for (int i = 0; i < 1_000_000; i++) {
            futureAccounts.add(SUBSCRIPTION_SYSTEM
                    .followAccount(TWITTER_ACCOUNTS.get(RANDOM.nextInt(accountsQuantity)), EXECUTOR));
        }

        CompletableFuture.allOf(futureAccounts.toArray(CompletableFuture[]::new))
                .thenRun(EXECUTOR::shutdown)
                .thenRun(() -> System.out.printf("After everything done situation:%n%s%n", TWITTER_ACCOUNTS));
    }

    private static List<TwitterAccount> createTwitterAccountsList() {
        return new ArrayList<>(List.of(
                new TwitterAccount("FAANG SCHOOL"),
                new TwitterAccount("hhzktoeto"),
                new TwitterAccount("Elon_not_Masked"),
                new TwitterAccount("AnotherCringyName")
        ));
    }
}
