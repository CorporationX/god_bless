package school.faang.bjs2_74534;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player firstPlayer = new Player("Thrall", 10, 250);
        Player secondPlayer = new Player("Sylvanas", 12, 450);

        Quest firstQuest = new Quest("Defeat the Lich King", 10, 150);
        Quest secondQuest = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture.allOf(
                Stream.of(questSystem.startQuest(firstPlayer, firstQuest),
                        questSystem.startQuest(firstPlayer, secondQuest),
                        questSystem.startQuest(secondPlayer, secondQuest)
                    )
                    .map(future -> future.thenAccept(questSystem::onQuestCompletion)
                        .exceptionally(er -> {
                            log.error(er.getMessage());
                            return null;
                        }))
                    .toArray(CompletableFuture[]::new)
            )
            .join();

        questSystem.shutdown();
    }
}
