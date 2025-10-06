package school.faang.bjs2_92608;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Player firstPlayer = new Player("Джимми", 3, 87);
        Player secondPlayer = new Player("Карл", 100, 10000);

        Quest firstQuest = new Quest("Убраться в Казарме", Quest.Difficult.EASY, 1);
        Quest secondQuest = new Quest("Удалить Игру...", Quest.Difficult.PAIN, 1000000);

        QuestSystem.startQuest(firstPlayer, firstQuest)
                .thenAccept((Player::logPlayerCompletedQuest));

        QuestSystem.startQuest(secondPlayer, secondQuest)
                .thenAccept((Player::logPlayerCompletedQuest));

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
