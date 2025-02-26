package wow;

import lombok.extern.slf4j.Slf4j;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        Objects.requireNonNull(player, "Игрок не должен быть null");
        Objects.requireNonNull(quest, "Квест не должен быть null");

        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("{} начал квест '{}', сложность: {}.",
                        player.getName(), quest.getName(), quest.getDifficulty());
                Thread.sleep(quest.getDifficulty() * 1000L);
                player.addExperience(quest.getReward());
                log.info("{} завершил квест '{}'. Получено {} опыта.",
                        player.getName(), quest.getName(), quest.getReward());
                return player;
            } catch (InterruptedException e) {
                log.error("Ошибка при выполнении квеста '{}'.", quest.getName(), e);
                Thread.currentThread().interrupt();
                throw new RuntimeException(e);
            }
        });
    }
}
