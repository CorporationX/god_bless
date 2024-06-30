package faang.school.godbless.BJS2_13889;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Supplier;

public class QuestSystem {

    public CompletableFuture<Player> startQuest(Player player , Quest quest){
        return CompletableFuture.supplyAsync(() -> {
            try{
                System.out.println("Task is starting");
                Thread.sleep(quest.difficulty() * 1000);
                player.setExperience(player.experience() + quest.reward());
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            return player;
        });
    }
}
