package faang.school.godbless.wow;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Consumer;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        QuestSystem questSystem = new QuestSystem();

        Consumer<Player> consumer = (player) -> System.out.printf("%s has completed the quest and now on %d level with %d experience points\n", player.getName(), player.getLevel(), player.getExperience());

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
        Player player3 = new Player("Player3", 22, 900);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);
        Quest quest3 = new Quest("Do something hard", 10, 900);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);
        CompletableFuture<Player> player3Quest = questSystem.startQuest(player3, quest3);


        player1Quest.thenAccept(consumer);
        player2Quest.thenAccept(consumer);
        player3Quest.thenAccept(consumer);

        questSystem.getExecutorService().shutdown();
    }
}
