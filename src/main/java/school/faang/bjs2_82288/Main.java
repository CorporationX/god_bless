package school.faang.bjs2_82288;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player nicholas = new Player("Nicholas", 10, 50);
        Player kevin = new Player("Kevin", 8, 80);
        Player elizabeth = new Player("Liz", 7, 120);

        Quest quest1 = new Quest("пройти дарк соулс 1 без смертей", 2, 50);
        Quest quest2 = new Quest("пройти дарк соулс 2 без смертей", 3, 100);
        Quest quest3 = new Quest("пройти дарк соулс 3 без смертей", 1, 25);

        CompletableFuture<Player> quest1Result = questSystem.startQuest(kevin, quest1);
        CompletableFuture<Player> quest2Result = questSystem.startQuest(nicholas, quest2);
        CompletableFuture<Player> quest3Result = questSystem.startQuest(elizabeth, quest3);

        quest1Result.thenAccept(player -> log.info("игрок {} выполнил квест: {}\n   текущий опыт {}: {}",
                player.getName(), quest1.getName(), player.getName(), player.getExperience()));
        quest2Result.thenAccept(player -> log.info("игрок {} выполнил квест: {}\n   текущий опыт {}: {}",
                player.getName(), quest2.getName(), player.getName(), player.getExperience()));
        quest3Result.thenAccept(player -> log.info("игрок {} выполнил квест: {}\n   текущий опыт {}: {}",
                player.getName(), quest3.getName(), player.getName(), player.getExperience()));

        CompletableFuture.allOf(quest1Result, quest2Result, quest3Result).join();
        log.info("все квесты завершены");

        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
