package school.faang.multithreading.asynchronism.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
                    log.info("Игрок: {}, начинает асинхронное выполнение квеста, его опыт: {}", player.getName(), player.getExperience());
                    log.info("Игрок: {}, начинает выполнять квест: {}, награда: {}", player.getName(), quest.getName(), quest.getReward());
                    try {
                        Thread.sleep(quest.getDifficulty() * 1000L);
                        log.info("Игрок: {}, выполнил квест: {}", player.getName(), quest.getName());
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    player.addExperience(quest.getReward());
                    return player;
                })
                .thenApply(playerResult -> {
                    log.info("Игрок: {}, получает опыт: {}", playerResult.getName(), quest.getReward());
                    log.info("Игрок: {}, стал сильнее, его опыт: {}", playerResult.getName(), playerResult.getExperience());
                    return playerResult;
                });
    }
}
