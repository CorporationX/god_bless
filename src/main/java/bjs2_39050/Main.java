package bjs2_39050;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        List<CompletableFuture<Void>> futures = new ArrayList<>();
        List<TwitterAccount> accounts = List.of(
                new TwitterAccount("name1"),
                new TwitterAccount("name2"),
                new TwitterAccount("name3"),
                new TwitterAccount("name4"),
                new TwitterAccount("name5"));

        accounts.forEach(account -> {
            ArrayList<TwitterAccount> subscribers = new ArrayList<>(accounts);
            subscribers.remove(account);
            subscribers.forEach(subscriber ->
                    futures.add(system.followAccount(account, subscriber)));
        });
        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();

        accounts.forEach(System.out::println);
    }
}
