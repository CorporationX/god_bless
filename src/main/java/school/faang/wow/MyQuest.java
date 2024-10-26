package school.faang.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyQuest {
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(2);
        QuestSystem system = new QuestSystem();
        CompletableFuture<Player> future1 = system.startQuest(new Player("Maks", 1), new Quest("Warships", 5, 100), service);
        CompletableFuture<Player> future2 = system.startQuest(new Player("Rusik", 2), new Quest("World of Tanks", 3, 150), service);
        future1.join();
        future2.join();
        future1.thenAccept(Player::showPlayer);
        future2.thenAccept(Player::showPlayer);
        service.shutdown();
    }
}
