package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        Player player1 = new Player("Rick");
        Player player2 = new Player("Morty");

        Quest quest1 = new Quest("Здаание на 15 минут, зашли-вышли", 10, 1000);
        Quest quest2 = new Quest("Рикатастрофа 4-го рода", 2, 200);

        CompletableFuture<Player> player1Quest1 = QuestSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest2 = QuestSystem.startQuest(player2, quest2);

        while (!player1Quest1.isDone() || !player2Quest2.isDone()) {
            player1Quest1.join();
            player2Quest2.join();
        }

        player1Quest1.thenAccept(player ->
                log.info("после выполнения 1 квеста у игрока {} {} опыта", player.getName(), player.getExperience()));
        player2Quest2.thenAccept(player ->
                log.info("после выполнения 2 квеста у игрока {} {} опыта", player.getName(), player.getExperience()));
    }
}
