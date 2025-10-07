package school.faang.wow;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

/**
 * Проект: god_bless
 * Класс Main
 * Автор: Vital
 */

public class Main {

    //Игроки
    private static final String PLAYER1_NAME = "Тралл";
    private static final int PLAYER1_LEVEL = 10;
    private static final int PLAYER1_XP = 250;

    private static final String PLAYER2_NAME = "Сильвана";
    private static final int PLAYER2_LEVEL = 12;
    private static final int PLAYER2_XP = 450;

    private static final String PLAYER3_NAME = "Джайна";
    private static final int PLAYER3_LEVEL = 15;
    private static final int PLAYER3_XP = 700;

    //Квесты
    private static final String QUEST1_NAME = "Победить Короля-лича";
    private static final int QUEST1_DIFFICULTY = 10;
    private static final int QUEST1_REWARD = 150;

    private static final String QUEST2_NAME = "Найти Меч Азерота";
    private static final int QUEST2_DIFFICULTY = 8;
    private static final int QUEST2_REWARD = 100;

    private static final String QUEST3_NAME = "Защитить деревню";
    private static final int QUEST3_DIFFICULTY = 5;
    private static final int QUEST3_REWARD = 50;

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        List<Player> players = List.of(
                new Player(PLAYER1_NAME, PLAYER1_LEVEL, PLAYER1_XP),
                new Player(PLAYER2_NAME, PLAYER2_LEVEL, PLAYER2_XP),
                new Player(PLAYER3_NAME, PLAYER3_LEVEL, PLAYER3_XP)
        );

        List<Quest> quests = List.of(
                new Quest(QUEST1_NAME, QUEST1_DIFFICULTY, QUEST1_REWARD),
                new Quest(QUEST2_NAME, QUEST2_DIFFICULTY, QUEST2_REWARD),
                new Quest(QUEST3_NAME, QUEST3_DIFFICULTY, QUEST3_REWARD)
        );

        List<CompletableFuture<Player>> futures = startAllQuests(questSystem, players, quests);

        futures.forEach(future -> future.thenAccept(player ->
                System.out.println("Игрок " + player.getName() +
                        " завершил квест и теперь имеет " +
                        player.getExperience() + " очков опыта и уровень " + player.getLevel())
        ));

        CompletableFuture<Void> allQuests = CompletableFuture.allOf(futures.toArray(new CompletableFuture[0]));
        allQuests.thenRun(() -> System.out.println("Все квесты успешно завершены!"));
        allQuests.join();
    }

    private static List<CompletableFuture<Player>> startAllQuests(QuestSystem questSystem,
                                                                  List<Player> players,
                                                                  List<Quest> quests) {
        if (players.size() != quests.size()) {
            throw new IllegalArgumentException("Списки игроков и квестов должны быть одинакового размера");
        }

        return IntStream.range(0, players.size())
                .mapToObj(i -> questSystem.startQuest(players.get(i), quests.get(i)))
                .toList();
    }
}