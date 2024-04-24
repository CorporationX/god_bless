package faang.school.godbless.module.fourth.async.wow;

import java.util.concurrent.CompletableFuture;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class QuestSystem {
    public static void main(String[] args) {
        // Создание игроков
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
        
        // Создание заданий
        Quest quest1 = new Quest("Defeat the Lich King", 10, 150);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);
        
        CompletableFuture<Void> future1 = startQuest(player1, quest1).thenAccept((futurePlayer) -> log.info(
                "Теперь игрок {} имеет уровень {}",
                futurePlayer.getName(),
                futurePlayer.getLevel()
            ));
        CompletableFuture<Void> future2 = startQuest(player2, quest2).thenAccept((futurePlayer) -> log.info(
                "Теперь игрок {} имеет уровень {}",
                futurePlayer.getName(),
                futurePlayer.getLevel()
            ));
        future1.join();
        future2.join();
    }
    
    public static CompletableFuture<Player> startQuest(Player player, Quest quest) {
        return CompletableFuture.supplyAsync(() -> {
            log.info("Игрок {}, выполняет квест {}", player.getName(), quest.getName());
            try {
                Thread.sleep(quest.getDifficulty() * 100);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return player;
        }).thenApply((futurePlayer) -> {
            futurePlayer.addLevel();
            return futurePlayer;
        });
    }
}
