package school.faang.bjs2_82245;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static school.faang.bjs2_82245.QuestDifficulty.EASY;
import static school.faang.bjs2_82245.QuestDifficulty.HARD;

@Slf4j
public class Main {
    private static final int NUM_THREAD = 4;
    private static final int TIMEOUT = 10;

    public static void main(String[] args) {
        ExecutorService poolThread = Executors.newFixedThreadPool(NUM_THREAD);
        QuestSystem questSystem = new QuestSystem(poolThread);

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", EASY, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", HARD, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));
        player2Quest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has "
                + player.getExperience() + " experience points."));

        breakPoolThread(poolThread);
    }

    public static void breakPoolThread(ExecutorService poolThread) {
        poolThread.shutdown();
        try {
            if (!poolThread.awaitTermination(TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Досрочное завершение работы потоков");
                poolThread.shutdownNow();
            }
        } catch (InterruptedException e) {
            poolThread.shutdownNow();
        }
    }
}
