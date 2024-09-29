package ru.kraiush.threads.BJS2_18357;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> combineItems(Player palyer, Quest quest) {

        return CompletableFuture.supplyAsync(() -> palyer)
                .thenCombine(CompletableFuture.supplyAsync(
                        () -> quest), (p, q) -> {
                    p.setExperience(p.getExperience() + q.getReward());
                    return p;
                });
    }
}
