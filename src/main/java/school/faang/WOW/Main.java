package school.faang.WOW;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Тралл", 10, 250);
        Player player2 = new Player("Сильвана", 12, 450);

        Quest quest1 = new Quest("Король - Лич", 10, 150);
        Quest quest2 = new Quest("Битва за Азерот", 8, 100);

        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);

        player1Quest.thenAccept(player ->
                log.info("{} завершил квест и заработал {} очков опыта.", player.getName(), player.getExp())
        );

        player2Quest.thenAccept(player ->
                log.info("{} завершил квест и заработал {} очков опыта.", player.getName(), player.getExp())
        );

        CompletableFuture.allOf(player1Quest, player2Quest).join();
    }
}