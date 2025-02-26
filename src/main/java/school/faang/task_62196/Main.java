package school.faang.task_62196;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final String COMPLETED_QUEST_MESSAGE
            = "Игрок \"{}\" выполнил задание и теперь имеет {} очков опыта.";

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player thrall = new Player("Thrall", 10, 250);
        Player sylvanas = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 5, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(thrall, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(sylvanas, quest2);

        player1Quest.thenAccept(
                player -> log.info(COMPLETED_QUEST_MESSAGE, player.getName(), player.getExperience())
        );
        player2Quest.thenAccept(
                player -> log.info(COMPLETED_QUEST_MESSAGE, player.getName(), player.getExperience())
        );

        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }
}
