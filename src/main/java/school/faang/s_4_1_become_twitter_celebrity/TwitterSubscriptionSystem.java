package school.faang.s_4_1_become_twitter_celebrity;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.Map;

public class TwitterSubscriptionSystem {
    private ExecutorService executor = Executors.newFixedThreadPool(5);
    private Map<TwitterAccount, Set<TwitterAccount>> subscriptions = new ConcurrentHashMap<>();// account with followers

    // использую атомик, чтобы не залипать потокам на синхронайзде в ожидании, поэтому убрала синхронайзд
    // private synchronized void addFollower(TwitterAccount account) {
    private void addFollower(TwitterAccount account) {
        account.incrementFollowers();
    }

    // передаём кого фолловить
    public CompletableFuture<Void> followAccount(TwitterAccount subscriber, TwitterAccount targetAccount) {
        return CompletableFuture.runAsync(() -> {
            // subscriptions.computeIfAbsent(targetAccount, key -> new HashSet<>()).add(subscriber);
            if (!subscriptions.containsKey(targetAccount)) {
                subscriptions.put(targetAccount, ConcurrentHashMap.newKeySet());
            }
            subscriptions.get(targetAccount).add(subscriber);
            addFollower(targetAccount);
        }, executor);
    }

    public void shutdown() {
        executor.shutdown();
    }
}
