package school.faang.wow;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.atomic.AtomicInteger;

@Slf4j
public class Main {
    public static void main(String[] args) {
        List<Player> players = List.of(new Player("Bob", 1, 1),
                new Player("John", 2, 3),
                new Player("Jane", 3, 3));

        List<Quest> quests = List.of(new Quest("quest1", 1, 1),
                new Quest("quest2", 5, 3),
                new Quest("quest3", 4, 4));

        QuestSystem questSystem = new QuestSystem();
        CompletableFuture<Player> player1Quest = questSystem.startQuest(players.get(0), quests.get(0));
        CompletableFuture<Player> player2Quest = questSystem.startQuest(players.get(1), quests.get(1));
        CompletableFuture<Player> player3Quest = questSystem.startQuest(players.get(2), quests.get(2));

        player1Quest.thenAccept(player -> System.out.printf("Player %s has completed the quest %s " +
                "and now has %s experience\n", player.getName(), quests.get(0).getName(), player.getExperience()));
        player2Quest.thenAccept(player -> System.out.printf("Player %s has completed the quest %s " +
                "and now has %s experience\n", player.getName(), quests.get(1).getName(), player.getExperience()));
        player3Quest.thenAccept(player -> System.out.printf("Player %s has completed the quest %s " +
                "and now has %s experience\n", player.getName(), quests.get(2).getName(), player.getExperience()));

        ThreadPullSupplier.gracefullyShutdown();
        System.out.println("The end of the program");
    }
}
