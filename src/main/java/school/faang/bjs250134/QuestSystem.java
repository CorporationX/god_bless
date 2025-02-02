package school.faang.bjs250134;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        Player copyPlayer = new Player(player.getName(), player.getLevel(), player.getExperience());
        return CompletableFuture.supplyAsync(() -> {
            System.out.println(copyPlayer.getName() + " start execute quest " + quest.getName());
            try {
                if (quest.getDifficulty() > 5) {
                    Thread.sleep(8000);
                    copyPlayer.setExperience(100 + copyPlayer.getExperience());
                } else {
                    Thread.sleep(4000);
                    copyPlayer.setExperience(10 + copyPlayer.getExperience());
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " is interrupted");
            }
            return copyPlayer;
        });
    }
}
