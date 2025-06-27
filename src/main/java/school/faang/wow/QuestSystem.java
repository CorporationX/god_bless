package school.faang.wow;

import lombok.extern.slf4j.Slf4j;
import school.faang.wow.domain.Player;
import school.faang.wow.domain.Quest;
import school.faang.wow.exception.QuestExecutionException;

import java.util.concurrent.CompletableFuture;

/**
 * @author Danil Pudovkin
 * @since 26.06.2025
 */
@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            player.incrementExperience(quest.reward());
            try {
                Thread.sleep(quest.difficulty());
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new QuestExecutionException(quest, e);
            }
            log.info("Игрок {} получил {} единиц опыта", player.getName(), quest.reward());
            return player;
        });
    }
}
