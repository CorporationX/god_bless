package multithreading_part2.wow;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest){
        CompletableFuture<Player> playerCompletableFuture = CompletableFuture.supplyAsync(() -> {
            System.out.println(player.getName() + " начал выполнять задание " + quest.getName());
            try {
                Thread.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(player.getName() + " закончил выполнять задание " + quest.getName());
            player.setExperience(player.getExperience() + quest.getReward());
            player.setLevel(player.getLevel() + 1);
            return player;
        });
        return playerCompletableFuture;
    }
}
