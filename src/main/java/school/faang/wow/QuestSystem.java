package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public static CompletableFuture<Player> startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("игрок {} приступил к выполнению задания {}", player.getName(), quest.name());
                Thread.sleep(quest.difficulty() * 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException("Error!!!!!!!!!!!!");
            }
            log.info("игрок {} выполнил задание {} и получил {} опыта", player.getName(), quest.name(), quest.reward());
            player.addExp(quest.reward());
            return player;
        });
    }
}
