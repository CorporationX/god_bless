package school.faang.wow;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", DifficultyType.HARD, RewardType.SILVER);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", DifficultyType.MEDIUM, RewardType.GOLD);

        CompletableFuture<Player> questForPlayer1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> questForPlayer2 = questSystem.startQuest(player2, quest2);

        questForPlayer1.thenAccept(player -> System.out.printf("%d has completed the quest and now has" +
                " %d experience points.", player.getName(), player.getExperience()));
        questForPlayer2.thenAccept(player -> System.out.printf(" %d has completed the quest and now has " +
                "%d experience points.", player.getName(), player.getExperience()));
        CompletableFuture.allOf(questForPlayer1, questForPlayer2)
                .thenRun(() -> System.out.println("Completed"))
                .join();
    }
}
