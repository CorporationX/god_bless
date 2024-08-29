package faang.school.godbless.BJS2_25135;

import java.util.concurrent.CompletableFuture;
import java.util.stream.Stream;

public class WOW {
    public static void main(String[] args) {
        var questSystem = new QuestSystem();
        var player1 = new Player("Thrall", 10, 250);
        var player2 = new Player("Sylvanas", 12, 450);
        var quest1 = new Quest("Defeat the Lich King", 10, 150);
        var quest2 = new Quest("Retrieve the Sword of Azeroth", 8, 100);

        var playerQuest1 = questSystem.startQuest(player1, quest1);
        var playerQuest2 = questSystem.startQuest(player2, quest2);

        Stream.of(playerQuest1, playerQuest2)
                .peek(pq -> pq.thenAccept(player ->
                        System.out.printf("%s has completed the quest and now has %d experience points and his level is %d.\n",
                                player.getName(), player.getExperience(), player.getLevel())))
                .forEach(CompletableFuture::join);
    }
}