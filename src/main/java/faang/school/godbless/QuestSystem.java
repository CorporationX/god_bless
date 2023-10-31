package faang.school.godbless;

import java.util.concurrent.CompletableFuture;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest){
        return CompletableFuture.supplyAsync(() -> {
           try{
               Thread.sleep(100L * quest.getDifficulty());

           } catch (InterruptedException e){
               e.printStackTrace();
           }
            return player;
        });
    }
}
