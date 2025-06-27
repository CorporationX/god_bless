package school.faang.bjs2_82288;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    private static final int SLEEP_TIME = 5000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(SLEEP_TIME);
                player.setExperience(quest.getReward() * quest.getDifficulty() + player.getExperience());
                return player;
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                log.error("поток прерван при выполнении квеста");
                throw new RuntimeException(e);
            }
        });
    }
}
