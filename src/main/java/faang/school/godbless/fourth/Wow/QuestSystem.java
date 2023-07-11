package faang.school.godbless.fourth.Wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    private static final int SECOND_MILLIS = 1000;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                if (quest.difficulty() == Difficulty.EASY) {
                    Thread.sleep(SECOND_MILLIS);
                } else if (quest.difficulty() == Difficulty.MEDIUM) {
                    Thread.sleep(2 * SECOND_MILLIS);
                } else if (quest.difficulty() == Difficulty.HARD) {
                    Thread.sleep(3 * SECOND_MILLIS);
                }
            } catch (InterruptedException e) {
                System.out.println("Thread has been interrupted");
                return null;
            }
            player.earnExperience(quest.reward());
            return player;
        });
    }
}
