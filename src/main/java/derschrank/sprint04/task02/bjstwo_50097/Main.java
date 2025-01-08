package derschrank.sprint04.task02.bjstwo_50097;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
        List<Player> players = List.of(player1, player2);

        List<Quest> quests = getQuests();
        List<CompletableFuture<Void>> futures = new LinkedList<>();
        for (Quest quest : quests) {
            for (Player player : players) {
                CompletableFuture<Player> future = questSystem.startQuest(player, quest);
                futures.add(future.thenAccept(p -> System.out.println(p.getName()
                        + " has completed the quest and now has "
                        + p.getExperience() + " experience points."))
                );
            }
        }

        futures.forEach(CompletableFuture::join);
    }

    private static List<Quest> getQuests() {
        List<Quest> quests = new ArrayList<>();
        quests.add(new Quest("Defeat the Lich King", 10, 150));
        quests.add(new Quest("Defeat the King Lich", 11, 150));
        quests.add(new Quest("Defeat the Lich Lich King", 12, 150));
        quests.add(new Quest("Defeat the King King Lich", 13, 150));
        quests.add(new Quest("Defeat the Lich * King", 14, 250));
        quests.add(new Quest("Retrieve the Sword of Azeroth", 8, 100));
        quests.add(new Quest("Retrieve the Sword of Lich", 7, 100));
        quests.add(new Quest("Retrieve the Sword of King", 6, 100));
        quests.add(new Quest("Retrieve the Sword of Defeat", 5, 100));
        quests.add(new Quest("Retrieve the Sword of King Azeroth", 9, 200));
        return quests;
    }
}
