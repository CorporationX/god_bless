package school.faang.bjs2_82245;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@AllArgsConstructor
public class QuestSystem {
    private static final Random random = new Random();

    private final ExecutorService poolThread;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(
                        () -> {
                            log.info("Игрок {} начал выполнение квеста \"{}\"", player.getName(), quest.getName());
                            try {
                                TimeUnit.SECONDS.sleep(random.nextInt(7));
                            } catch (InterruptedException e) {
                                log.error("Квест {} прерван", quest.getName(), e);
                                throw new RuntimeException("Прервано выполнение квеста", e);
                            }
                            log.info("Игрок {} выполнил квест \"{}\"!", player.getName(), quest.getName());
                            return quest.getReward();
                        },
                        poolThread)
                .thenApplyAsync(reward -> {
                    player.gainExperience(reward);
                    return player;
                });
    }
}
