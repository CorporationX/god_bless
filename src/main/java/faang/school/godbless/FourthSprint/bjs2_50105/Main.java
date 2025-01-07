package faang.school.godbless.FourthSprint.bjs2_50105;


import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

        Player player1 = new Player("Thrall", 10, new AtomicInteger(250));
        Player player2 = new Player("Sylvanas", 12, new AtomicInteger(450));

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1, executor);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2, executor);

        player1Quest.thenAccept(player -> System.out.println(player.getName()
                + " has completed the quest and now has "
                + player.getExperience()
                + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName()
                + " has completed the quest and now has "
                + player.getExperience()
                + " experience points."));
        CompletableFuture.allOf(player1Quest, player2Quest).join();
        executor.shutdown();
    }
}

