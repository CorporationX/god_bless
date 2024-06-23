package faang.school.godbless.async.wow;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Name 1", 500);
        Player player2 = new Player("Name 2", 100);

        Quest quest1 = new Quest("Quest 1", 5, 1000);
        Quest quest2 = new Quest("Quest 2", 3, 800);

        CompletableFuture<Player> player1Quest1 = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest2 = questSystem.startQuest(player2, quest2);
        CompletableFuture<Player> player1Quest2 = questSystem.startQuest(player1, quest2);

        Consumer<Player> printResults = player ->
                System.out.printf("Player [%s] has completed the quest " +
                        "and now has %d experience points.\n", player.getName(), player.getExp());

        player1Quest1.thenAccept(printResults);
        player2Quest2.thenAccept(printResults);
        player1Quest2.thenAccept(printResults);

        player1Quest1.join();
        player2Quest2.join();
        player1Quest2.join(); //todo: почему без джойнов не работает?
    }
}
