package school.faang.task_50026;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        List<Player> players = new ArrayList<>(List.of(
                new Player("Player1", 4, 250),
                new Player("Player2", 6, 450)
        ));

        List<Quest> quests = new ArrayList<>(List.of(
                new Quest("Квест1", 3, 150),
                new Quest("Квест2", 2, 100)
        ));

        CompletableFuture<Player> player1Quest = questSystem.startQuest(players.get(0), quests.get(0));
        CompletableFuture<Player> player2Quest = questSystem.startQuest(players.get(1), quests.get(1));

        player1Quest.thenAccept(player ->
                log.info("{} выполнил задание и теперь у него есть {} очков опыта и находится на уровне {}",
                        player.getName(), player.getExperience(), player.getLevel()));
        player2Quest.thenAccept(player ->
                log.info("{} выполнил задание и теперь у него есть {} очков опыта и находится на уровне {}",
                        player.getName(), player.getExperience(), player.getLevel()));

        CompletableFuture<Void> allQuests = CompletableFuture.allOf(player1Quest, player2Quest);
        allQuests.join();

        log.info("Все квесты завершены");
    }
}