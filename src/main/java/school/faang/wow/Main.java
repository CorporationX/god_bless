package school.faang.wow;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Артур", 1, 50);
        Player player2 = new Player("Леон", 2, 120);

        Quest quest1 = new Quest("Охота на гоблинов", 2, 150);
        Quest quest2 = new Quest("Спасение деревни", 3, 200);

        CompletableFuture<Player> future1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> future2 = questSystem.startQuest(player2, quest2);

        for (CompletableFuture<Player> playerCompletableFuture : Arrays.asList(future1, future2)) {
            playerCompletableFuture.thenAccept(player -> logger.info("Результат: {}", player));
        }

        future1.join();
        future2.join();

        questSystem.shutdown();
    }
}
