package ru.maks1979.task_50182;

import java.util.concurrent.CompletableFuture;

import static java.lang.Thread.*;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(
                () -> {
                    try {
                        sleep(quest.getDifficulty());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    return new Player(player.getName(), player.getLevel(),
                            player.getExperience() + quest.getReward());
                });
    }
}
