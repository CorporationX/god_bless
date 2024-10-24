package school.faang.wow;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@AllArgsConstructor
@Getter
public class Quest {
    private String name;
    private int difficulty;
    private int reward;

    public void executeQuest(Player player) {
        try {
            log.info("Quest " + name + " started by player " + player.getName());
            Thread.sleep(difficulty * 1000L);
            player.addExperience(reward);
            log.info("Quest " + name + " completed by player " + player.getName() + ". Player gained " + reward + " points of experience.");
        } catch (InterruptedException e) {
            log.error("Thread has been interrupted during quest " + name + " for the player " + player.getName(), e);
            Thread.currentThread().interrupt();
            throw new RuntimeException("Quest execution was interrupted", e);
        }
    }
}