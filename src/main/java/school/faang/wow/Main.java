package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Победить Короля Лича", 10, 150);
        Quest quest2 = new Quest("Верните Меч Азерота", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(Main::printQuestCompletedMessage);
        player2Quest.thenAccept(Main::printQuestCompletedMessage);
        player1Quest.join();
        player2Quest.join();
    }

    private static void printQuestCompletedMessage(Player player) {
        System.out.println(player.getName() +
                " выполнил квест и теперь имеет " + player.getExperience() + " очки опыта.");
    }
}
