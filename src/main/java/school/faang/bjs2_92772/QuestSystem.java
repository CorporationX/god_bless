package school.faang.bjs2_92772;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final long MLS_IN_SEC = 1_000;

    static CompletableFuture<Player> startQuest(Player player, Quest quest) {
        synchronized (player.getLock()) {
            log.debug("Игрок {} с опытом {} баллов приступает к квесту {}.",
                    player.getName(), player.getExperience(), quest.getName());
            return CompletableFuture.supplyAsync(() -> {
                player.setExperience(player.getExperience() + quest.getReward());
                try {
                    Thread.sleep(quest.getDifficulty() * MLS_IN_SEC);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                return player;
            });
        }
    }
}
