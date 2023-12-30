package faang.school.godbless.WOW;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest){
        return CompletableFuture.supplyAsync(() -> {
            System.out.println("Iгрок " + player.getName() + " начал прохождение " + quest.getName());
            try {
                Thread.sleep(quest.getDifficult()* 1000L);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            player.setExperience(player.getExperience() + quest.getReward());
            System.out.println("Iгрок " + player.getName()+ "получил награду" + quest.getReward() + "за прохождение квеста" + quest.getName());
            return player;
        });
    }
}
