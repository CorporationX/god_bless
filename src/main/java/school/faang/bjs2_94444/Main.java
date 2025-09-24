package school.faang.bjs2_94444;

import lombok.extern.slf4j.Slf4j;
import java.util.Random;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    private static final int DEFAULT_LEVEL = 0;
    private static final double DEFAULT_EXPERIENCE = 0.0;
    private static final int DEFAULT_DIFFICULT = 10;
    private static final double EXPERIENCE = 500;
    private static final int START_VALUE_SEEDS = 1;

    public static void main(String[] args) {
        Random random = new Random();
        QuestSystem questSystem = new QuestSystem();
        Player player1 = new Player("Цыбуля", DEFAULT_LEVEL, DEFAULT_EXPERIENCE);
        Player player2 = new Player("Я вар!", DEFAULT_LEVEL, DEFAULT_EXPERIENCE);
        Quest quest1 = new Quest(
                "Defeat the Lich King",
                random.nextInt(START_VALUE_SEEDS, DEFAULT_DIFFICULT),
                random.nextDouble(START_VALUE_SEEDS, EXPERIENCE)
        );
        Quest quest2 = new Quest(
                "Retrieve the Sword of Azeroth",
                random.nextInt(START_VALUE_SEEDS, DEFAULT_DIFFICULT),
                random.nextDouble(START_VALUE_SEEDS, EXPERIENCE)
        );
        CompletableFuture<Player> player1Quest = questSystem.startQuest(player1, quest1);
        CompletableFuture<Player> player2Quest = questSystem.startQuest(player2, quest2);
        player1Quest.thenAccept(player -> log.info("{} - Пришел в Оргримар", player.getName()));
        player2Quest.thenAccept(player -> log.info("{} - Пришел в Даларан", player.getName()));
    }
}
