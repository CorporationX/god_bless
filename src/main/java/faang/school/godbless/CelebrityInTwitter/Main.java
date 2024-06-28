package faang.school.godbless.CelebrityInTwitter;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        List<TwitterAccount> accounts = createAccounts();
        CompletableFuture
                .allOf(accounts.stream()
                        .map(system::followAccount)
                        .toArray(CompletableFuture[]::new))
                .join();
        accounts.forEach(System.out::println);
        system.getExecutorService().shutdown();
    }

    private static List<TwitterAccount> createAccounts() {
        return List.of(
                new TwitterAccount("Kirill"),
                new TwitterAccount("Vasia"),
                new TwitterAccount("Roma"),
                new TwitterAccount("Petr"));
    }
}
