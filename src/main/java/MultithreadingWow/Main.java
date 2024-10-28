package MultithreadingWow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int NUM_OF_OBJECTS = 3;

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        List<Player> players = new ArrayList<>();
        List<Quest> quests = new ArrayList<>();

        for (int i = 0; i < NUM_OF_OBJECTS - 1; i++) {
            players.add(new Player("Player" + i, i * 10, i * 9 + 1));
            quests.add(new Quest("Quest" + i, i * 8, i * 12));
            CompletableFuture<Player> futurePlayerQuest = questSystem.startQuest(players.get(i), quests.get(i));
            futurePlayerQuest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points."));
            futurePlayerQuest.join();
        }
    }
}
