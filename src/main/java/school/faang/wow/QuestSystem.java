package school.faang.wow;

import lombok.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;
import java.util.concurrent.CompletableFuture;

/**
 * Проект: god_bless
 * Класс QuestSystem
 * Автор: Vital
 */

public class QuestSystem {
    private static final Logger log = LoggerFactory.getLogger(QuestSystem.class);
    private static final int MS_IN_SECOND = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        Objects.requireNonNull(player, "Игрок не может быть null");
        Objects.requireNonNull(quest, "Квест не может быть null");

        quest.start();

        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("{} выполняет квест \"{}\"", player.getName(), quest.getName());
                Thread.sleep((long) quest.getDifficulty() * MS_IN_SECOND);
            } catch (InterruptedException e) {
                log.error("Квест \"{}\" был прерван для игрока {}", quest.getName(), player.getName(), e);
                Thread.currentThread().interrupt();
            }
            player.addExperience(quest.getReward());
            player.tryLevelUp(); //автоматическое повышение уровня
            log.info("Игрок {} завершил квест \"{}\"", player.getName(), quest.getName());
            return player;
        });
    }
}