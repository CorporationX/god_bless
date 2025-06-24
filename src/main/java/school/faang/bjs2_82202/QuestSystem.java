package school.faang.bjs2_82202;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
@RequiredArgsConstructor
public class QuestSystem {
    private final ExecutorService threadPool;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            try {
                log.info("{} начал выполнение квеста '{}'", player.getName(), quest.getName());
                Thread.sleep(quest.getDifficulty());
                log.info("{} завершил квест '{}'. Получено {} опыта",
                         player.getName(), quest.getName(), quest.getReward());

                player.setExperience(quest.getReward());

                return player;

            } catch (InterruptedException e) {
                log.error("Поток прерван. Квест не завершен");
                Thread.currentThread().interrupt();
                throw new RuntimeException("Поток прерван. Квест не завершен", e);
            }
        }, threadPool);
    }
}
