package school.faang.future_completable_future.bjs2_92579;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Main {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        questSystem.startQuest(player1, quest1)
                .thenAccept(Main::printMessage);

        questSystem.startQuest(player2, quest2)
                .thenAccept(Main::printMessage);

        QuestSystem.stopQuestProcessingAndAwaitTermination();

    }

    private static void printMessage(Player player) {
        log.info("{} ты выполнил квест, {} твой опыт увеличился.",
                player.getName().toUpperCase(), player.getExperience());
    }
}