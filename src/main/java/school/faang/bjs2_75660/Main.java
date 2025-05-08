package school.faang.bjs2_75660;

import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        Player player = new Player("Join", 12, 124);
        Player player2 = new Player("Alice", 18, 329);
        Quest quest = new Quest("1", 5, 46);
        Quest quest2 = new Quest("2", 8, 89);
        QuestSystem questSystem = new QuestSystem();
        CompletableFuture<Player> playerQuest = questSystem.startQuest(player, quest);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);
        playerQuest.thenAccept(play -> System.out.println(play.getName() +
                " has completed the quest and now has " + play.getExperience() +
                " experience points.")).join();
        player2Quest.thenAccept(play -> System.out.println(play.getName() +
                " has completed the quest and now has " + play.getExperience() +
                " experience points.")).join();
        questSystem.shutDown();
    }
}
