package school.faang.wowtask_50213;

import java.util.concurrent.CompletableFuture;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QuestSystem {
    private static final Logger LOG = Logger.getLogger(QuestSystem.class.getName());

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        CompletableFuture<Player> thisQuest = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 500);
            } catch (InterruptedException e) {
                LOG.info("Исключение: " + e);
                Thread.currentThread().interrupt();
            }
            player.setExperience(player.getExperience() + quest.getReward());
            player.setLevel(quest.getDifficulty() / 10);
            System.out.printf("Квест %s завершен. Игрок %s набрал %d опыта \n", quest.getQuestName(), player.getName(),
                    player.getExperience());
            return player;
        });
        return thisQuest;
    }
}

