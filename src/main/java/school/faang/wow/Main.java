package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        List<CompletableFuture<Player>> runningQuests = new ArrayList<>();
        runningQuests.add(questSystem.startQuest(player1, quest1));
        runningQuests.add(questSystem.startQuest(player2, quest2));

        runningQuests.forEach(quest ->
                quest.thenAccept(player -> log.info("{} has completed the quest and now has {} experience points.",
                        player.getName(), player.getExperience()))
                .join());
    }
}
