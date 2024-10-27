package school.faang.BJS238542;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        List<Player> players = List.of(
                new Player("Thrall", 10, 250),
                new Player("Sylvanas", 12, 450));

        List<Quest> quests = List.of(
                new Quest("Defeat the Lich King", 10, 150),
                new Quest("Retrieve the Sword of Azeroth", 8, 100)
        );

        List<CompletableFuture<Player>> playerQuests = new ArrayList<>();

        for (int i = 0; i < quests.size(); i++) {
            playerQuests.add(questSystem.startQuest(players.get(i), quests.get(i)));
        }

        for (CompletableFuture<Player> playerQuest : playerQuests) {
            playerQuest.thenAccept(player -> System.out.println(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points.")).join();
        }

    }
}
