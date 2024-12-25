package school.faang.sprint4.bjs_50045;

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

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        printResult(player1Quest);
        printResult(player2Quest);

        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }

    private static void printResult(CompletableFuture<Player> playerQuest) {
        playerQuest.thenAccept(player ->
                log.info("Игрок {} закончил выполнение квеста и теперь в сумме имеет {} очков опыта",
                        player.getName(),
                        player.getExperience()
                ));
    }
}
