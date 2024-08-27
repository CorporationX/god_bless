package faang.school.godbless.BJS2_24950;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final String COMPLETE_QUEST_MESSAGE = "%s complete quest and now has %d exp\n";

    public static void main(String[] args) {

        QuestSystem system = new QuestSystem();

        Player playerOne = new Player("Thrall", 10, 250);
        Player playerTwo = new Player("Sylvanas", 12, 450);

        Quest questOne = new Quest("Defeat the Lich King", 20, 150);
        Quest questTwo = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> playerOneQuest = system.startQuest(playerOne, questOne);
        CompletableFuture<Player> playerTwoQuest = system.startQuest(playerTwo, questTwo);

        List.of(playerOneQuest, playerTwoQuest)
                .forEach(result ->
                        result.thenAccept(player ->
                                System.out.printf(COMPLETE_QUEST_MESSAGE, player.getName(), player.getExp())));

        playerOneQuest.join();
        playerTwoQuest.join();
    }
}
