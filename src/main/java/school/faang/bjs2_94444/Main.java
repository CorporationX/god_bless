package school.faang.bjs2_94444;

import lombok.extern.slf4j.Slf4j;

import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        QuestSystem questSystem = new QuestSystem();
        Player player1 = new Player("Цыбуля", 0, 0.0);
        Player player2 = new Player("Я вар!", 0, 0.0);
        Quest quest1 = new Quest("Defeat the Lich King", 10, random.nextDouble(1, 150));
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", 8, random.nextDouble(1, 100));
        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);
        player1Quest.thenAccept(player -> log.info("{} - Пришел в Оргримар", player.getName()));
        player2Quest.thenAccept(player -> log.info("{} - Пришел в Даларан", player.getName()));
    }
}
