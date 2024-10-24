package org.example.service.wow;

import lombok.extern.slf4j.Slf4j;
import org.example.model.wow.Player;
import org.example.model.wow.Quest;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.info(e.getMessage());
                return player;
            }

            player.setExperience(player.getExperience() + (quest.getDifficulty() * 0.5));
            player.setLevel(player.getLevel() + 1);
            log.info("Player take reward: {}, for accomplishment this quest: {}", quest.getReward(), quest.getName());
            executorService.shutdown();
            return player;
        }, executorService);
    }
}
