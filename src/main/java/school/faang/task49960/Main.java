package school.faang.task49960;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.stream.IntStream;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>(List.of(
                new Player("Thrall", 10, 250),
                new Player("Sylvanas", 12, 450)
        ));

        List<Quest> quests = new ArrayList<>(List.of(
                new Quest("Defeat the Lich King", Difficulty.HIGH, 150),
                new Quest("Retrieve the Sword of Azeroth", Difficulty.MIDDLE, 100)
        ));

        List<CompletableFuture<Void>> playersQuests = new ArrayList<>();
        QuestSystem questSystem = new QuestSystem();

        IntStream.range(0, quests.size()).forEach(i ->
                playersQuests.add(questSystem
                        .startQuest(players.get(i), quests.get(i))
                        .thenAccept(Main::questDone)));

        playersQuests.forEach(CompletableFuture::join);
    }


    private static void questDone(Player player) {
        log.info("{} выполнил квест. Текущие показатели: {}, {}",
                player.getName(), player.getExperience(), player.getLevel());
    }
}
