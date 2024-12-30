package school.faang.bjs250377;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public static final int WORK_TIME = 1000;
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println(quest.getDifficulty());
                Thread.sleep(quest.getDifficulty() * WORK_TIME);
            } catch (InterruptedException ex) {
                log.error("The task has been aborted!{}", String.valueOf(ex));
                Thread.currentThread().interrupt();
                throw new RuntimeException(ex);
            }
            player.addExperience(quest.getReward());
            return player;
        });
    }
}
