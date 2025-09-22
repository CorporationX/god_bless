package school.faang.bjs2_92547;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    public static final int DEFAULT_SLEEP = 2000;
    public static final int EXP_COEFFICIENT = 100;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> future = CompletableFuture.supplyAsync(() -> {
            synchronized (player) {
                sleepingThread(quest.getDifficulty());
                player.setExperience(player.getExperience() + quest.getDifficulty() * EXP_COEFFICIENT);
                log.info("квест {} завершен игроком {}. Награда - {}", quest.getName(), player, quest.getReward());
            }
            return player;
        });
        return future;
    }

    private void sleepingThread(int coef) {
        try {
            Thread.sleep(DEFAULT_SLEEP * coef);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
