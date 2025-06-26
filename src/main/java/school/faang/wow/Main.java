package school.faang.wow;

import lombok.extern.slf4j.Slf4j;
import school.faang.wow.domain.Player;
import school.faang.wow.domain.Quest;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

/**
 * @author Danil Pudovkin
 * @since 26.06.2025
 */
@Slf4j
public class Main {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        var player1 = new Player("Thrall", 10, 250);
        var player2 = new Player("Sylvanas", 12, 450);

        var quest1 = new Quest("Defeat the Lich King", 10, 150);
        var quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        var player1Quest = questSystem.startQuest(player1, quest1);
        var player2Quest = questSystem.startQuest(player2, quest2);

        Consumer<Player> logCompletedQuest = player ->
                log.info("Игрок {} закончил квест и сейчас имеет {} единиц опыта",
                        player.getName(), player.getExperience());
        player1Quest.thenAccept(logCompletedQuest);
        player2Quest.thenAccept(logCompletedQuest);
        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }
}
