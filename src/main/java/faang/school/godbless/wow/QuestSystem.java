package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        System.out.println("Player " + player.getName() + " started quest: " + quest.getName());

        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L); // иммитирую прохождение квеста таймером
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

            player.setExperience(player.getExperience() + quest.getDifficulty());

            return player;
        });
    }
}
