package faang.school.godbless.modul4.wow;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;

@Slf4j
@RequiredArgsConstructor
public class QuestSystem {
    private final ExecutorService executorService;

    public CompletableFuture<Player> startQuest(Player player, Quest quest) {
        var futurePlayer = CompletableFuture.supplyAsync(() -> {
            try {
                Thread.sleep(quest.getDifficulty() * 1000L);
            } catch (InterruptedException e) {
                log.error(e.getMessage());
                throw new RuntimeException();
            }

            player.setExperience(player.getExperience() + quest.getReward());
            return player;
        });

        executorService.shutdown();
        return futurePlayer;
    }
}