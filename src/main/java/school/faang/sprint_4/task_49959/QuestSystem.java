package school.faang.sprint_4.task_49959;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        if (player == null || quest == null) {
            throw new IllegalArgumentException("Входные параметры не могут быть null");
        }

        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("Ожидание завершение квеста {} игроком {}...", quest.name(), player.getName());
                Thread.sleep(quest.difficulty().getTimeToComplete());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                log.error("Поток прерван во время ожидания завершения квеста");
            }
            player.addExperience(quest.reward());
            return player;
        });
    }
}
