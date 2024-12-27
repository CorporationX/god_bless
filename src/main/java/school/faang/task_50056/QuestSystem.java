package school.faang.task_50056;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final long QUEST_TIME = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        if (player == null || quest == null) {
            throw new IllegalArgumentException("Некорретные входные параметры!");
        }

        CompletableFuture<Player> playerAfterQuest = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * QUEST_TIME);
            } catch (InterruptedException e) {
                log.error("Возникла ошибка при выполнении метода sleep()", e);
            }

            player.updateExperience(quest.getReward());
            player.updateLevel();
            log.info("Игрок {} после квеста имеет уровень {} и опыт, равный {}",
                    player.getName(), player.getLevel(), player.getExperience());

            return player;
        });

        return playerAfterQuest;
    }
}
