package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        CompletableFuture<Player> questFuture = CompletableFuture.supplyAsync(() -> {

            try {
                Thread.sleep(quest.difficulty() * 100);
            } catch (InterruptedException e) {
                log.error("Произошла ошибка при ожидание {}", e.getMessage());
            }

            player.addExperience(quest.reward());
            return player;
        });

        questFuture.thenAccept((player1) -> log.info("Игрок {} успешно выполнил задание и получил {}" +
                        " очков опыта. Текущий счет очков: {}",
                player1.getName(), quest.reward(), player1.getExperience()));
        return questFuture;
    }
}