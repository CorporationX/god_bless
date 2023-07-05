package faang.school.godbless.Sprint_5.Multithreading_Async.WOW;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public static CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            System.out.printf("Player - %s is compleating quest - %s now\n", player.getName(), quest.getName());

            try {
                Thread.sleep(3_000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            player.setExperience(player.getExperience() + quest.getReward());

            return player;
        });
    }
}
