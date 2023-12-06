package faang.school.godbless.WoW;

import java.util.concurrent.CompletableFuture;

public class Play {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        // Players creation
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        // Quests creation
        Quest quest1 = new Quest("Defeat the Lich King", EDifficulty.HARD, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", EDifficulty.NORMAL, 100);

        // Quests execution
        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        // Results processing
        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
    }
}
