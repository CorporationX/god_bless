package faang.school.godbless.task.multithreading.async.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    private static final int NUMBER_OF_PLAYERS = 5;
    private static final int THREAD_POOL_SIZE = NUMBER_OF_PLAYERS;

    private static final QuestPlayerFabric fabric = new QuestPlayerFabric(NUMBER_OF_PLAYERS);
    private static final QuestSystem questSystem = new QuestSystem(THREAD_POOL_SIZE);
    private static final List<CompletableFuture<Player>> futures = new ArrayList<>();
    private static List<Player> players;
    private static List<Quest> quests;

    public static void main(String[] args) {
        initDefault();
        startQuests();
        printResults();
        questSystem.shutdownExecutor();
    }

    private static void initDefault() {
        players = fabric.getPlayers();
        quests = fabric.getQuests();
    }

    private static void startQuests() {
        futures.addAll(runTask());
    }

    private static List<CompletableFuture<Player>> runTask() {
        return IntStream
                .range(0, NUMBER_OF_PLAYERS)
                .mapToObj(i -> questSystem.startQuest(players.get(i), quests.get(i)))
                .toList();
    }

    private static void printResults() {
        futures.forEach(Main::printPlayerResult);
    }

    private static void printPlayerResult(CompletableFuture<Player> future) {
        future.thenAccept(player -> log.info("{}  has completed the quest and now has {} experience points.",
                player.getName(), player.getExperience()));
    }
}
