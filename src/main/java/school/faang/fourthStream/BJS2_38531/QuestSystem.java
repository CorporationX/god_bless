package school.faang.fourthStream.BJS2_38531;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

@Slf4j
public class QuestSystem {
    ExecutorService executor = Executors.newCachedThreadPool();

    public void startQuest(Player player, Quest quest) {
        if (player.getLevel() < quest.getDifficulty()) {
            log.info("Игрок {} не готов для задания {}! Выберите другое задание", player.getName(), quest.getName());
        } else {
            CompletableFuture.supplyAsync(() -> {
                        log.info("Игрок {} проходит задание {}\n", player.getName(), quest.getName());
                        try {
                            Thread.sleep(quest.getDifficulty() * 1000L);
                        } catch (InterruptedException e) {
                            log.error("Поток был прерван", e);
                        }
                        player.addExperience(quest.getReward());
                        player.upgradeLevel(quest.getDifficulty());

                        return player;
                    }, executor)
                    .thenAccept(playerResult -> log.info("{} выполнил задание и теперь имеет {} очков опыта и {} уровень.\n"
                            , player.getName(), player.getExp(), player.getLevel()));
        }
    }

    public void shutdownService() {
        executor.shutdown();
        try {
            if (!executor.awaitTermination(30, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
        } catch (InterruptedException e) {
            log.error("Поток был прерван", e);
        }
    }
}
