package school.faang.task_62188;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;

@Slf4j
public class QuestSystem {
    private static final int TIME_QUEST = 10000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(ThreadLocalRandom.current().nextInt(TIME_QUEST));
                log.info("Игрок {} завершил квест {}", player.getName(), quest.getName());

            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток прерван!");
            }
            player.addExperience(quest.getReward());
            return player;
        });
    }
}
