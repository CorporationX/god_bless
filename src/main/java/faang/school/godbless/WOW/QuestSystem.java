package faang.school.godbless.WOW;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class QuestSystem {
    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        return CompletableFuture.supplyAsync(() ->{
            Player player1 = quest.start(player);
            service.shutdown();
            return player1;
        }, service );
    }
}
