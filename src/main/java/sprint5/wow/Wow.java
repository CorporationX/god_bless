package sprint5.wow;

import java.util.concurrent.CompletableFuture;

public class Wow {
    private static final String COMPLETE_QUEST = "%s has completed the quest and now has %d experience points.\n";
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        CompletableFuture<Void> player1Result = player1Quest.thenAccept(player ->
                System.out.printf(COMPLETE_QUEST, player.getName(), player.getExperience()));
        CompletableFuture<Void> player2Result = player2Quest.thenAccept(player ->
                System.out.printf(COMPLETE_QUEST, player.getName(), player.getExperience()));

        player1Result.join();
        player2Result.join();
    }
}
