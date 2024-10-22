package school.faang.wow_BJS2_38459;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
        List<Player> players = new ArrayList<>(Arrays.asList(player1, player2));

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        CompletableFuture.allOf(player1Quest, player2Quest)
                .thenRun(() -> players.forEach(player ->
                        System.out.printf("%s has completed the quest and now has %d experience points.\n",
                                player.getName(), player.getExperience())));
    }
}
