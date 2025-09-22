package school.faang.bjs2_92772;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class QuestSystem {
    static CompletableFuture<Player> startQuest(Player player, Quest quest) {
        log.debug("Игрок {} с опытом {} баллов приступает к квесту {}.",
                player.getName(), player.getExperience(), quest.getName());
        CompletableFuture<Player> completableFuturePlayer = CompletableFuture.supplyAsync(() -> {
            player.setExperience(player.getExperience() + quest.getReward());
            try {
                Thread.sleep(quest.getDifficulty());
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return player;
        });

        //
        //Оно здесь почему-то не дожидается Future. Поток main чешет напрямик, никого не ждет ))
        //

        log.debug("Игрок {} справился с квестом {}, теперь его опыт {}",
                player.getName(), quest.getName(), player.getExperience());
        return completableFuturePlayer;
    }
}
