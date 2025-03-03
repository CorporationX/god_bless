package school.faang.module1.sprint4.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.*;

@Slf4j
public class QuestSystem {
    private final Object lock = new Object();

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        try {
            Thread.sleep(quest.difficulty());
        } catch (InterruptedException e) {
            log.debug("Поток был прерван во время ожидания");
            Thread.currentThread().interrupt();
            throw new RuntimeException("Поток был прерван во время ожидания", e);
        }

        CompletableFuture.supplyAsync(() -> player)
                .thenAccept(player1 -> {
                    synchronized (lock) {
                        int level = player1.getLevel();
                        player1.setLevel(++level);
                        log.info("Уровень игрока {} повышен, квест {} пройден", player1.getName(), quest.name());

                        int experience = player1.getExperience() + quest.reward();
                        player1.setExperience(experience);
                        log.info("Опыт игрока {} составляет {}", player1.getName(), player1.getExperience());
                    }
                })
                .exceptionally(ex -> {
                    log.debug("Вовремя выполнения квеста возникла ошибка", ex);
                    return null;
                });
        return CompletableFuture.supplyAsync(() -> player);
    }
}
