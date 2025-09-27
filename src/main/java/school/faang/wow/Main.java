package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Арья", 1, 0);
        Player player2 = new Player("Джон", 2, 10);

        Quest quest1 = new Quest("quest1", 2, 50);
        Quest quest2 = new Quest("quest2", 3, 100);

        QuestSystem questSystem = new QuestSystem();

        CompletableFuture<Player> future1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> future2 = questSystem.startQuest(player2, quest2);

        future1.thenAccept(player ->
                log.info("{} завершил квест. Опыт: {}", player.getName(), player.getExperience())
        );

        future2.thenAccept(player ->
                log.info("{} завершил квест. Опыт: {}", player.getName(), player.getExperience())
        );

        CompletableFuture.allOf(future1, future2).join();
    }
}
