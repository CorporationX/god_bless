package mod1sp4.bjs2_38616_wow;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();
        List<Player> players = new ArrayList<>(List.of(
                new Player("Thrall", 10, 250),
                new Player("Sylvanas", 12, 450)
        ));

        List<Quest> quests = new ArrayList<>(List.of(
                new Quest("Defeat the Lich King", 10, 150),
                new Quest("Retrieve the Sword of Azeroth", 8, 100)
        ));

        List<CompletableFuture<Player>> playerQuestsList = new ArrayList<>();
        for (int i = 0; i < players.size(); i++) {
            playerQuestsList.add(questSystem.startQuest(players.get(i), quests.get(i)));
        }
        CompletableFuture.allOf(playerQuestsList.toArray(new CompletableFuture[0])).join();
        players.forEach(player -> log.info("\nИмя игрока - {}, очки игрока: {}", player.getName(), player.getExperience()));
        questSystem.shutdownExecutor();
    }
}
