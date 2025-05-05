package school.faang.bjs2_74719;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Game {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        Player player1 = new Player("Thrall", 10, 250);
        Player player2 = new Player("Sylvanas", 12, 450);
        Quest quest1 = new Quest("Defeat the Lich King", 10, 1200);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 1175);
        CompletableFuture<Void> player1Quest = questSystem.startQuest(player1, quest1)
                .thenAccept(player -> log.info("Player {} completed quest {};", player.getName(), quest1.name()));
        CompletableFuture<Void> player2Quest = questSystem.startQuest(player2, quest2)
                .thenAccept(player -> log.info("Player {} completed quest {};", player.getName(), quest1.name()));
        player1Quest.join();
        player2Quest.join();
        questSystem.dispose();
    }
}