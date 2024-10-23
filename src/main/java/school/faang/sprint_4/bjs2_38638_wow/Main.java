package school.faang.sprint_4.bjs2_38638_wow;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Player> players = new ArrayList<>(List.of(
                new Player("Newbie"),
                new Player("PewPwner"),
                new Player("Nagibator")));
        List<Quest> quests = new ArrayList<>(List.of(
                new Quest("Defeat the Lich King", 10, 250),
                new Quest("Retrieve the Sword of Azeroth", 5, 100),
                new Quest("Find the Lost Relic", 4, 90),
                new Quest("Slay the Dragon", 9, 220),
                new Quest("Explore the Forbidden Forest", 6, 80),
                new Quest("Rescue the Captive Princess", 5, 70),
                new Quest("Uncover the Ancient Tomb", 7, 95),
                new Quest("Defend the Village", 4, 60),
                new Quest("Hunt the Shadow Beast", 8, 180),
                new Quest("Retrieve the Sacred Artifact", 9, 130)));

        QuestSystem questSystem = new QuestSystem();
        List<CompletableFuture<Player>> questedPlayers = new ArrayList<>();

        players.forEach(player ->
                questedPlayers.add(questSystem.startQuesting(player, quests)));

        CompletableFuture.allOf(questedPlayers.toArray(new CompletableFuture[0])).join();
        questSystem.shutDownExecutor();
    }
}
