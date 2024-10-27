package school.faang.BJS238542;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int THREAD_POOL_SIZE = 2;
    private static final int WAITING_TIME = 1;

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        List<Player> players = List.of(
                new Player("Thrall", 10, 250),
                new Player("Sylvanas", 12, 450));
        List<Quest> quests = List.of(
                new Quest("Defeat the Lich King", 10, 150),
                new Quest("Retrieve the Sword of Azeroth", 8, 100)
        );
        ExecutorService service = Executors.newFixedThreadPool(THREAD_POOL_SIZE);

        List<CompletableFuture<Player>> playerQuests = new ArrayList<>();

        for (int i = 0; i < quests.size(); i++) {
            playerQuests.add(questSystem.startQuest(players.get(i), quests.get(i), service));
        }
        service.shutdown();
        try {
            if (!service.awaitTermination(WAITING_TIME, TimeUnit.MINUTES)) {
                log.error("Кто-то не закончил квест!");
                service.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Произошла ошибка: {}", e.getMessage());
            e.printStackTrace();
        }
    }
}
