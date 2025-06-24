package school.faang.bjs2_82202;

import lombok.extern.slf4j.Slf4j;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

@Slf4j
public class Main {
    private static final int POOL_AWAIT_TIMEOUT = 20;
    private static ExecutorService fixedPool = Executors.newFixedThreadPool(Runtime.getRuntime()
                                                                                     .availableProcessors());
    private static QuestSystem questSystem = new QuestSystem(fixedPool);

    public static void main(String[] args) {
        List<Quest> quests = List.of(new Quest("Помочь NPC", QuestType.EASY),
                                     new Quest("Уничтожить монстров", QuestType.HARD),
                                     new Quest("Собрать предметы", QuestType.MEDIUM));

        List<Player> players = List.of(new Player("ubivator228"),
                                       new Player("SweetCat"),
                                       new Player("BadHealer"));


        List<CompletableFuture<Player>> futures = new ArrayList<>();
        ThreadLocalRandom random = ThreadLocalRandom.current();
        for (int i = 0; i < 6; i++) {
            futures.add(questSystem.startQuest(players.get(random.nextInt(players.size())),
                                               quests.get(random.nextInt(quests.size()))));
        }

        CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]))
                .thenAccept(param -> futures.stream()
                        .map(CompletableFuture::join)
                        .distinct()
                        .forEach(player -> log.info("{} текущий уровень {} и кол-во опыта {}",
                                                    player.getName(),
                                                    player.getLevel(),
                                                    player.getExperience()))).join();

        fixedPool.shutdown();

        try {
            while (!fixedPool.awaitTermination(POOL_AWAIT_TIMEOUT, TimeUnit.SECONDS)) {
                log.info("Не все задачи завершены");
                fixedPool.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
            Thread.currentThread().interrupt();
            fixedPool.shutdownNow();
        }
        log.info("Все квесты завершены");
    }
}
