package school.faang.bjs2_92585;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    private static final int COUNT_THREADS = 4;
    private static final int PLAYER_ONE_LEVEL = 10;
    private static final int PLAYER_TWO_LEVEL = 12;
    private static final int PLAYER_ONE_EXPERIENCE = 250;
    private static final int PLAYER_TWO_EXPERIENCE = 450;
    private static final int QUEST_ONE_DIFFICULTY = 10;
    private static final int QUEST_TWO_DIFFICULTY = 8;
    private static final int QUEST_ONE_REWARD = 150;
    private static final int QUEST_TWO_REWARD = 100;
    private static final ExecutorService executor = Executors.newFixedThreadPool(COUNT_THREADS);

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", PLAYER_ONE_LEVEL, new AtomicInteger(PLAYER_ONE_EXPERIENCE));
        Player player2 = new Player("Sylvanas", PLAYER_TWO_LEVEL, new AtomicInteger(PLAYER_TWO_EXPERIENCE));

        Quest quest1 = new Quest("Defeat the Lich King", QUEST_ONE_DIFFICULTY, QUEST_ONE_REWARD);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", QUEST_TWO_DIFFICULTY, QUEST_TWO_REWARD);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1, executor);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2, executor);

        player1Quest.thenAccept(Main::accept);
        player2Quest.thenAccept(Main::accept);

        shutdown();
    }

    private static void accept(Player player) {
        log.info("{} has completed the quest and now has {} experience points.",
                player.getName(), player.getExperience());
    }

    private static void shutdown() {
        executor.shutdown();

        try {
            if (!executor.awaitTermination(1, TimeUnit.MINUTES)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}
