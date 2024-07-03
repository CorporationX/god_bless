package faang.school.godbless.BJS2_13889;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player , Quest quest){
        CompletableFuture<Player> players = new CompletableFuture<>();

        new Thread(() -> {
            try{
                System.out.println("Task " + quest.getName() + " is perform " + player.getName());
                Thread.sleep(quest.getDifficulty() * 1000);
                int newExperience = player.getExperience() + quest.getReward();
                player.setExperience(newExperience);
                players.complete(player);
            } catch (InterruptedException e){
                players.completeExceptionally(e);
            }
        }).start();
        return players;
    }
}
