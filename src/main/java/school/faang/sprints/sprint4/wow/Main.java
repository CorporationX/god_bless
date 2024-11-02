package school.faang.sprints.sprint4.wow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        QuestSystem questSystem = new QuestSystem(executorService);

        int n = 100;
        List<Player> players = generatePlayers(n);
        List<Quest> quests = generateQuests(n);

        Map<Player, Quest> questsForPlayers = randomizeQuestsForPlayers(players, quests);

        List<CompletableFuture<Void>> startedQuests = questsForPlayers.entrySet()
                .stream()
                .map((entry) -> questSystem.startQuest(entry.getKey(), entry.getValue())
                        .thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."))
                )
                .toList();

        try {
            CompletableFuture.allOf(startedQuests.toArray(new CompletableFuture[0])).get();
        } catch (InterruptedException e) {
            e.printStackTrace();
            throw new QuestCompleteException("Quest was interrupted");
        } catch (ExecutionException e) {
            e.printStackTrace();
            throw new QuestCompleteException("ExecutionException while trying to complete quest");
        } finally {
            executorService.shutdown();
        }
    }

    private static List<Player> generatePlayers(int n) {
        AtomicInteger i = new AtomicInteger();
        Random random = new Random();

        return Stream.generate(() -> new Player("player_" + i.getAndIncrement(), random.nextInt(100), random.nextInt(1000)))
                .limit(n)
                .toList();
    }

    private static List<Quest> generateQuests(int n) {
        AtomicInteger i = new AtomicInteger();
        Random random = new Random();

        return Stream.generate(() -> new Quest("quest_" + i.getAndIncrement(), random.nextInt(51), random.nextInt(1000)))
                .limit(n)
                .toList();
    }

    private static Map<Player, Quest> randomizeQuestsForPlayers(List<Player> players, List<Quest> quests) {
        Map<Player, Quest> result = new HashMap<>();
        Random random = new Random();
        for (Player player : players) {
            Quest quest = quests.get(random.nextInt(quests.size()));
            result.put(player, quest);
        }
        return result;
    }

    static class QuestCompleteException extends RuntimeException {

        public QuestCompleteException(String message) {
            super(message);
        }
    }
}
