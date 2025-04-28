package school.faang.bjs2_74534;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final String TASK_RESULT = "{} has completed the quest and now has {} experience points.";

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player firstPlayer = new Player("Thrall", 10, 250);
        Player secondPlayer = new Player("Sylvanas", 12, 450);

        Quest firstQuest = new Quest("Defeat the Lich King", 10, 150);
        Quest secondQuest = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        List<CompletableFuture<Player>> workingQuest = List.of(
            questSystem.startQuest(firstPlayer, firstQuest),
            questSystem.startQuest(firstPlayer, secondQuest),
            questSystem.startQuest(secondPlayer, secondQuest)
        );
        workingQuest.forEach(playerQuest -> playerQuest.thenAccept(Main::acceptInfo));
        questSystem.shutdown();
    }

    private static void acceptInfo(Player player) {
        log.info(TASK_RESULT, player.getName(), player.getExperience());
    }
}
