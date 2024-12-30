package school.faang.task_50124;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        List<Player> players = List.of(
                new Player("Thrall", 10, 250),
                new Player("Sylvanas", 12, 450)
        );

        List<Quest> quests = List.of(
                new Quest("Defeat the Lich King", 10, 150),
                new Quest("Retrieve the Sword of Azeroth", 8, 100)
        );

        List<CompletableFuture<Player>> allQuests = IntStream.range(0, quests.size())
                .mapToObj(i -> questSystem.startQuest(players.get(i), quests.get(i)))
                .toList();

        CompletableFuture.allOf(allQuests.toArray(CompletableFuture[]::new)).join();
    }

}
