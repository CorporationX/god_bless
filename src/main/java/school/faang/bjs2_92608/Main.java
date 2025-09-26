package school.faang.bjs2_92608;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Player firstPlayer = new Player("Джимми", 3, 87);
        Player secondPlayer = new Player("Карл", 100, 10000);

        Quest firstQuest = new Quest("Убраться в Казарме", Difficult.EASY, 1);
        Quest secondQuest = new Quest("Удалить Игру...", Difficult.PAIN, 1000000);

        CompletableFuture<Player> firstPlayerQuest = QuestSystem.startQuest(firstPlayer, firstQuest);
        firstPlayerQuest.thenAccept((player) -> {
            log.info("игрок {} прошел квест и имеет {} опыта", player.getName(), player.getExperience());
        });

        CompletableFuture<Player> secondPlayerQuest = QuestSystem.startQuest(secondPlayer, secondQuest);
        secondPlayerQuest.thenAccept((player) -> {
            log.info("игрок {} прошел квест и имеет {} опыта", player.getName(), player.getExperience());
        });

        QuestSystem.EXECUTOR.shutdown();
        try {
            if (!QuestSystem.EXECUTOR.awaitTermination(1, TimeUnit.MINUTES)) {
                QuestSystem.EXECUTOR.shutdownNow();
            }
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            QuestSystem.EXECUTOR.shutdownNow();
            throw new RuntimeException(e);
        }
    }
}
