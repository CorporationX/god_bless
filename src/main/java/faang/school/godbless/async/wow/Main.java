package faang.school.godbless.async.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);
        Quest quest3 = new Quest("I am murlok!", 12, 230);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);
        CompletableFuture<Player> player1Quest2 = questSystem.startQuest(player1, quest3);
        CompletableFuture<Player> player2Quest2 = questSystem.startQuest(player2, quest3);

        player1Quest.thenAccept(Main::resultMessage);
        player2Quest.thenAccept(Main::resultMessage);
        player1Quest2.thenAccept(Main::resultMessage);
        player2Quest2.thenAccept(Main::resultMessage);
    }

    private static void resultMessage(Player player) {
        log.info(player.getName() + " has completed the quest and now has " + player.getExperience() + " experience points.");
    }

}
