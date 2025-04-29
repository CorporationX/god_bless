package school.faang.stream4.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {

        return CompletableFuture.supplyAsync(() -> {
            log.info("Player {} start performing quest {}", player.getName(), quest.name());
            delayQuestPerformance(quest);
            int initExp = player.getExperience();
            player.setExperience(initExp + quest.reward());
            log.info("Player {} finished his quest {} and got reward", player.getName(), quest.name());
            return player;
        });
    }

    private void delayQuestPerformance(Quest quest) {
        try {
            Thread.sleep(quest.difficulty() * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
