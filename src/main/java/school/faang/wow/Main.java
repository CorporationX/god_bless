package school.faang.wow;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

public class Main {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        List<Player> players = new ArrayList<>();
        for (int i=0; i<100; i++) {
            players.add(new Player("Player" + i));
        }
        List<Quest> quests = List.of(
                new Quest("Defeat the Lich King", 10, 150),
                new Quest("Retrieve the Sword of Azeroth", 8, 100)
        );

        Random random = new Random();
        List<CompletableFuture<Player>> futures = players.stream()
                .map(player -> {
                    Quest randomQuest = quests.get(random.nextInt(quests.size()));
                    System.out.println(player.getName() + " has started quest: " + randomQuest.getName());
                    return questSystem.startQuest(player, randomQuest);
                }).toList();

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .join();
    }
}
