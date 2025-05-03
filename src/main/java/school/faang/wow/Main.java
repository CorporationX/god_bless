package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player player1 = new Player("Thrall", 10, 200);
        Player player2 = new Player("Sylvanas", 12, 450);

        Quest quest1 = new Quest("Defeat the Lich King", DifficultyQuest.HARD, 200);
        Quest quest2 = new Quest("Retrieve the Sword of Azeroth", DifficultyQuest.LEGEND, 200);
        Quest quest3 = new Quest("Retrieve the Sword of Azeroth", DifficultyQuest.NORMAL, 50);


        List<CompletableFuture<Player>> quest = List.of(
                questSystem.startQuest(player1, quest1),
                questSystem.startQuest(player2, quest1),
                questSystem.startQuest(player1, quest3),
                questSystem.startQuest(player2, quest2)
        );

        quest.stream()
                .peek(future -> future.thenAccept(player -> {
                    log.info("игрок {} выполнил задание, текущий опыт {}",
                            player.getName(), player.getExperience().get());
                }).exceptionally(exception -> {
                    log.error("Исключение", exception);
                    return null;
                }))
                .forEach(CompletableFuture::join);

        questSystem.terminatedExecutor();
    }
}