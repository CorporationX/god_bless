package school.faang.bjs2_82265;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CompletableFuture;

@Slf4j
public class Main {
    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        Player thrall = new Player("Thrall", 10, 250);
        Player sylvanas = new Player("Sylvanas", 12, 450);

        Quest lichKing = new Quest("Defeat the Lich King", 10, 150);
        Quest swordOfAzeroth = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        CompletableFuture<Player> thrallQuest = questSystem.startQuest(thrall, lichKing);
        CompletableFuture<Player> sylvanasQuest = questSystem.startQuest(sylvanas, swordOfAzeroth);

        thrallQuest.thenAccept(player ->
                log.info(player.getName() + " has completed the quest " +
                        "and now has " + player.getExperience() + " experience points."));
        sylvanasQuest.thenAccept(player ->
                log.info(player.getName() + " has completed the quest " +
                        "and now has " + player.getExperience() + " experience points."));
    }
}
