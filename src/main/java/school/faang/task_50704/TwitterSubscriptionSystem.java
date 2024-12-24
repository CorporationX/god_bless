package school.faang.task_50704;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TwitterSubscriptionSystem {
    private ExecutorService executor = Executors.newCachedThreadPool();

    public synchronized void addFollower(TwitterAccount account) {
        account.setFollowers(account.getFollowers() + 1);
    }

    public CompletableFuture<TwitterAccount> followAccount(TwitterAccount account) {
        CompletableFuture<TwitterAccount> accountFuture = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.currentThread().sleep(2000);
                addFollower(account);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            }
            return account;
        }, executor); // тут я хотел бы доабавить thenRun(() -> sout("вы успешно подписались на аккаунт "
        // + account.getUsername()))
        return accountFuture;
    }

    public void shutdownExecutor() {
        executor.shutdown();
    }
}
