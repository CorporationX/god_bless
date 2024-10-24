package school.faang.Multithreading.sprint_4.Wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest){
        CompletableFuture<Player> futureQuest = CompletableFuture.supplyAsync(() ->{

            try {
                Thread.sleep(1000L * quest.getDifficulty());
            } catch (InterruptedException e) {
                log.error("Операция была прервана", e);
                throw new RuntimeException(e);
            }

            player.addExperience(quest.getReward());

            return player;
        });
        return futureQuest;
    }


}
