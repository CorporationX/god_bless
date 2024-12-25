package school.faang.sprint_4.task_wowbjs2n49989;

import lombok.extern.slf4j.Slf4j;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class WowMain {
    private static int MAIN_THREAD_WORK_TIME = 2000;

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
        List<Player> players = List.of(
                new Player("Thrall", 10, 250),
                new Player("Sylvanas", 12, 450),
                new Player("Sylvanas", 12, 580)
        );

        List<Quest> quests = List.of(
                new Quest("Defeat the Lich King", 10, 150),
                new Quest("Retrieve the Sword of Azeroth", 8, 100)
        );
        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);


        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        for (CompletableFuture<Player> playerCompletableFuture : Arrays.asList(player1Quest, player2Quest)) {
            playerCompletableFuture.thenAccept(player ->
                    log.info("{} has completed the quest and now has {} experience points.",
                            player.getName(), player.getExperience()));
        }

        try {
            Thread.sleep(MAIN_THREAD_WORK_TIME);
        } catch (InterruptedException e) {
            log.error(e.getMessage());
        }
    }
}
