package async.two;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        System.out.println(player.getName() + " start quest " + quest.getName());
        return CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Quest execution was interrupted", e);
            }

            player.setExperience(player.getExperience() + quest.getReward());
            if (player.getExperience() > Player.EXPERIENCE_TO_LEVEL_UP) {
                player.setLevel(player.getLevel() + 1);
                System.out.println(player.getName() + " Level up! Level: " + player.getLevel());
            }
            return player;
        });
    }
}
