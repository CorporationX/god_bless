package faang.school.godbless.BJS227756;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) throws InterruptedException {
        QuestSystem questSystem = new QuestSystem();

// Создание игроков
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);

// Создание заданий
        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

// Запуск заданий
        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

// Обработка результатов заданий
        player1Quest.thenAccept(player ->
                log.info(printQuestResult(player)));
        player2Quest.thenAccept(player ->
                log.info(printQuestResult(player)));
        questSystem.getExecutorService().shutdown();
        if (questSystem.getExecutorService().awaitTermination(30, TimeUnit.SECONDS)) {
            log.info("Finished");
        } else {
            log.error("Time out");
        }
    }
    private static String printQuestResult(Player player) {
        return String.format("%s has completed quest and now has %d level and %d experience",
                player.getName(), player.getLevel(), player.getExperience());
    }
}
