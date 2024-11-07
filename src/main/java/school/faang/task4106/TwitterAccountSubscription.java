package school.faang.task4106;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class TwitterAccount {
    private final String username;
    private int followers;

    public TwitterAccount(String username, int followers) {
        this.username = username;
        this.followers = followers;
    }

    public String getUsername() {
        return username;
    }

    public synchronized int getFollowers() {
        return followers;
    }

    public synchronized void addFollower() {
        followers++;
    }
}

class TwitterSubscriptionSystem {
    public void followAccount(TwitterAccount account, int numberOfFollowers) {
        List<CompletableFuture<Void>> futures = IntStream.range(0, numberOfFollowers)
                .mapToObj(i -> CompletableFuture.runAsync(() -> addFollower(account)))
                .collect(Collectors.toList());

        CompletableFuture<Void> allOf = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));

        allOf.join();

        System.out.println("Количество подписчиков учетной записи " + account.getUsername() + ": " + account.getFollowers());
    }

    private void addFollower(TwitterAccount account) {
        account.addFollower();
        System.out.println("Добавлен подписчик к учетной записи: " + account.getUsername());
    }
}

public class TwitterAccountSubscription {
    public static void main(String[] args) {
        TwitterAccount account = new TwitterAccount("@example", 0);
        TwitterSubscriptionSystem subscriptionSystem = new TwitterSubscriptionSystem();

        // Добавление нескольких подписчиков
        subscriptionSystem.followAccount(account, 5);
    }
}

