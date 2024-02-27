package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String... args) {
        QuestSystem questSystem = new QuestSystem();
        Player player1 = new Player("Terminator", 5, 15L);
        Player player2 = new Player("Robocop", 7, 12L);
        Quest quest1 = new Quest("Destroy all humans", 10, 6000000L);
        Quest quest2 = new Quest("To serve and protect", 5, 100000L);
        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

// Обработка результатов заданий
        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));

    }
}
