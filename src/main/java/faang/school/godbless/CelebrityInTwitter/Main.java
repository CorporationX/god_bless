package faang.school.godbless.CelebrityInTwitter;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        List<TwitterAccount> accounts = createAccounts();
        List<CompletableFuture<Void>> completableFutures = accounts.stream()
                .map(system::followAccount).toList();
        CompletableFuture.allOf(completableFutures.toArray(new CompletableFuture[0])).join();
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
