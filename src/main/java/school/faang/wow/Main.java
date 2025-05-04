package school.faang.wow;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        List<CompletableFuture<Player>> allFutureTasks = List.of(
                questSystem.startQuest(player1, quest1),
                questSystem.startQuest(player2, quest2)
        );
        CompletableFuture.allOf(allFutureTasks.toArray(new CompletableFuture[0]))
                .thenRun(() ->
                        allFutureTasks.forEach(task -> {
                            Player player = task.join();
                            System.out.printf("%s has completed the quest and now has %d experience points\n",
                                    player.getName(), player.getExperience());
                        })
                )
                .exceptionally(ex -> {
                    System.err.println("Task execution error" + ex.getCause());
                    return null;
                }).join();
        questSystem.close();
    }
}
