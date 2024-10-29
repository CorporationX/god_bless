package wow;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Main {
    private static final int COUNT_OF_PLAYERS_AND_QUESTS = 5;
    private static final int DEFAULT_LEVEL = 10;
    private static final int DEFAULT_EXPERIENCE = 25;
    private static final int DEFAULT_DIFFICULTY = 5;
    private static final int DEFAULT_REWARD = 30;

    public static void main(String[] args) {
        QuestSystem questSystem = new QuestSystem();

        List<Player> players = getPlayers(COUNT_OF_PLAYERS_AND_QUESTS);
        List<Quest> quests = getQuests(COUNT_OF_PLAYERS_AND_QUESTS);

        List<CompletableFuture<Player>> playersAndQuests = new ArrayList<>();
        for (int i = 0; i < COUNT_OF_PLAYERS_AND_QUESTS; i++) {
            playersAndQuests.add(questSystem.startQuest(players.get(i), quests.get(i)));
        }

        playersAndQuests.stream()
                .peek(completableFuture -> completableFuture.thenAccept(player -> System.out.printf(
                        "%s закончил квест, общее кол-во опыта: %d. \n",
                        player.getName(), player.getExperience())))
                .forEach(CompletableFuture::join);
    }

    public static List<Player> getPlayers(int count) {
        List<Player> players = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            players.add(new Player(String.format("player %d", i), DEFAULT_LEVEL, DEFAULT_EXPERIENCE));
        }
        return players;
    }

    public static List<Quest> getQuests(int count) {
        List<Quest> quests = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            quests.add(new Quest(String.format("quest %d", i), DEFAULT_DIFFICULTY, DEFAULT_REWARD));
        }
        return quests;
    }
}