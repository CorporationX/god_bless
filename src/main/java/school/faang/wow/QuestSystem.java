package school.faang.wow;

import java.util.Objects;

public class QuestSystem {
    private static final int TIME_EXECUTION_PER_DIFFICULTY = 1000;
    private static final int TIME_REDUCING_PER_LEVEL = 100;

    public void startQuest(Player player, Quest quest) throws InterruptedException {
        validateParams(player, quest);
        imitateExecutionQuest(player, quest);
        player.setScore(player.getScore() + quest.reward());
    }

    private void imitateExecutionQuest(Player player, Quest quest) throws InterruptedException {
        int timeExecution = quest.difficulty() * TIME_EXECUTION_PER_DIFFICULTY
                - player.getLevel() * TIME_REDUCING_PER_LEVEL;
        if (timeExecution < 0) {
            timeExecution = 0;
        }
        Thread.sleep(timeExecution);
    }

    private void validateParams(Player player, Quest quest) {
        Objects.requireNonNull(player, "Invalid player value");
        Objects.requireNonNull(quest, "Invalid quest value");
    }
}
