package school.faang.sprint4.bjs_49997;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;

@Slf4j
public class Main {
    public static void main(String[] args) {

        QuestSystem questSystem = new QuestSystem();

        List<Player> players = new ArrayList<>(List.of(
                new Player("Thrall", 10, 250),
                new Player("Thor", 7, 170),
                new Player("Sylvanas", 12, 450)));
        List<Quest> quests = new ArrayList<>(List.of(
                new Quest("Defeat the Lich King", 10, 150),
                new Quest("Retrieve the Sword of Azeroth", 8, 100)));

        if (players.size() != quests.size()) {
            if (players.size() > quests.size()) {
                int diff = players.size() - quests.size();
                for (int i = 0; i < diff; i++) {
                    quests.add(quests.get(i));
                }
            } else {
                quests = quests.subList(0, players.size());
            }
        }

        ConcurrentHashMap<Player, Quest> questsMap = new ConcurrentHashMap<>();
        for (int i = 0; i < players.size(); i++) {
            questsMap.put(players.get(i), quests.get(i));
        }

        List<CompletableFuture<Player>> runQuests = questsMap.entrySet().stream()
                .map(entry -> questSystem.startQuest(entry.getKey(), entry.getValue()))
                .toList();

        runQuests.forEach(future -> future.thenAccept(player ->
                log.info("{} has completed the quest and now has {} experience points.",
                        player.getName(), player.getExperience())));

        CompletableFuture.allOf(runQuests.toArray(new CompletableFuture[0])).join();
    }
}
