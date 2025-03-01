package school.faang.wow;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        List<Player> players = List.of(
                new Player("Arthas", 5, 100),
                new Player("Sargeras", 10, 200)
        );

        List<Quest> quests = List.of(
                new Quest("Up and up", 8, 100),
                new Quest("Sparks of luck", 9, 150)
        );

        List<CompletableFuture<Player>> futures = List.of(
                questSystem.startQuest(players.get(0), quests.get(0)),
                questSystem.startQuest(players.get(1), quests.get(1))
        );

        futures.forEach(future -> future.thenAccept(player ->
                System.out.printf("%s has completed the quest and now has %d experience points.%n", player.getName(),
                        player.getExperience())));

        futures.forEach(CompletableFuture::join);
        questSystem.shutdown();
    }
}
