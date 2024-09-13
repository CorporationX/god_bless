package ru.kraiush.threads.BJS2_18357;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> combineItems(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> player)
                .thenCombine(CompletableFuture.supplyAsync(
                        () -> quest), (p, q) -> {
                    p.setExperience(p.getExperience() + q.getReward());
                    return p;
                });
    }
}
