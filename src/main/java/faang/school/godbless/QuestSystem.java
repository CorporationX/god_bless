package faang.school.godbless;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
@Slf4j
public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest){
       return CompletableFuture.supplyAsync(()->{
            try {
                log.info("" + player.name + "performing quest " + quest.name + " and sleeping " + quest.experience);
                Thread.sleep(quest.experience);
                return player;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
    }
}
