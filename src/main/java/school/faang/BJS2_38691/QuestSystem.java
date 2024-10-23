package school.faang.BJS2_38691;

import java.awt.event.ComponentListener;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import  org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuestSystem {
    private static final int THREADS_NUMBER = 2;
    private static final Logger logger = LoggerFactory.getLogger(QuestSystem.class);

    ExecutorService executor = Executors.newFixedThreadPool(THREADS_NUMBER);

    public QuestSystem() {}

    public CompletableFuture<Player> startQuest(Player player, Quest quest){
        return CompletableFuture.supplyAsync(() -> {
            int playerExperience = player.getExperience();
            int questExperience = quest.getReward();

            try {
                logger.info("Игрок {} начал квест {}", player.getName(), quest.getName());
                Thread.sleep(quest.getDifficulty() * 1000);
                player.setExperience(playerExperience + questExperience);
                logger.info(
                        "Игрок {} завершил квест {} и получил {} опыта",
                        player.getName(),
                        quest.getName(),
                        quest.getReward()
                );
            } catch (Exception e) {
                logger.error("Ошибка при выполнении квеста '{}': {}", quest.getName(), e.getMessage(), e);
            }
            return player;
        },executor);
    }

    public void shutdown(){
        try {
            executor.shutdown();
        } catch (Exception e){
            logger.error("Ошибка завершения потоков {}", e.getMessage(),e);
            executor.shutdownNow();
        }
    }
}
