package derschrank.sprint04.task02.bjstwo_50097;

import java.util.concurrent.CompletableFuture;
import java.util.function.Supplier;

public class QuestSystem implements QuestSystemInterface {
    private static final int DEFAULT_SLEEP = 1000;

    @Override
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        Supplier<Player> callableQuest = () -> {
            float coefficient = (float) quest.difficulty() / player.getLevel();
            mySleep(DEFAULT_SLEEP * coefficient);

            int reward = (int) (quest.reward() * (1 + coefficient) / 2);
            printStatusOfPlayerAndQuest(player, quest, reward);
            player.addExperience(reward);
            return player;
        };

        return CompletableFuture.supplyAsync(callableQuest);
    }

    public void mySleep(Number delay) {
        try {
            Thread.sleep(delay.longValue());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void printStatusOfPlayerAndQuest(Player player, Quest quest, int reward) {
        System.out.printf("%s has played quest: %s, and became experience: %d%n", player, quest, reward);
    }
}
