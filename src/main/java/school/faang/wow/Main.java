package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Slf4j
public class Main {
    private static final QuestSystem QUEST_SYSTEM = new QuestSystem();
    private static final List<Player> PLAYERS = List.of(
            new Player("Max", 3, 100),
            new Player("Semen", 50, 250500),
            new Player("Alexandra", 6, 1000),
            new Player("Igor", 15, 1500),
            new Player("Elena", 23, 2500)
    );
    private static final List<Quest> QUESTS = List.of(
            new Quest("Kill 10 bears", 7, 1000),
            new Quest("Pass the game", 20, 1000000),
            new Quest("Collect 15 flowers", 7, 3000),
            new Quest("Collect 100 notes", 10, 30000),
            new Quest("Kill 5 rats", 3, 100)
    );
    private static final Random RANDOM = new Random();

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<?>[] futures = PLAYERS.stream()
                .map(player -> CompletableFuture.runAsync(() -> {
                    try {
                        QUEST_SYSTEM.startQuest(player, QUESTS.get(RANDOM.nextInt(QUESTS.size())));
                    } catch (InterruptedException exception) {
                        log.error("Execution tasks is failed. Name thread: {}\nException: {}\nStack trace: {}",
                                Thread.currentThread().getName(), exception, exception.getStackTrace());
                        Thread.currentThread().interrupt();
                    }
                }).thenRun(() -> log.info("Name: {}, score: {}", player.getName(), player.getScore())))
                .toArray(CompletableFuture[]::new);

        CompletableFuture.allOf(futures).get();
    }
}
