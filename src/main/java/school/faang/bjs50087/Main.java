package school.faang.bjs50087;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        List<CompletableFuture<Player>> completedQuests = initQuests(questSystem);

        completedQuests
                .forEach(CompletableFuture::join);
    }

    private static List<CompletableFuture<Player>> initQuests(QuestSystem questSystem) {
        List<CompletableFuture<Player>> completedQuests = new ArrayList<>();

        Player player1 = new Player("Alex", 0);
        Player player2 = new Player("Jordan", 0);

        Quest quest1 = new Quest("Bro force", 3, 40);
        Quest quest2 = new Quest("Dragon Slayer", 5, 100);
        Quest quest3 = new Quest("Treasure Hunt", 2, 30);

        completedQuests.add(questSystem.startQuest(player1, quest1));
        completedQuests.add(questSystem.startQuest(player2, quest2));
        completedQuests.add(questSystem.startQuest(player1, quest3));
        completedQuests.add(questSystem.startQuest(player2, quest1));
        return completedQuests;
    }
}
