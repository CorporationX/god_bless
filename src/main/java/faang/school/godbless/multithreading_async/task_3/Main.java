package faang.school.godbless.multithreading_async.task_3;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        final QuestSystem questSystem = new QuestSystem();

        final Player player1 = new Player("Thrall", 10, 250);
        final Player player2 = new Player("Sylvanas", 12, 450);

        final Quest quest1 = new Quest("Defeat the Lich King", Difficulty.ULTRA, 150);
        final Quest quest2 = new Quest("Retrieve the Sword of Azeroth", Difficulty.HARD, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(Main::logQuestCompletion);
        player2Quest.thenAccept(Main::logQuestCompletion);
        questSystem.shutdown();
    }

    private static void logQuestCompletion(Player player) {
        log.info("{} has completed the quest and now has {} experience points.", player.getName(), player.getExperience());
    }
}
