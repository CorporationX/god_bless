package school.faang.sprint_4.task_43580;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int FOLLOW_TASK_NUMBER = 5_000_000;

    public static void main(String[] args) {
        TwitterSubscriptionSystem system = new TwitterSubscriptionSystem();
        TwitterAccount account = new TwitterAccount("ksusha", 0);

        List<CompletableFuture<Void>> futures = new ArrayList<>();

        for (int i = 0; i < FOLLOW_TASK_NUMBER; i++) {
            futures.add(system.followAccount(account));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0])).join();
        System.out.println("Подписчиков на аккаунт " + account.getUsername() + ": " + account.getFollowers());
    }
}