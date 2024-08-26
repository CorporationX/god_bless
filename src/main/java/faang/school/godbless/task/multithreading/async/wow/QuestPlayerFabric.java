package faang.school.godbless.task.multithreading.async.wow;

import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class QuestPlayerFabric {
    private final int MAX_DIFFICULT = 5_000;
    private final int MIN_DIFFICULT = 1_000;
    private final int REWARD_BY_DIFFICULT = 10;

    private static final Random random = new Random();
    private final int numberOfPlayers;
    private final int numberOfQuests;

    public QuestPlayerFabric(int numberOfPlayers) {
        this.numberOfPlayers = numberOfPlayers;
        this.numberOfQuests = numberOfPlayers;
    }

    public List<Player> getPlayers() {
        return IntStream
                .rangeClosed(1, numberOfPlayers)
                .mapToObj(i -> new Player("Player " + i))
                .toList();
    }

    public List<Quest> getQuests() {
        return IntStream
                .rangeClosed(1, numberOfQuests)
                .mapToObj(i -> new Quest("Quest " + i, getDifficult(), REWARD_BY_DIFFICULT))
                .toList();
    }

    private int getDifficult() {
        return random.nextInt(MAX_DIFFICULT - MIN_DIFFICULT) + MIN_DIFFICULT;
    }
}
