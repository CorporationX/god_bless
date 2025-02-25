package school.faang.sprint4.task_63939;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.IntFunction;
import java.util.stream.IntStream;

public class Main {
    private static final ExecutorService EXECUTOR = Executors.newFixedThreadPool(3);
    private static final int MIN_REWARD = 50;
    private static final int QUEST_COUNT = 5;
    private static final int PLAYER_COUNT = 5;
    private static final int MAX_QUESTS_TIME_SEC = 15;
    private static final List<Player> players = generateObjects(PLAYER_COUNT, num -> new Player("Player" + num));
    private static final List<Quest> quests = generateObjects(QUEST_COUNT, num ->
            new Quest("Quest" + num, num, num * MIN_REWARD));

    private static  <T> List<T> generateObjects(int count, IntFunction<T> mapper) {
        return IntStream.rangeClosed(1, count)
                .mapToObj(mapper)
                .toList();
    }

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        quests.forEach(quest ->
                players.forEach(player ->
                        questSystem.startQuest(player, quest, EXECUTOR)
                                .thenAccept(Main::printPlayer)
        ));

        closeExecutor();
    }

    private static void printPlayer(Player player) {
        System.out.printf("%s has completed the quest and now has  %s experience points.\n",
                player.getName(), player.getExperience());
    }

    private static void closeExecutor() {
        EXECUTOR.shutdown();

        try {
            if (!EXECUTOR.awaitTermination(MAX_QUESTS_TIME_SEC, TimeUnit.SECONDS)) {
                EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            EXECUTOR.shutdownNow();
        }
    }
}
