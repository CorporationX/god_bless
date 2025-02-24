package school.faang.sprint4.bjs2_63654;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Игрок {} приступил к выполнению квеста {}", player.getName(), quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000L);
                log.info("Игрок {} завершил выполнение квеста {}", player.getName(), quest.getName());
                player.addExperience(quest.getReward());
                log.info("Игрок {} получил {} опыта, общее количество опыта: {}", player.getName(), quest.getReward(),
                        player.getExperience());
                return player;
            } catch (InterruptedException e) {
                log.error("Выполнение квеста {} прервано {}", quest.getName(), e.getMessage());
                throw new RuntimeException("Квест прерван", e);
            }
        });
    }
}
